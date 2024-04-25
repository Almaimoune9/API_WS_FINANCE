package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.repository.DepenseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class DepenseService implements DepenseService{

    @Autowired
    private DepenseRepository depenseRepository;

    @Override
    public String creer(Depense depense) {
        try {
            Depense depenseExiste = depenseRepository.getByLibelle(depense.getLibelle());
            if (depenseExiste != null) {
                return "Cette depense existe deja";
            } else {
                depenseRepository.save(depense);
                return "Depense créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de la depense.";
        }
    }

    @Override
    public List<Depense> lire() {
        return depenseRepository.findAll();
    }

    @Override
    public Optional<Depense> findById(Integer id) {
        return depenseRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, Depense depense) {
        try {
            //Recherche la depense par son id
            Depense depenseModifier = depenseRepository.findById(id).orElse(null);

            if (depenseModifier == null) {
                return "Depense non trouvé";
            }
            //Mettre à jour les informations
            depenseModifier.setAnnee(depense.getAnnee());
            depenseModifier.setDate(depense.getDate());
            depenseModifier.setCheque(depense.getCheque());
            depenseModifier.setCompte(depense.getCompte());
            depenseModifier.setCreancier(depense.getCreancier());
            depenseModifier.setLibelle(depense.getLibelle());
            depenseModifier.setEtat(depense.getEtat());
            depenseModifier.setMandat(depense.getMandat());
            depenseModifier.setNumeroTransaction(depense.getNumeroTransaction());
            depenseModifier.setPeriode(depense.getPeriode());
            depenseModifier.setRemarques(depense.getRemarques());
            depenseModifier.setRetenue(depense.getRetenue());
            depenseModifier.setNet(depense.getNet());
            depenseModifier.setTotalTva(depense.getTotalTva());

            //Enregistrer les modifications
            depenseRepository.save(depenseModifier);

            return "Depense  modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la depense.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (depenseRepository.existsById(id)){
            depenseRepository.deleteById(id);
            return "Depense supprimer";
        } else {
            return "Cette depense n'existe pas";
        }
    }
}
