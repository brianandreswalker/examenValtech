package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.PromocionDAO;
import com.valtech.alquilauto.entities.Promocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Qualifier("promocionDAO")
public class PromocionDAOImpl implements PromocionDAO {

    @Autowired
    AlquilautoApplication main;

    public Promocion findOne(UUID promocionId){
        Map<UUID, Promocion> promociones = main.getArrayPromociones();
        return promociones.get(promocionId);
    }

    public Promocion addOne(Promocion promocion) {
        Map<UUID, Promocion> promociones = main.getArrayPromociones();
        promociones.put(promocion.getId(), promocion);
        return promocion;
    }

    public List<Promocion> findAll(){
        List<Promocion> list = new ArrayList<>(main.getArrayPromociones().values());
        return list;
    }
}
