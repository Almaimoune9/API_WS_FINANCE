package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Honoraire;
import com.sitanInfo.API_WS_FINANCE.model.Recettes;

import java.util.List;
import java.util.Optional;

public interface HonoraireService {

    //Methode pour creer
    String creer(Honoraire honoraire);

    //Afficher la liste
    List<Honoraire> lire();

    //Afficher un honoraire
    Optional<Honoraire> findById(Integer id);

    //Modifier un honoraire
    String modifier(Integer id, Honoraire honoraire);

    //Supprimer un honoraire
    String supprimer(Integer id);
}
