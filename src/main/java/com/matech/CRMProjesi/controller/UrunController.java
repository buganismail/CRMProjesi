package com.matech.CRMProjesi.controller;

import com.matech.CRMProjesi.dto.UrunDTO;
import com.matech.CRMProjesi.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
public class UrunController {

    @Autowired
    private UrunService urunService;

    public UrunController(UrunService urunService) {
        this.urunService = urunService;
    }

    @PostMapping
    public UrunDTO urunEkle(@RequestBody UrunDTO dto) {
        return urunService.urunEkle(dto);
    }

    @PutMapping("/{id}")
    public UrunDTO urunGuncelle(@PathVariable Long id, @RequestBody UrunDTO dto) {
        return urunService.urunGuncelle(id, dto);
    }

    @DeleteMapping("/{id}")
    public void urunSil(@PathVariable Long id) {
        urunService.urunSil(id);
    }

    @GetMapping("/{id}")
    public UrunDTO urunGetirById(@PathVariable Long id) {
        return urunService.urunGetirById(id);
    }

    // ID ile ürün getir
    @GetMapping("/{id}")
    public ResponseEntity<UrunDTO> urunGetir(@PathVariable Long id) {
        return ResponseEntity.ok(urunService.urunGetirById(id));
    }

    @GetMapping
    public List<UrunDTO> getirTumUrunler() {
        return urunService.getirTumUrunler();
    }

}