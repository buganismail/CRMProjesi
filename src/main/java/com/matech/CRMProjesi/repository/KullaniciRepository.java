package com.matech.CRMProjesi.repository;

import com.matech.CRMProjesi.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
    Optional<Kullanici> findByKullaniciAdi(String kullaniciAdi);
}
