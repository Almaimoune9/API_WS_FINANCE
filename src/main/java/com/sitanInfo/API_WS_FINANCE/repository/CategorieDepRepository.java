package com.sitanInfo.API_WS_FINANCE.repository;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesDepenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDepRepository extends JpaRepository<CategoriesDepenses, Integer> {

    CategoriesDepenses getByCode(String code);
}
