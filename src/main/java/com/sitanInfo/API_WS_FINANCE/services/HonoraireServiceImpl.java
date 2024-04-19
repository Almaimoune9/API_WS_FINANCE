package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Honoraire;
import com.sitanInfo.API_WS_FINANCE.model.Recettes;
import com.sitanInfo.API_WS_FINANCE.repository.HonoraireRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class HonoraireServiceImpl implements HonoraireService{

    @Autowired
    private HonoraireRepository honoraireRepository;

    @Override
    public String creer(Honoraire honoraire) {
        honoraireRepository.save(honoraire);
        return "Honoraire créer avec succcés";
    }

    @Override
    public List<Honoraire> lire() {
        return honoraireRepository.findAll();
    }

    @Override
    public Optional<Honoraire> findById(Integer id) {
        return honoraireRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, Honoraire honoraire) {
        try {
            //Recherche l'honoraire par son id
            Honoraire honoraireModifier = honoraireRepository.findById(id).orElse(null);

            if (honoraireModifier == null) {
                return "Honoraire non trouvé";
            }
            //Mettre à jour les informations
            honoraireModifier.setAnnee(honoraire.getAnnee());
            honoraireModifier.setDate(honoraire.getDate());
            honoraireModifier.setMontant(honoraire.getMontant());
            honoraireModifier.setNet(honoraire.getNet());
            honoraireModifier.setRetenue(honoraire.getRetenue());
            honoraireModifier.setTva(honoraire.getTva());
            honoraireModifier.setAutreRetenue(honoraire.getAutreRetenue());
            honoraireModifier.setMontant(honoraire.getMontant());
            honoraireModifier.setTotal(honoraire.getTotal());

            //Enregistrer les modifications
            honoraireRepository.save(honoraireModifier);

            return "Recette modifier  avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la recette.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (honoraireRepository.existsById(id)){
            honoraireRepository.deleteById(id);
            return "Honoraire supprimer";
        } else {
            return "Cet honoraire n'existe pas";
        }
    }
}
