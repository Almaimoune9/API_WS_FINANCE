package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesRecettes;
import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.services.CatRecetteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CatRecetteController {

    @Autowired
    private CatRecetteService catRecetteService;

    @Operation(summary = "Créer une catRecette")
    @PostMapping("/catRecette")
    public String create(@RequestBody CategoriesRecettes categoriesRecettes){
        return catRecetteService.creer(categoriesRecettes);
    }

    @Operation(summary = "Afficher la liste des catRecette")
    @GetMapping("/catRecette")
    public List<CategoriesRecettes> read(){
        return catRecetteService.lire();
    }

    @Operation(summary = "Afficher une catRecette")
    @GetMapping("/catRecette/{id}")
    public Optional<CategoriesRecettes> recette(@PathVariable int id){
        return catRecetteService.findById(id);
    }

    @Operation(summary = "Modifier une catRecette")
    @PutMapping("/catRecette/{id}")
    public String update(@PathVariable int id, @RequestBody CategoriesRecettes categoriesRecettes){
        return catRecetteService.modifier(id, categoriesRecettes);
    }
}
