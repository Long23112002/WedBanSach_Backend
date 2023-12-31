package com.example.wedbansach_springboot_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quyen")
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_quyen")
    private int maQuyen;
    @Nationalized
    @Column(name = "ten_quyen")
    private String tenQuyen;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "nguoidung_quyen",
            joinColumns = @JoinColumn(name = "ma_quyen"),
            inverseJoinColumns = @JoinColumn(name = "ma_nguoi_dung")
    )
    Set<NguoiDung> danhSachNguoiDung;
}