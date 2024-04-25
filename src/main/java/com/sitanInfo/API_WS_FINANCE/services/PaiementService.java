package com.sitanInfo.API_WS_FINANCE.services;

import com.sitanInfo.API_WS_FINANCE.model.Paiement;
import com.sitanInfo.API_WS_FINANCE.repository.PaiementRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class PaiementService{

    @Autowired
    private PaiementRepository paiementRepository;

    public String creer(Paiement paiement) {
         paiementRepository.save(paiement);
         return "Paiement créer";
    }

    public List<Paiement> lire() {
        return paiementRepository.findAll();
    }

    public Optional<Paiement> findById(Integer id) {
        return paiementRepository.findById(id);
    }

    public String supprimer(Integer id) {
        if (paiementRepository.existsById(id)){
            paiementRepository.deleteById(id);
            return "Paiement supprimer";
        } else{
            return "Paiement non trouvé";
        }
    }
}
