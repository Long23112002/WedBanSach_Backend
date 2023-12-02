package com.example.wedbansach_springboot_be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "hinh_thuc_thanh_toan")
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_thuc_thanh_toan")
    private int maHinhThucGiaoHang;
    @Column(name = "ten_hinh_thuc_thanh_toan" , columnDefinition = "NVARCHAR(256)")
    private String tenHinhThucGiaoHang;
    @Column(name = "mo_ta",columnDefinition = "NVARCHAR(MAX)")
    private String moTa;
    @Column(name = "chi_phi_thanh_toan")
    private double chiPhiGiaoHang;

    @OneToMany(mappedBy ="hinhThucThanhToan" ,fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<DonHang> danhSachDonHang;
}