package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.enums.CostoPorTipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;

public class TipoAlquilerPorHora implements ITipoAlquiler {

    public void calcularCosto(Alquiler alquiler) {
        System.out.println("Calculando costo de alquiler: " + alquiler.getId());
        Double costoFinal = alquiler.getCantidadHs() * CostoPorTipoAlquilerEnum.POR_HORA.getCosto();
        System.out.println("El costo del alquiler ID " + alquiler.getId() + " es $" + costoFinal);
        alquiler.setCostoFinal(costoFinal);
    }
}
