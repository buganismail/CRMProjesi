package com.matech.CRMProjesi.service;

import com.matech.CRMProjesi.dto.UrunDTO;
import com.matech.CRMProjesi.entity.Urun;
import com.matech.CRMProjesi.exception.ResourceNotFoundException;
import com.matech.CRMProjesi.repository.UrunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UrunServisImpl implements UrunService {

    @Autowired
    private UrunRepository urunRepository;

    @Override
    public UrunDTO urunEkle(UrunDTO dto) {
        Urun urun = toEntity(dto);
        Urun kaydedilen = urunRepository.save(urun);
        return toDTO(kaydedilen);
    }

    @Override
    public UrunDTO urunGuncelle(Long id, UrunDTO dto) {
        Urun mevcut = urunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ürün bulunamadı: " + id));

        mevcut.setAd(dto.getAd());
        mevcut.setFiyat(dto.getFiyat());
        mevcut.setStokAdedi(dto.getStokAdedi());

        Urun guncelleyen = urunRepository.save(mevcut);

        return toDTO(guncelleyen);
    }

    @Override
    public void urunSil(Long id) {
        if (!urunRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ürün bulunamadı: " + id);
        }
        urunRepository.deleteById(id);
    }

    @Override
    public UrunDTO urunGetirById(Long id) {
        Urun urun = urunRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ürün bulunamadı: " + id));
        return toDTO(urun);
    }

    @Override
    public List<UrunDTO> getirTumUrunler() {
        return urunRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Dönüştürücüler
    // Entity -> DTO dönüştürme
    private UrunDTO toDTO(Urun urun) {
        UrunDTO dto = new UrunDTO();

        dto.setId(urun.getId());
        dto.setAd(urun.getAd());
        dto.setFiyat(urun.getFiyat());
        dto.setStokAdedi(urun.getStokAdedi());

        return dto;
    }

    // DTO -> Entity dönüştürme
    private Urun toEntity(UrunDTO dto) {
        Urun urun = new Urun();

        urun.setAd(dto.getAd());
        urun.setStokAdedi(dto.getStokAdedi());
        urun.setFiyat(dto.getFiyat());

        return urun;
    }
}
