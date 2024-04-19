package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesDepenses;
import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettesAnnee;

import java.util.List;
import java.util.Optional;

public interface CatRecetteAnneService {

    //Methode pour creer une CatRecetteAnne
    String creer(CategoriesRecettesAnnee categoriesRecettesAnnee);

    //Afficher la liste des CatRecetteAnne
    List<CategoriesRecettesAnnee> lire();

    //Afficher une CatRecetteAnne
    Optional<CategoriesRecettesAnnee> findById(Integer id);

    //Modifier une CatRecetteAnne
    String modifier(Integer id, CategoriesRecettesAnnee categoriesRecettesAnnee);

    //Supprimer une CatRecetteAnne
    String supprimer(Integer id);
}
