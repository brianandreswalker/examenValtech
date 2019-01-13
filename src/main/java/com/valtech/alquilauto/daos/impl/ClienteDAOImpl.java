package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.entities.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Qualifier("clienteDAO")
public class ClienteDAOImpl implements ClienteDAO {

    private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

    @Autowired
    AlquilautoApplication main;

    public Cliente findOneByDni(String dniCliente){
        logger.info("Buscando un Cliente con dni: " + dniCliente);
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        Cliente cliente = null;

        for (Map.Entry<UUID, Cliente> cli : clientes.entrySet()) {
            if(cli.getValue().getDniCliente().equals(dniCliente))
                cliente = cli.getValue();
        }

        return cliente;
    }

    public Cliente findOne(UUID clienteId){
        logger.info("Buscando un Cliente con id: " + clienteId);
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        return clientes.get(clienteId);
    }

    public Cliente addOne(Cliente cliente) {
        logger.info("Agregando un Cliente con id: " + cliente.getIdCliente());
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        logger.info("Buscando todos los Clientes...");
        List<Cliente> list = new ArrayList<>(main.getArrayClientes().values());
        return list;
    }

    public Cliente updateOne(Cliente cliente){
        logger.info("Actualizando un Cliente con id: " + cliente.getIdCliente());
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        clientes.replace(cliente.getIdCliente(), cliente);
        return cliente;
    }

}
