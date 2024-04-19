package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Honoraire extends AbstractEntity {


    private Integer annee;
    private Double montant;
    private Double total;
    private Double tva;
    private Double retenue;
    private Double net;
    private Date date;
    private Double autreRetenue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;


}
