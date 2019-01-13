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
@Qualifier("alquilerPorSemana")
public class TipoAlquilerPorSemana implements ITipoAlquiler {

    private static final Logger logger = LoggerFactory.getLogger(TipoAlquilerPorSemana.class);


    @Autowired
    IPromocionService promocionService;

    public void calcularCosto(Solicitud solicitud) {
        logger.info("Calculando costo de alquiler Solicitud id: " + solicitud.getId());

        Alquiler alquiler = solicitud.getAlquiler();

        // Si solicitó Alquiler por Semana se le debe cobrar minimamente 1 semana.
        Long cantidadSemanas = ( alquiler.getCantidadSemanas() == 0 ) ? 1 : alquiler.getCantidadSemanas();
        Double costoFinal = cantidadSemanas * CostoPorTipoAlquilerEnum.POR_SEMANA.getCosto();

        if(alquiler.getCantidadKms()>3000D){
            costoFinal =+ (alquiler.getCantidadKms() % 3D) * CostoPorTipoAlquilerEnum.POR_SEMANA_PLUS.getCosto();
        }

        alquiler.setCostoFinal(costoFinal);

        logger.info("El costo (sin promo) de la Solicitud id: " + solicitud.getId() + " es $" + costoFinal);

        if (alquiler.isAplicarPromo())
            promocionService.calcularPromo(solicitud);
    }
}
