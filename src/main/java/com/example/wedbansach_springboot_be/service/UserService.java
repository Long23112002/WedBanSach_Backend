package com.example.wedbansach_springboot_be.service;

import com.example.wedbansach_springboot_be.entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);
    public  String checkDiaChiGiaoHang(String tenDangNhap);

}