package com.matech.CRMProjesi.repository;

import com.matech.CRMProjesi.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {

}
