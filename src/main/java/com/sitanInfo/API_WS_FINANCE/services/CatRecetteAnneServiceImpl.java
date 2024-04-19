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
public class CatRecetteAnneServiceImpl implements CatRecetteAnneService{

    @Autowired
    private CatRecetteAnneeRepository catRecetteAnneeRepository;

    @Override
    public String creer(CategoriesRecettesAnnee categoriesRecettesAnnee) {
        catRecetteAnneeRepository.save(categoriesRecettesAnnee);
        return "categoriesRecettesAnnee créer";
    }

    @Override
    public List<CategoriesRecettesAnnee> lire() {
        return catRecetteAnneeRepository.findAll();
    }

    @Override
    public Optional<CategoriesRecettesAnnee> findById(Integer id) {
        return catRecetteAnneeRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, CategoriesRecettesAnnee categoriesRecettesAnnee) {
        return null;
    }

    @Override
    public String supprimer(Integer id) {
        if (catRecetteAnneeRepository.existsById(id)){
            catRecetteAnneeRepository.deleteById(id);
            return "categoriesRecettesAnnee supprimer";
        } else {
            return "Cette categoriesRecettesAnnee n'existe pas";
        }
    }
}
