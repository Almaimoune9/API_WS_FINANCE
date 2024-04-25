package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Paiement extends AbstractEntity{


    private String reference;
    private Integer annee;
    private Double montant;
    private Double total;
    private Double tva;
    private Double remise;
    private Double net;
    private Date date;
    private String transaction;

}
