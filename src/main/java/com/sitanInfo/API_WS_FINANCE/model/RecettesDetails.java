package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RecettesDetails extends AbstractEntity{

    private Double montant;
    private Double total;
    private Double tva;
    private Double totalTva;
    private Double remise;
    private Double net;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriesRecettes")
    private CategoriesRecettes categoriesRecettes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recettes")
    private Recettes recettes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriesRecettesAnnee")
    private CategoriesRecettesAnnee categoriesRecettesAnnee;
}
