package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettes;
import com.sitanInfo.API_WS_FINANCE.repository.CatRecetteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CatRecetteServiceImpl implements CatRecetteService{

    @Autowired
    private CatRecetteRepository catRecetteRepository;

    @Override
    public String creer(CategoriesRecettes categoriesRecettes) {
        catRecetteRepository.save(categoriesRecettes);

        return "Categorie depense créer avec succés";
    }

    @Override
    public List<CategoriesRecettes> lire() {
        return catRecetteRepository.findAll();
    }

    @Override
    public Optional<CategoriesRecettes> findById(Integer id) {
        return catRecetteRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, CategoriesRecettes categoriesRecettes) {
        try {
            //Recherche la catdepense par son id
            CategoriesRecettes catRecModifier = catRecetteRepository.findById(id).orElse(null);

            if (catRecModifier == null) {
                return "CatRecette non trouvée";
            }
            //Mettre à jour les informations
            catRecModifier.setEtat(categoriesRecettes.getEtat());
            catRecModifier.setCompte(categoriesRecettes.getCompte());
            catRecModifier.setLibelle(categoriesRecettes.getLibelle());
            catRecModifier.setCode(categoriesRecettes.getCode());

            //Enregistrer les modifications
            catRecetteRepository.save(catRecModifier);

            return "CatRecette  modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la catRecette.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (catRecetteRepository.existsById(id)){
            catRecetteRepository.deleteById(id);
            return "CatRecette supprimer";
        } else {
            return "Cette catRecette n'existe pas";
        }
    }
}
