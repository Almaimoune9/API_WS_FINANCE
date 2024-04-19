package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class HonorairesDetails extends AbstractEntity{

    private Double pu;
    private Double quatite;
    private Double montant;
    private Double total;
    private Double retenue;
    private Double tva;
    private Double totalTva;
    private Double net;
    private Double autreRetenue;
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "honoraire")
    private Honoraire honoraire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriesDepenses")
    private CategoriesDepenses categoriesDepenses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depensesDetails")
    private DepensesDetails depensesDetails;
}
