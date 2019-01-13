package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Promocion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PromocionServiceImplTest {

    Promocion promocion1 = new Promocion("Promo 20%", 20D);
    Promocion promocion2 = new Promocion("Promo 30%", 30D);
    Promocion promocion3 = new Promocion("Promo 50%", 50D);

    private static Map<UUID, Promocion> arrayPromociones = new HashMap<>();

    private static boolean setUpIsDone = false;

    @Before
    public void setUp() throws Exception {
        if (setUpIsDone)
            return;
        arrayPromociones.put(promocion1.getId(), promocion1);
        arrayPromociones.put(promocion2.getId(), promocion2);
        arrayPromociones.put(promocion3.getId(), promocion3);

        setUpIsDone = true;
    }

    @Test
    public void calcularPromo() {
    }

    @Test
    public void addOne() {
        Promocion promocion4 = new Promocion("Promo 80%", 80D);
        arrayPromociones.put(promocion4.getId(), promocion4);

        Promocion promocion5 = null;
        for (Map.Entry<UUID, Promocion> promo : arrayPromociones.entrySet()) {
            if (promo.getValue().getId().equals(promocion4.getId()))
                promocion5 = promo.getValue();
        }

        assertEquals(promocion4.getPorcentajeDeDescuento(), promocion5.getPorcentajeDeDescuento());
        arrayPromociones.remove(promocion4.getId());
    }

    @Test
    public void findAll() {
        assertEquals(arrayPromociones.size(), 3);
    }

    @Test
    public void findOne() {
        UUID idPromocion = arrayPromociones.entrySet().iterator().next().getKey();
        Promocion promocion = arrayPromociones.get(idPromocion);
        promocion.setDescripcion("Nombre Nuevo Promo");
        arrayPromociones.replace(idPromocion, promocion);
        Promocion promocion6 = arrayPromociones.get(idPromocion);
        assertEquals(promocion6.getDescripcion(), promocion.getDescripcion());
    }

    @Test
    public void addPromoToCliente() {
        Promocion promocion = arrayPromociones.entrySet().iterator().next().getValue();
        Cliente cliente = new Cliente("Pepe Perez", "0099889900");
        cliente.setPromociones(new ArrayList<>());
        cliente.getPromociones().add(promocion);

        assertFalse(cliente.getPromociones().isEmpty());
    }

}