package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.*;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import com.valtech.alquilauto.factories.tipoAlquiler.impl.TipoAlquilerPorKm;
import com.valtech.alquilauto.requests.SolicitudRequest;
import com.valtech.alquilauto.states.EnCursoState;
import com.valtech.alquilauto.states.FinalizadoState;
import com.valtech.alquilauto.states.IniciadoState;
import com.valtech.alquilauto.states.PendienteState;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {AlquilautoApplication.class})
public class SolicitudServiceImplTest {

    private Solicitud solicitud;
    private Automovil automovil;
    private Alquiler alquiler;
    private Cliente cliente;

    private static Map<UUID, Solicitud> arraySolicitudes = new HashMap<>();
    private static boolean setUpIsDone = false;

    @Autowired
    private SolicitudDAO solicitudDAO;

    @Before
    public void setUp() throws Exception {
        if(setUpIsDone)
            return;

        automovil = new Automovil(1L, true, "AAA111");
        alquiler = new Alquiler(automovil, 1L, true);

        cliente = new Cliente("Jose Perez", "11111111");

        solicitud = new Solicitud();
        solicitud.setId(UUID.fromString("ff3121d2-9db0-4952-9f65-a36f8015ad6e"));
        solicitud.setAlquiler(alquiler);

        solicitud.setCliente(cliente);
        solicitud.setActualState(new PendienteState());

        arraySolicitudes.put(solicitud.getId(), solicitud);

        setUpIsDone = true;
    }

    @Test
    public void addOne() {
        Solicitud solicitud2 = new Solicitud();
        arraySolicitudes.put(solicitud2.getId(), solicitud2);

        Solicitud solicitud3 = arraySolicitudes.get(solicitud2.getId());

        assertEquals(solicitud3.getId(), solicitud2.getId());
        arraySolicitudes.remove(solicitud2.getId());
    }

    @Test
    public void findAll() {
        assertEquals(arraySolicitudes.size(), 1);
    }

    @Test
    public void updateOne() {
        String dni = "1122334455";
        Solicitud solicitud = arraySolicitudes.get(UUID.fromString("ff3121d2-9db0-4952-9f65-a36f8015ad6e"));
        solicitud.getCliente().setDniCliente(dni);

        arraySolicitudes.replace(solicitud.getId(), solicitud);

        Solicitud solicitud2 = arraySolicitudes.get(UUID.fromString("ff3121d2-9db0-4952-9f65-a36f8015ad6e"));

        assertEquals(dni, solicitud2.getCliente().getDniCliente());
    }

    @Test
    public void findOne() {
        Solicitud solicitud = arraySolicitudes.get(UUID.fromString("ff3121d2-9db0-4952-9f65-a36f8015ad6e"));
        assertEquals(solicitud.getId(), UUID.fromString("ff3121d2-9db0-4952-9f65-a36f8015ad6e"));
    }

    @Test
    public void updateSolicitud() {

        Automovil automovil3 = new Automovil(1L, true, "AAA111");
        Solicitud solicitud3 = new Solicitud();
        Cliente cliente1 = new Cliente("Jose Perez", "11111111");

        solicitud3.setCliente(cliente1);

        TipoAlquilerPorKm tipoAlquilerPorKm = new TipoAlquilerPorKm();

        Alquiler alquiler2 = new Alquiler(automovil3, 2L, false);
        alquiler2.setFechaInicio(LocalDateTime.now());
        alquiler2.setFechaFin(LocalDateTime.now().plusDays(1));

        SolicitudRequest solicitudRequest = new SolicitudRequest(null, 1L, 2L, false);
        solicitudRequest.setAutomovil(automovil3);
        solicitud3.setActualState(new PendienteState());
        solicitud3.getActualState().siguienteState(solicitud3, solicitudRequest);
        solicitudRequest.setTipoAlquiler(tipoAlquilerPorKm);
        solicitudRequest.setCantidadKms(1000L);
        solicitud3.getActualState().siguienteState(solicitud3, solicitudRequest);
        solicitud3.getActualState().siguienteState(solicitud3, solicitudRequest);

        assertEquals(solicitud3.getActualState().getClass(), FinalizadoState.class);

    }
}