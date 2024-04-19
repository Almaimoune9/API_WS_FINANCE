package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettesAnnee;
import com.sitanInfo.API_WS_FINANCE.services.CatRecetteAnneService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CatRecetteAnneeController {

    @Autowired
    private CatRecetteAnneService catRecetteAnneService;

    @Operation(summary = "Créer une catRecetteAnnee")
    @PostMapping("/catRecetteAnnee")
    public String create(@RequestBody CategoriesRecettesAnnee categoriesRecettesAnnee){
        return catRecetteAnneService.creer(categoriesRecettesAnnee);
    }

    @Operation(summary = "Afficher la liste des catdepense")
    @GetMapping("/catRecetteAnnee")
    public List<CategoriesRecettesAnnee> read(){
        return catRecetteAnneService.lire();
    }

    @Operation(summary = "Afficher une catRecetteAnnee")
    @GetMapping("/catRecetteAnnee/{id}")
    public Optional<CategoriesRecettesAnnee> categoriesRecettesAnnee(@PathVariable int id){
        return catRecetteAnneService.findById(id);
    }

    @Operation(summary = "Modifier une catRecetteAnnee")
    @PutMapping("/catRecetteAnnee/{id}")
    public String update(@PathVariable int id, @RequestBody CategoriesRecettesAnnee categoriesRecettesAnnee){
        return catRecetteAnneService.modifier(id, categoriesRecettesAnnee);
    }
}
