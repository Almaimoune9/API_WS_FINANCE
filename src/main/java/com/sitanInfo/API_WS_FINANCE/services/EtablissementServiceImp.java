package com.sitanInfo.API_WS_FINANCE.services;
import com.sitanInfo.API_WS_FINANCE.model.Etablissement;
import com.sitanInfo.API_WS_FINANCE.repository.EtablissementRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class EtablissementServiceImp implements EtablissementService{

    @Autowired
    private final EtablissementRepository etablissementRepository;

    @Override
    public String creer(Etablissement etablissement) {
        try {
            Etablissement etaExiste = etablissementRepository.getByNom(etablissement.getNom());
            if (etaExiste != null) {
                return "Cet etablissement existe deja";
            } else {
                etablissementRepository.save(etablissement);
                return "Etablissement créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de l'etablissement.";
        }
    }

    @Override
    public List<Etablissement> lire() {
        return etablissementRepository.findAll();
    }

    @Override
    public String modifier(Integer id, Etablissement etablissement) {
        try {
            //Recherche l'etablissemrnt par son id
            Etablissement etaModifier = etablissementRepository.findById(id).orElse(null);

            if (etaModifier == null) {
                return "Etablissement non trouvé";
            }
            //Mettre à jour les informations
            etaModifier.setAbreviation(etablissement.getAbreviation());
            etaModifier.setCode(etablissement.getCode());
            etaModifier.setAdresse(etablissement.getAdresse());
            etaModifier.setNom(etablissement.getNom());
            etaModifier.setGroupe(etablissement.getGroupe());
            etaModifier.setPays(etablissement.getPays());
            etaModifier.setIdentifiantEtab(etablissement.getIdentifiantEtab());
            etaModifier.setTel(etablissement.getTel());
            etaModifier.setType(etablissement.getType());
            etaModifier.setVille(etablissement.getVille());

            //Enregistrer les modifications
            etablissementRepository.save(etaModifier);

            return "Etablissement modifier  avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de l'etablissement.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (etablissementRepository.existsById(id)){
            etablissementRepository.deleteById(id);
            return "Etablissement supprimer";
        } else {
            return "Cet etablissement n'existe pas";
        }
    }


    @Override
    public Optional<Etablissement> findById(Integer id) {
        return etablissementRepository.findById(id);
    }
}
