package com.example.wedbansach_springboot_be.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonHangRequest {

    private  Double chiPhiGiaoHang;

    private  Double chiPhiThanhToan;

    private String diaChiMuaHang;

    private String diaChiNhanHang;

    private Double tongTien;

    private Double tongSanPham;

    private Integer hinhThucGiaoHang;

    private Integer hinhThucThanhToan;

    private Integer maNguoiDung;

    private String soDienThoaiGiaoHang;

}
