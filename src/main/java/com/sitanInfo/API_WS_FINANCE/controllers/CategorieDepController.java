package com.sitanInfo.API_WS_FINANCE.controllers;

import com.sitanInfo.API_WS_FINANCE.model.CategoriesDepenses;
import com.sitanInfo.API_WS_FINANCE.model.Depense;
import com.sitanInfo.API_WS_FINANCE.services.CategorieDepService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CategorieDepController {

    @Autowired
    private CategorieDepService categorieDepService;

    @Operation(summary = "Créer une catdepense")
    @PostMapping("/catdepense")
    public String create(@RequestBody CategoriesDepenses categoriesDepenses){
        return categorieDepService.creer(categoriesDepenses);
    }

    @Operation(summary = "Afficher la liste des catdepense")
    @GetMapping("/catdepense")
    public List<CategoriesDepenses> read(){
        return categorieDepService.lire();
    }

    @Operation(summary = "Afficher une catdepense")
    @GetMapping("/catdepense/{id}")
    public Optional<CategoriesDepenses> categoriesDepenses(@PathVariable int id){
        return categorieDepService.findById(id);
    }

    @Operation(summary = "Modifier une catdepense")
    @PutMapping("/catdepense/{id}")
    public String update(@PathVariable int id, @RequestBody CategoriesDepenses categoriesDepenses){
        return categorieDepService.modifier(id, categoriesDepenses);
    }

    @Operation(summary = "Supprimer une catdepense")
    @DeleteMapping("/catdepense/{id}")
    public String delete(@PathVariable int id){
        return categorieDepService.supprimer(id);
    }
}
