package com.matech.CRMProjesi.base;

import com.matech.CRMProjesi.entity.Kullanici;
import com.matech.CRMProjesi.enums.Durum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Durum durum = Durum.AKTIF;

    @Column(name = "olusturulma_tarihi", updatable = false)
    private LocalDateTime olusturulmaTarihi;

    @Column(name = "guncelleme_tarihi")
    private LocalDateTime guncellemeTarihi;

    @ManyToOne
    @JoinColumn(name = "olusturan_kullanici_id", updatable = false)
    private Kullanici olusturanKullanici;

    @ManyToOne
    @JoinColumn(name = "guncelleyen_kullanici_id", updatable = false)
    private Kullanici guncelleyenKullanici;


    @PrePersist
    private void beforePersist(){
        this.olusturulmaTarihi = LocalDateTime.now();   // İlk oluşturma zamanı
        this.guncellemeTarihi = LocalDateTime.now();    // İlk oluşturma zamanı (aynı zamanda update için de set edilir)
    }

    @PreUpdate
    private void beforeUpdate(){
        this.guncellemeTarihi = LocalDateTime.now();    // Güncellenme zamanı
    }

}