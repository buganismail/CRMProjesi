package com.matech.CRMProjesi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kullanici_adi", nullable = false, unique = true)
    private String kullaniciAdi;

    @Column(name = "sifre", nullable = false)
    private String sifre;

}
