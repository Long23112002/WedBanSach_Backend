package com.example.wedbansach_springboot_be.repository;

import com.example.wedbansach_springboot_be.entity.HinhThucGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource(path = "hinh-thuc-giao-hang")
public interface HinhThucGiaoHangRepository extends JpaRepository<HinhThucGiaoHang, Integer> {

    Optional<HinhThucGiaoHang> findByTenHinhThucGiaoHang(String tenHinhThucGiaoHang);

}