package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DepensesDetails extends AbstractEntity{

    private String facture;
    private Double pu;
    private Double quantite;
    private Double montant;
    private Double total;
    private Double tva;
    private Double totalTva;
    private Double retenue;
    private Double net;
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriesDepenses")
    private CategoriesDepenses categoriesDepenses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depense")
    private Depense depense;
}
