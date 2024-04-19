package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Depense;

import java.util.List;
import java.util.Optional;

public interface DepenseService {

    //Methode pour creer une depense
    String creer(Depense depense);

    //Afficher la liste des depenses
    List<Depense> lire();

    //Afficher une depenses
    Optional<Depense> findById(Integer id);

    //Modifier une depense
    String modifier(Integer id, Depense depense);

    //Supprimer une depense
    String supprimer(Integer id);
}
