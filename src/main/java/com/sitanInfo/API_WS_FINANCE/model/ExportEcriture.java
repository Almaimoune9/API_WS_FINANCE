package com.sitanInfo.API_WS_FINANCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ExportEcriture extends AbstractEntity{

    private Date date;
    private Long idDepense;
    private Long idRecette;
    private Integer annee;
    private String last;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modeReglement")
    private ModeReglement modeReglement;
}
