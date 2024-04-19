package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Recettes;

import java.util.List;
import java.util.Optional;

public interface RecetteService {

    //Methode pour creer une recette
    String creer(Recettes recettes);

    //Afficher la liste des recette
    List<Recettes> lire();

    //Afficher une recette
    Optional<Recettes> findById(Integer id);

    //Modifier une recette
    String modifier(Integer id, Recettes recettes);

    //Supprimer une recette
    String supprimer(Integer id);
}
