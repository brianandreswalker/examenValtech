package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.entities.Cliente;
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

    @Autowired
    AlquilautoApplication main;

    public Cliente findOneByDni(String dniCliente){
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        Cliente cliente = null;

        for (Map.Entry<UUID, Cliente> cli : clientes.entrySet()) {
            if(cli.getValue().getDniCliente().equals(dniCliente))
                cliente = cli.getValue();
        }

        return cliente;
    }

    public Cliente findOne(UUID clienteId){
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        return clientes.get(clienteId);
    }

    public Cliente addOne(Cliente cliente) {
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        clientes.put(cliente.getId(), cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        List<Cliente> list = new ArrayList<>(main.getArrayClientes().values());
        return list;
    }

    public Cliente updateOne(Cliente cliente){
        Map<UUID, Cliente> clientes = main.getArrayClientes();
        clientes.replace(cliente.getId(), cliente);
        return cliente;
    }

}
