package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CategoriesRecettesAnnee extends AbstractEntity{

    private Double montant;
    private Integer nbecheance;
    private Integer periodicite;
    private String remise;
    private boolean selected;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "")
    private EFormations formations;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriesRecettes")
    private CategoriesRecettes categoriesRecettes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anneeAcademique")
    private CAnneeAcademique anneeAcademique;
}

