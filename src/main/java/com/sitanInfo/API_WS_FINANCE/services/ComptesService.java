package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Comptes;
import com.sitanInfo.API_WS_FINANCE.model.Recettes;

import java.util.List;
import java.util.Optional;

public interface ComptesService {

    //Methode pour creer un compte
    String creer(Comptes comptes);

    //Afficher la liste des compte
    List<Comptes> lire();

    //Afficher un compte
    Optional<Comptes> findById(Integer id);

    //Modifier un compte
    String modifier(Integer id, Comptes comptes);

    //Supprimer un compte
    String supprimer(Integer id);
}
