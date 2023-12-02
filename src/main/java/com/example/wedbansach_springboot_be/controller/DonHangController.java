package com.example.wedbansach_springboot_be.controller;

import com.example.wedbansach_springboot_be.entity.DonHang;
import com.example.wedbansach_springboot_be.request.DonHangRequest;
import com.example.wedbansach_springboot_be.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/don-hang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;

    @PostMapping("/them-don-hang")
    public ResponseEntity<?> themDonHang(@RequestBody DonHangRequest donHangRequest){
       return new ResponseEntity<>(donHangService.saveDonHang(donHangRequest), org.springframework.http.HttpStatus.OK);

    }

}
