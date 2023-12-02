package com.example.wedbansach_springboot_be.repository;

import com.example.wedbansach_springboot_be.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(path = "nguoi-dung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    public boolean existsByTenDangNhap(String tenDangNhap);

    public boolean existsByEmail(String email);

    public NguoiDung findByTenDangNhap(String tenDangNhap);

    public NguoiDung findByEmail(String email);


//    @Query("SELECT u FROM NguoiDung u WHERE u.tenDangNhap = :tenDangNhap")
    @Query(value = "SELECT * FROM nguoi_dung WHERE ten_dang_nhap = :tenDangNhap", nativeQuery = true)
    public NguoiDung findDiaChiGiaoHangNative(@Param("tenDangNhap") String tenDangNhap);
}
