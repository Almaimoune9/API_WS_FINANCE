package com.sitanInfo.API_WS_FINANCE.repository;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRecetteRepository extends JpaRepository<CategoriesRecettes, Integer> {

    CategorieDepRepository getByCode(String code);
}
