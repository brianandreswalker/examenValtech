package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.entities.Cliente;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ClienteServiceImplTest {
    
    Cliente cliente1 = new Cliente("Pepe Perez", "1122334455");
    Cliente cliente2 = new Cliente("Juan Juano", "2233445566");
    Cliente cliente3 = new Cliente("Lucas Lucrez", "3344556677");

    private static Map<UUID, Cliente> arrayClientes = new HashMap<>();

    private static boolean setUpIsDone = false;

    @Before
    public void setUp() throws Exception {
        if(setUpIsDone)
            return;
        arrayClientes.put(cliente1.getIdCliente(), cliente1);
        arrayClientes.put(cliente2.getIdCliente(), cliente2);
        arrayClientes.put(cliente3.getIdCliente(), cliente3);

        setUpIsDone = true;
    }

    @Test
    public void findAll() {
        assertEquals(arrayClientes.size(), 3);
    }

    @Test
    public void addOne() {
        Cliente cliente4 = new Cliente("Jose Perez","11111111");
        arrayClientes.put(cliente4.getIdCliente(), cliente4);

        Cliente cliente5 = null;
        for (Map.Entry<UUID, Cliente> cli : arrayClientes.entrySet()) {
            if(cli.getValue().getDniCliente().equals(cliente4.getDniCliente()))
                cliente5 = cli.getValue();
        }

        assertEquals(cliente4.getDniCliente(), cliente5.getDniCliente());
        arrayClientes.remove(cliente4.getIdCliente());
    }

    @Test
    public void updateOne() {
        UUID idCliente = arrayClientes.entrySet().iterator().next().getKey();
        Cliente cliente = arrayClientes.get(idCliente);
        cliente.setDniCliente("12345678");
        arrayClientes.replace(idCliente, cliente);
        Cliente cliente2 = arrayClientes.get(idCliente);
        assertEquals(cliente.getDniCliente(), cliente2.getDniCliente());
    }

    @Test
    public void findOneByDni() {
        Cliente cliente3 = null;
        for (Map.Entry<UUID, Cliente> cli : arrayClientes.entrySet()) {
            if(cli.getValue().getDniCliente().equals("2233445566"))
                cliente3 = cli.getValue();
        }

        assertEquals(cliente3.getDniCliente(), "2233445566");
    }

    @Test
    public void findOne() {
        UUID idCliente = arrayClientes.entrySet().iterator().next().getKey();
        Cliente cliente = arrayClientes.get(idCliente);
        assertEquals(cliente.getIdCliente(), idCliente);
    }
}