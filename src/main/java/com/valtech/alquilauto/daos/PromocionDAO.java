package com.valtech.alquilauto.daos;

import com.valtech.alquilauto.entities.Promocion;

import java.util.List;
import java.util.UUID;

public interface PromocionDAO {

    Promocion findOne(UUID idPromocion);

    Promocion addOne(Promocion promocion);

    List<Promocion> findAll();
}
