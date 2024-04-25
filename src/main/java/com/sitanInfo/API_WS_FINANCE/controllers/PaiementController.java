package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.Paiement;
import com.sitanInfo.API_WS_FINANCE.services.PaiementService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @Operation(summary = "Créer un paiement")
    @PostMapping("/paiement")
    public String create(@RequestBody Paiement paiement){
        return paiementService.creer(paiement);
    }

    @Operation(summary = "La liste des paiements")
    @GetMapping("/paiement")
    public List<Paiement> read(){
        return paiementService.lire();
    }

    @Operation(summary = "Afficher un paiement")
    @GetMapping("//paiement/{id}")
    public Optional<Paiement> paiement(@PathVariable int id){
        return paiementService.findById(id);
    }

    @Operation(summary = "Supprimer un paiement")
    @DeleteMapping("/paiement/{id}")
    public String delete(@PathVariable int id){
        return paiementService.supprimer(id);
    }
}
