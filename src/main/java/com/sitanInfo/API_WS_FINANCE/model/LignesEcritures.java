package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class LignesEcritures extends AbstractEntity{

    private Date date;
    private String piece;
    private String ref;
    private String compte;
    private String libelle;
    private Double produit;
    private Double charge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exportEcriture")
    private ExportEcriture exportEcriture;
}
