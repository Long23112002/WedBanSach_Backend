package com.example.wedbansach_springboot_be.service.impl;

import com.example.wedbansach_springboot_be.entity.NguoiDung;
import com.example.wedbansach_springboot_be.entity.Quyen;
import com.example.wedbansach_springboot_be.repository.NguoiDungRepository;
import com.example.wedbansach_springboot_be.repository.QuyenRepository;
import com.example.wedbansach_springboot_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    private QuyenRepository quyenRepository;

    @Autowired
    public UserServiceImpl(NguoiDungRepository nguoiDungRepository, QuyenRepository quyenRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
        this.quyenRepository = quyenRepository;
    }


    @Override
    public NguoiDung findByUsername(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
    }

    @Override
    public String checkDiaChiGiaoHang(String tenDangNhap) {
        System.out.println("Input tenDangNhap: " + tenDangNhap);
        NguoiDung result = nguoiDungRepository.findDiaChiGiaoHangNative(tenDangNhap);
        System.out.println("Result from repository: " + result);

        if (result != null) {
            return result.getDiaChiGiaoHang();
        } else {
            return "Result is null";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nguoiDung = findByUsername(username);
        if (nguoiDung == null) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại!");
        }
        System.out.println("User roles: " + rolesToAuthorities(nguoiDung.getDanhSachQuyen()));
        return new User(nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau(), rolesToAuthorities(nguoiDung.getDanhSachQuyen()));

    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Quyen> quyens) {
        return quyens.stream().map(quyen -> new SimpleGrantedAuthority(quyen.getTenQuyen())).collect(Collectors.toList());
    }


}