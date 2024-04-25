package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettesAnnee;
import com.sitanInfo.API_WS_FINANCE.repository.CatRecetteAnneeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CatRecetteAnneService {

    @Autowired
    private CatRecetteAnneeRepository catRecetteAnneeRepository;

    public String creer(CategoriesRecettesAnnee categoriesRecettesAnnee) {
        catRecetteAnneeRepository.save(categoriesRecettesAnnee);
        return "categoriesRecettesAnnee créer";
    }

    public List<CategoriesRecettesAnnee> lire() {
        return catRecetteAnneeRepository.findAll();
    }

    public Optional<CategoriesRecettesAnnee> findById(Integer id) {
        return catRecetteAnneeRepository.findById(id);
    }

    public String modifier(Integer id, CategoriesRecettesAnnee categoriesRecettesAnnee) {
        return null;
    }

    public String supprimer(Integer id) {
        if (catRecetteAnneeRepository.existsById(id)){
            catRecetteAnneeRepository.deleteById(id);
            return "categoriesRecettesAnnee supprimer";
        } else {
            return "Cette categoriesRecettesAnnee n'existe pas";
        }
    }
}
