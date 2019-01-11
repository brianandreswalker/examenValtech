package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.enums.CostoPorTipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import com.valtech.alquilauto.services.IPromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("alquilerPorHora")
public class TipoAlquilerPorHora implements ITipoAlquiler {

    @Autowired
    IPromocionService promocionService;

    public void calcularCosto(Solicitud solicitud) {
        Alquiler alquiler = solicitud.getAlquiler();
        System.out.println("Calculando costo de alquiler: " + solicitud.getId());
        Double costoFinal = alquiler.getCantidadHs() * CostoPorTipoAlquilerEnum.POR_HORA.getCosto();
        System.out.println("El costo del alquiler ID " + solicitud.getId() + " es $" + costoFinal);
        alquiler.setCostoFinal(costoFinal);

        promocionService.calcularPromo(solicitud);
    }
}
