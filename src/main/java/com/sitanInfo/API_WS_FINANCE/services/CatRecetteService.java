package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettes;
import com.sitanInfo.API_WS_FINANCE.model.Depense;

import java.util.List;
import java.util.Optional;

public interface CatRecetteService {

    //Methode pour creer une catRecette
    String creer(CategoriesRecettes categoriesRecettes);

    //Afficher la liste des catRecette
    List<CategoriesRecettes> lire();

    //Afficher une catRecette
    Optional<CategoriesRecettes> findById(Integer id);

    //Modifier une catRecette
    String modifier(Integer id, CategoriesRecettes categoriesRecettes);

    //Supprimer une catRecette
    String supprimer(Integer id);
}
