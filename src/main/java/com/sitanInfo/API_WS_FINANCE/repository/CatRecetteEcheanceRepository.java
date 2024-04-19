package com.sitanInfo.API_WS_FINANCE.repository;

import com.sitanInfo.API_WS_FINANCE.model.CatRecetteEcheance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRecetteEcheanceRepository extends JpaRepository<CatRecetteEcheance, Integer> {
}
