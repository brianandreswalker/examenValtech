package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.entities.Automovil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AutomovilServiceImplTest {

    Automovil automovil1 = new Automovil(1L, true, "AAA111");
    Automovil automovil2 = new Automovil(2L, true, "BBB222");
    Automovil automovil3 = new Automovil(3L, true, "CCC222");

    private static Map<Long, Automovil> arrayAutomoviles = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        arrayAutomoviles.put(automovil1.getIdAutomovil(), automovil1);
        arrayAutomoviles.put(automovil2.getIdAutomovil(), automovil2);
        arrayAutomoviles.put(automovil3.getIdAutomovil(), automovil3);
    }


    @Test
    public void findAll() {
        assertEquals(arrayAutomoviles.size(), 3);
    }

    @Test
    public void findOne() {
        Automovil automovil = arrayAutomoviles.get(1L);
        assertEquals((long)automovil.getIdAutomovil(), 1);
    }

}