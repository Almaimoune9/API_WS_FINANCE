package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.CatRecetteEcheance;
import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.services.CatRecetteEcheanceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CatRecetteEcheanceController {

    @Autowired
    private CatRecetteEcheanceService catRecetteEcheanceService;

    @Operation(summary = "Créer une catRecetteEcheance")
    @PostMapping("catRecetteEcheance")
    public String create(@RequestBody CatRecetteEcheance catRecetteEcheance){
        return catRecetteEcheanceService.creer(catRecetteEcheance);
    }

    @Operation(summary = "Liste des catRecetteEcheance")
    @GetMapping("catRecetteEcheance")
    public List<CatRecetteEcheance> read(){
        return catRecetteEcheanceService.lire();
    }

    @Operation(summary = "Afficher une catRecetteEcheance")
    @GetMapping("/catRecetteEcheance/{id}")
    public Optional<CatRecetteEcheance> catRecetteEcheance(@PathVariable int id){
        return catRecetteEcheanceService.findById(id);
    }

    @Operation(summary = "Modifier une depense")
    @PutMapping("/catRecetteEcheance/{id}")
    public String update(@PathVariable int id, @RequestBody CatRecetteEcheance catRecetteEcheance){
        return catRecetteEcheanceService.modifier(id, catRecetteEcheance);
    }

    @Operation(summary = "Supprimer une catRecetteEcheance")
    @DeleteMapping("/catRecetteEcheance/{id}")
    public String delete(@PathVariable int id){
        return catRecetteEcheanceService.supprimer(id);
    }
}
