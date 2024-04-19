package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Depense extends AbstractEntity{


    private Integer annee;
    private String periode;
    private String mandat;
    private Date date;
    private String numeroTransaction;
    private String libelle;
    private String remarques;
    private Double montant;
    private Double total;
    private Double totalTva;
    private Double retenue;
    private Double net;
    private String compte;
    private String cheque;
    private String creancier;
    private Integer etat;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "honoraire")
    private Honoraire honoraire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modeReglement")
    private ModeReglement modeReglement;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private CUser user;*/
}
