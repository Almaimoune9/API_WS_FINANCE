package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CatRecetteEcheance;
import com.sitanInfo.API_WS_FINANCE.model.ModeReglement;

import java.util.List;
import java.util.Optional;

public interface CatRecetteEcheanceService {

    //Methode pour une CatRecetteEcheance
    String creer(CatRecetteEcheance catRecetteEcheance);

    //Afficher la CatRecetteEcheance
    List<CatRecetteEcheance> lire();

    //Afficher une CatRecetteEcheance
    Optional<CatRecetteEcheance> findById(Integer id);

    //Modifier une CatRecetteEcheance
    String modifier(Integer id, CatRecetteEcheance catRecetteEcheance);

    //Supprimer une CatRecetteEcheance
    String supprimer(Integer id);
}
