package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.Recettes;
import com.sitanInfo.API_WS_FINANCE.services.RecetteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @Operation(summary = "Créer une recette")
    @PostMapping("/recette")
    public String create(@RequestBody Recettes recettes){
       return recetteService.creer(recettes);
    }

    @Operation(summary = "Afficher la liste des recettes")
    @GetMapping("/recette")
    public List<Recettes> read(){
        return recetteService.lire();
    }

    @Operation(summary = "Afficher une recette")
    @GetMapping("/recette/{id}")
    public Optional<Recettes> recette(@PathVariable int id){
        return recetteService.findById(id);
    }

    @Operation(summary = "Modifier une recette")
    @PutMapping("/recette/{id}")
    public String update(@PathVariable int id, @RequestBody Recettes recettes){
        return recetteService.modifier(id, recettes);
    }

    @Operation(summary = "Supprimer une recette")
    @DeleteMapping("/recette/{id}")
    public String delete(@PathVariable int id){
        return recetteService.supprimer(id);
    }
}
