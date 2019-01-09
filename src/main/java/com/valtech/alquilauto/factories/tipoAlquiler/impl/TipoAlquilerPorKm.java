package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.enums.CostoPorTipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;

public class TipoAlquilerPorKm implements ITipoAlquiler {

    public void calcularCosto(Alquiler alquiler) {
        Double costoFinal = alquiler.getCantidadKms() * CostoPorTipoAlquilerEnum.POR_KMS.getCosto();
        alquiler.setCostoFinal(costoFinal);
    }
}
