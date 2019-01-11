package com.valtech.alquilauto.factories.tipoAlquiler.impl;

import com.valtech.alquilauto.enums.TipoAlquilerEnum;
import com.valtech.alquilauto.factories.tipoAlquiler.BaseTipoAlquilerFactory;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional
public class TipoAlquilerFactory implements BaseTipoAlquilerFactory {

    private HashMap<Long, ITipoAlquiler> tipoAlquilerMap = new HashMap<Long, ITipoAlquiler>();

    @Autowired
    @Qualifier("alquilerPorHora")
    private ITipoAlquiler alquilerPorHora;

    @Autowired
    @Qualifier("alquilerPorKm")
    private ITipoAlquiler alquilerPorKm;

    @Autowired
    @Qualifier("alquilerPorSemana")
    private ITipoAlquiler alquilerPorSemana;

    public ITipoAlquiler createTipoAlquiler(Long tipoAlquiler) {
        if(tipoAlquilerMap.isEmpty())
            cargarTipoAlquilerMap();
        return tipoAlquilerMap.get(tipoAlquiler);
    }

    private void cargarTipoAlquilerMap(){
        tipoAlquilerMap.put(TipoAlquilerEnum.POR_HORA.getId(), alquilerPorHora);
        tipoAlquilerMap.put(TipoAlquilerEnum.POR_KMS.getId(), alquilerPorKm);
        tipoAlquilerMap.put(TipoAlquilerEnum.POR_SEMANA.getId(), alquilerPorSemana);
    }
}
