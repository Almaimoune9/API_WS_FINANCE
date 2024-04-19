package com.sitanInfo.API_WS_FINANCE.repository;

import com.sitanInfo.API_WS_FINANCE.model.Comptes;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ComptesRepository extends JpaRepository<Comptes, Integer> {

    Comptes  getByCode(String code);
}
