package com.valtech.alquilauto.enums;

public enum CostoPorTipoAlquilerEnum {

    POR_HORA(300D),
    POR_KMS(50D),
    POR_SEMANA(10000D),
    POR_SEMANA_PLUS(100D);

    private CostoPorTipoAlquilerEnum(Double costo){
        this.costo = costo;
    }

    private Double costo;

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

}
