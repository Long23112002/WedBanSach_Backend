package com.example.wedbansach_springboot_be.service;

import com.example.wedbansach_springboot_be.entity.DonHang;
import com.example.wedbansach_springboot_be.request.DonHangRequest;

public  interface DonHangService  {
    String saveDonHang(DonHangRequest donHang);
}
