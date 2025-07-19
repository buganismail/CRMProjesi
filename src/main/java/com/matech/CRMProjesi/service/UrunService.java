package com.matech.CRMProjesi.service;

import com.matech.CRMProjesi.dto.UrunDTO;

import java.util.List;

public interface UrunService {
    UrunDTO urunEkle(UrunDTO urunDto);

    UrunDTO urunGuncelle(Long id, UrunDTO urunDto);

    void urunSil(Long id);

    UrunDTO urunGetirById(Long id);

    List<UrunDTO> getirTumUrunler();

    ;
}
