package com.example.wedbansach_springboot_be.service.impl;

import com.example.wedbansach_springboot_be.entity.DonHang;
import com.example.wedbansach_springboot_be.entity.HinhThucGiaoHang;
import com.example.wedbansach_springboot_be.entity.HinhThucThanhToan;
import com.example.wedbansach_springboot_be.entity.NguoiDung;
import com.example.wedbansach_springboot_be.repository.DonHangRepository;
import com.example.wedbansach_springboot_be.repository.HinhThucGiaoHangRepository;
import com.example.wedbansach_springboot_be.repository.HinhThucThanhToanRepository;
import com.example.wedbansach_springboot_be.repository.NguoiDungRepository;
import com.example.wedbansach_springboot_be.request.DonHangRequest;
import com.example.wedbansach_springboot_be.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class DonHangImpl implements DonHangService {

    @Autowired
    private HinhThucGiaoHangRepository hinhThucGiaoHangRepository;

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private HinhThucThanhToanRepository hinhThucThanhToanRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public String saveDonHang(DonHangRequest donHang) {

        Optional<HinhThucGiaoHang> checkHinhThucGiaoHang = hinhThucGiaoHangRepository.findById(donHang.getHinhThucGiaoHang());
        Optional<HinhThucThanhToan> checkHinhThucThanhToan = hinhThucThanhToanRepository.findById(donHang.getHinhThucGiaoHang());
        Optional<NguoiDung> checkNguoiDung = nguoiDungRepository.findById(donHang.getMaNguoiDung());
        if (checkHinhThucGiaoHang.isEmpty()) {
            return "Hình thức giao hàng không tồn tại";
        }

        if (checkHinhThucThanhToan.isEmpty()) {
            return "Hình thức thanh toán không tồn tại";
        }


        DonHang donHang1 = new DonHang();
        donHang1.setChiPhiGiaoHang(donHang.getChiPhiGiaoHang());
        donHang1.setChiPhiThanhToan(donHang.getChiPhiThanhToan());
        donHang1.setDiaChiMuaHang(donHang.getDiaChiMuaHang());
        donHang1.setDiaChiNhanHang(donHang.getDiaChiNhanHang());
        donHang1.setNgayTao(new Date(System.currentTimeMillis()));
        donHang1.setTongTien(donHang.getTongTien());
        donHang1.setHinhThucGiaoHang(checkHinhThucGiaoHang.get());
        donHang1.setHinhThucThanhToan((checkHinhThucThanhToan.get()));
        donHang1.setSoDienThoaiGiaoHang(donHang.getSoDienThoaiGiaoHang());
        donHang1.setNguoiDung(checkNguoiDung.get());
        donHangRepository.save(donHang1);
        return "Thêm đơn hàng thành công";
    }
}
