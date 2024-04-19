package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Recettes;
import com.sitanInfo.API_WS_FINANCE.repository.RecetteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class RecetteServiceImpl implements RecetteService{

    @Autowired
    private RecetteRepository recetteRepository;

    @Override
    public String creer(Recettes recettes) {
        try {
            Recettes recetteExiste = recetteRepository.getByLibelle(recettes.getLibelle());
            if (recetteExiste != null) {
                return "Cette recette existe deja";
            } else {
                recetteRepository.save(recettes);
                return "Recette créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de la recette.";
        }
    }

    @Override
    public List<Recettes> lire() {
        return recetteRepository.findAll();
    }

    @Override
    public Optional<Recettes> findById(Integer id) {
        return recetteRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, Recettes recettes) {
        try {
            //Recherche la recette par son id
            Recettes recetteModifier = recetteRepository.findById(id).orElse(null);

            if (recetteModifier == null) {
                return "Recette non trouvé";
            }
            //Mettre à jour les informations
            recetteModifier.setAnnee(recettes.getAnnee());
            recetteModifier.setDate(recettes.getDate());
            recetteModifier.setCheque(recettes.getCheque());
            recetteModifier.setEtat(recettes.getEtat());
            recetteModifier.setCompte(recettes.getCompte());
            recetteModifier.setDatedelai(recettes.getDatedelai());
            recetteModifier.setMontant(recettes.getMontant());
            recetteModifier.setNumeroTransaction(recettes.getNumeroTransaction());
            recetteModifier.setRemarques(recettes.getRemarques());
            recetteModifier.setLibelle(recettes.getLibelle());
            recetteModifier.setRecu(recettes.getRecu());

            //Enregistrer les modifications
            recetteRepository.save(recetteModifier);

            return "Recette modifier  avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la recette.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (recetteRepository.existsById(id)){
            recetteRepository.deleteById(id);
            return "Recette supprimer";
        } else {
            return "Cette recette n'existe pas";
        }
    }
}
