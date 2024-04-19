package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.model.ModeReglement;

import java.util.List;
import java.util.Optional;

public interface ModeReglementService {

    //Methode pour creer
    String creer(ModeReglement modeReglement);

    //Afficher la liste
    List<ModeReglement> lire();

    //Afficher un mode
    Optional<ModeReglement> findById(Integer id);

    //Modifier un mode
    String modifier(Integer id, ModeReglement modeReglement);

    //Supprimer un mode
    String supprimer(Integer id);
}
