package com.matech.CRMProjesi.entity;

import com.matech.CRMProjesi.enums.Rol;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "musteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String ad;

    @Column(nullable = false)
    private String soyad;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String sifre;

    private String telefon;
    private String adres;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.MUSTERI;
}
