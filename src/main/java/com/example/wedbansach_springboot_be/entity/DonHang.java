package com.example.wedbansach_springboot_be.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.util.List;
@Entity
@Data
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private int maDonHang;

    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "dia_chi_mua_hang", length = 512 , columnDefinition = "NVARCHAR(512)")
    private String diaChiMuaHang;
    @Column(name = "dia_chi_nhan_hang", length = 512 , columnDefinition = "NVARCHAR(512)")
    private String diaChiNhanHang;
    @Column(name = "tong_tien_san_pham")
    private double tongTienSanPham;
    @Column(name = "chi_phi_giao_hang")
    private double chiPhiGiaoHang;
    @Column(name = "chi_phi_thanh_toan")
    private double chiPhiThanhToan;
    @Column(name = "tong_tien")
    private double tongTien;

    @Column(name = "so_dien_thoai_giao_hang" )
    private String soDienThoaiGiaoHang;


    @OneToMany(mappedBy = "donHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ChiTietDonHang> danhSachChiTietDonHang;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_nguoi_dung", nullable = false)
    private NguoiDung nguoiDung;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_hinh_thuc_thanh_toan")
    private HinhThucThanhToan hinhThucThanhToan;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_hinh_thuc_giao_hang")
    private HinhThucGiaoHang hinhThucGiaoHang;
}