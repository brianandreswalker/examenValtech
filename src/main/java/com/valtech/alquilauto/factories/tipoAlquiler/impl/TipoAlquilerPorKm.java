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

import java.util.MissingResourceException;

@Service
@Qualifier("alquilerPorKm")
public class TipoAlquilerPorKm implements ITipoAlquiler {

    private static final Logger logger = LoggerFactory.getLogger(TipoAlquilerPorKm.class);

    @Autowired
    IPromocionService promocionService;

    public void calcularCosto(Solicitud solicitud) throws MissingResourceException {
        logger.info("Calculando costo de alquiler Solicitud id: " + solicitud.getId());

        Alquiler alquiler = solicitud.getAlquiler();

        if(alquiler.getCantidadKms() == null || alquiler.getCantidadKms().equals(0)) {
            throw new MissingResourceException("El campo cantidadKms es necesario para calcular el costo final del alquiler.","","cantidadKms");
        }

        alquiler.setCostoFinal(alquiler.getCantidadKms() * CostoPorTipoAlquilerEnum.POR_KMS.getCosto());

        logger.info("El costo (sin promo) de la Solicitud id: " + solicitud.getId() + " es $" + alquiler.getCostoFinal());

        if (alquiler.isAplicarPromo())
            promocionService.calcularPromo(solicitud);
    }
}
