package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesDepenses;
import com.sitanInfo.API_WS_FINANCE.model.Depense;

import java.util.List;
import java.util.Optional;

public interface CategorieDepService {
    //Methode pour creer une categorieDepence
    String creer(CategoriesDepenses categoriesDepenses);

    //Afficher la liste des categorieDepence
    List<CategoriesDepenses> lire();

    //Afficher une categorieDepence
    Optional<CategoriesDepenses> findById(Integer id);

    //Modifier une categorieDepence
    String modifier(Integer id, CategoriesDepenses categoriesDepenses);

    //Supprimer une categorieDepence
    String supprimer(Integer id);
}
