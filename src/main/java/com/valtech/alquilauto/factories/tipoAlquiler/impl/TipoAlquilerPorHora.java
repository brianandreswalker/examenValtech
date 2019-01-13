package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.enums.CostoPorTipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import com.valtech.alquilauto.services.IPromocionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("alquilerPorHora")
public class TipoAlquilerPorHora implements ITipoAlquiler {

    private static final Logger logger = LoggerFactory.getLogger(TipoAlquilerPorHora.class);


    @Autowired
    IPromocionService promocionService;

    public void calcularCosto(Solicitud solicitud) {
        logger.info("Calculando costo de alquiler Solicitud id: " + solicitud.getId());

        Alquiler alquiler = solicitud.getAlquiler();
        Double costoFinal = alquiler.getCantidadHs() * CostoPorTipoAlquilerEnum.POR_HORA.getCosto();

        logger.info("El costo (sin promo) de la Solicitud id: " + solicitud.getId() + " es $" + costoFinal);
        alquiler.setCostoFinal(costoFinal);

        if (alquiler.isAplicarPromo())
            promocionService.calcularPromo(solicitud);
    }
}
