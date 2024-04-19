package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesDepenses;
import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.repository.CategorieDepRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CategorieDepServiceImpl implements CategorieDepService{

    @Autowired
    private CategorieDepRepository categorieDepRepository;

    @Override
    public String creer(CategoriesDepenses categoriesDepenses) {
        try {
            CategoriesDepenses catDepExiste = categorieDepRepository.getByCode(categoriesDepenses.getCode());
            if (catDepExiste != null){
                return "Cette categorieDepense existe deja";
            } else {
                categorieDepRepository.save(categoriesDepenses);
                return "Categorie enregistrer";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Une erreur s'est produite lors de la creation de la categorie";
        }
    }

    @Override
    public List<CategoriesDepenses> lire() {
        return categorieDepRepository.findAll();
    }

    @Override
    public Optional<CategoriesDepenses> findById(Integer id) {
        return categorieDepRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, CategoriesDepenses categoriesDepenses) {
        try {
            //Recherche la catdepense par son id
            CategoriesDepenses catDepModifier = categorieDepRepository.findById(id).orElse(null);

            if (catDepModifier == null) {
                return "CatDep non trouvée";
            }
            //Mettre à jour les informations
            catDepModifier.setCode(categoriesDepenses.getCode());
            catDepModifier.setLibelle(categoriesDepenses.getLibelle());
            catDepModifier.setEtat(categoriesDepenses.getEtat());
            catDepModifier.setCompte(categoriesDepenses.getCompte());
            catDepModifier.setEstHonoraire(categoriesDepenses.getEstHonoraire());

            //Enregistrer les modifications
            categorieDepRepository.save(catDepModifier);

            return "CatDep  modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la catDep.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (categorieDepRepository.existsById(id)){
            categorieDepRepository.deleteById(id);
            return "CategorieDepense supprimer";
        } else {
            return "Cette categorieDepense n'existe pas";
        }
    }
}
