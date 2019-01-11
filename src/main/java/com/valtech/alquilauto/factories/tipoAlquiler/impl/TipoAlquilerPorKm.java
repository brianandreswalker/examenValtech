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
@Qualifier("alquilerPorKm")
public class TipoAlquilerPorKm implements ITipoAlquiler {

    @Autowired
    IPromocionService promocionService;

    public void calcularCosto(Solicitud solicitud) {
        Alquiler alquiler = solicitud.getAlquiler();
        alquiler.setCostoFinal(alquiler.getCantidadKms() * CostoPorTipoAlquilerEnum.POR_KMS.getCosto());

        promocionService.calcularPromo(solicitud);
    }
}
