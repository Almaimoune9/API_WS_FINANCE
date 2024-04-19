package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class CatRecetteEcheance extends AbstractEntity{

    private Integer ordre;
    private Date date;
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriesRecettesAnnee categoriesRecettesAnnee;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formations")
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
