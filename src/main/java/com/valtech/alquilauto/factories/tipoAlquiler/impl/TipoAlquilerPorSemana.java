package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.enums.CostoPorTipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;

public class TipoAlquilerPorSemana implements ITipoAlquiler {

    public void calcularCosto(Alquiler alquiler) {
        Double costoFinal = alquiler.getCantidadSemanas() * CostoPorTipoAlquilerEnum.POR_SEMANA.getCosto();

        if(alquiler.getCantidadKms()>3000D){
            costoFinal =+ (alquiler.getCantidadKms() % 3D) * CostoPorTipoAlquilerEnum.POR_SEMANA_PLUS.getCosto();
        }

        alquiler.setCostoFinal(costoFinal);
    }
}
