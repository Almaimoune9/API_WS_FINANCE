package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.services.DepenseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class DepenseController {

    @Autowired
    private DepenseService depenseService;

    @Operation(summary = "Créer une depense")
    @PostMapping("/depense")
    public String create(@RequestBody Depense depense){
        return depenseService.creer(depense);
    }

    @Operation(summary = "Afficher la liste des depense")
    @GetMapping("/depense")
    public List<Depense> read(){
        return depenseService.lire();
    }

    @Operation(summary = "Afficher une depense")
    @GetMapping("/depense/{id}")
    public Optional<Depense> recette(@PathVariable int id){
        return depenseService.findById(id);
    }

    @Operation(summary = "Modifier une depense")
    @PutMapping("/depense/{id}")
    public String update(@PathVariable int id, @RequestBody Depense depense){
        return depenseService.modifier(id, depense);
    }

    @Operation(summary = "Supprimer une depense")
    @DeleteMapping("/depense/{id}")
    public String delete(@PathVariable int id){
        return depenseService.supprimer(id);
    }
}
