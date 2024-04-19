package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.Honoraire;
import com.sitanInfo.API_WS_FINANCE.services.HonoraireService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class HonoraireController {

    @Autowired
    private HonoraireService honoraireService;

    @Operation(summary = "Créer une honoraire")
    @PostMapping("/honoraire")
    public String create(@RequestBody Honoraire honoraire){
        return honoraireService.creer(honoraire);
    }

    @Operation(summary = "Afficher la liste des honoraires")
    @GetMapping("/honoraire")
    public List<Honoraire> read(){
        return honoraireService.lire();
    }

    @Operation(summary = "Afficher un honoraire")
    @GetMapping("/honoraire/{id}")
    public Optional<Honoraire> honoraire(@PathVariable int id){
        return honoraireService.findById(id);
    }

    @Operation(summary = "Modifier un honoraire")
    @PutMapping("/honoraire/{id}")
    public String update(@PathVariable int id, @RequestBody Honoraire honoraire){
        return honoraireService.modifier(id, honoraire);
    }

    @Operation(summary = "Supprimer un honoraire")
    @DeleteMapping("/honoraire/{id}")
    public String delete(@PathVariable int id){
        return honoraireService.supprimer(id);
    }
}
