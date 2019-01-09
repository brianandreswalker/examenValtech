package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.enums.TipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.BaseTipoAlquilerFactory;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;

public class TipoAlquilerFactory implements BaseTipoAlquilerFactory {

    private HashMap<Long, ITipoAlquiler> tipoAlquilerMap = new HashMap<Long, ITipoAlquiler>();

    @Autowired
    private ITipoAlquiler alquilerPorHora;

    @Autowired
    private ITipoAlquiler alquilerPorKm;

    @Autowired
    private ITipoAlquiler alquilerPorSemana;

    @Autowired
    private ITipoAlquiler alquilerPromocional;

    public ITipoAlquiler createTipoAlquiler(Long tipoAlquiler) {
        if(tipoAlquilerMap.isEmpty())
            cargarTipoAlquilerMap();
        return tipoAlquilerMap.get(tipoAlquiler);
    }

    private void cargarTipoAlquilerMap(){
        tipoAlquilerMap.put(TipoAlquilerEnum.POR_HORA.getId(), alquilerPorHora);
        tipoAlquilerMap.put(TipoAlquilerEnum.POR_KMS.getId(), alquilerPorKm);
        tipoAlquilerMap.put(TipoAlquilerEnum.POR_SEMANA.getId(), alquilerPorSemana);
        tipoAlquilerMap.put(TipoAlquilerEnum.PROMOCIONAL.getId(), alquilerPromocional);
    }
}
