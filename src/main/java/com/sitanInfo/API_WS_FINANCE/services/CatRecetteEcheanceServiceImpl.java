package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.CatRecetteEcheance;
import com.sitanInfo.API_WS_FINANCE.repository.CatRecetteEcheanceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CatRecetteEcheanceServiceImpl implements CatRecetteEcheanceService {

    @Autowired
    private CatRecetteEcheanceRepository catRecetteEcheanceRepository;

    @Override
    public String creer(CatRecetteEcheance catRecetteEcheance) {
        catRecetteEcheanceRepository.save(catRecetteEcheance);
        return "catRecetteEcheance créer";
    }

    @Override
    public List<CatRecetteEcheance> lire() {
        return catRecetteEcheanceRepository.findAll();
    }

    @Override
    public Optional<CatRecetteEcheance> findById(Integer id) {
        return catRecetteEcheanceRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, CatRecetteEcheance catRecetteEcheance) {
        try {
            //Rechercher CatRecetteEcheance par son id
            CatRecetteEcheance catRecetteEcheanceModifier = catRecetteEcheanceRepository.findById(id).orElse(null);
            if (catRecetteEcheanceModifier == null){
                return "CatRecetteEcheance non trouvée";
            }
            //Mettre les données à jour
            catRecetteEcheanceModifier.setDate(catRecetteEcheance.getDate());
            catRecetteEcheanceModifier.setMontant(catRecetteEcheance.getMontant());
            catRecetteEcheanceModifier.setOrdre(catRecetteEcheance.getOrdre());

            //Enregistrer les modifications
            catRecetteEcheanceRepository.save(catRecetteEcheanceModifier);
            return "CatRecetteEcheance modifiée avec succés";

        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur s'est produite lors de la modification de la CatRecetteEcheance";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (catRecetteEcheanceRepository.existsById(id)){
            catRecetteEcheanceRepository.deleteById(id);
            return "catRecetteEcheance supprimer";
        }else {
            return "Cette catRecetteEcheance n'existe pas";
        }
    }
}
