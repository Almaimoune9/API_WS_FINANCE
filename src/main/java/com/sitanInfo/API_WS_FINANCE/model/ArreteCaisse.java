package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ArreteCaisse extends AbstractEntity{

    private Date date;
    private Integer annee;
    private Double soldeReport;
    private Double soldeRecette;
    private Double soldeDepense;
    private Double soldeTheorique;
    private Double soldePhysique;
    private Double ecart;
    private String billetage;
    private String last;
}
