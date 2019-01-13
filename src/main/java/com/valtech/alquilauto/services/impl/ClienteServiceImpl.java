package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.UUID;

@Service
@Qualifier("clienteService")
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    @Override
    public Cliente addOne(Cliente cliente) {
        if( cliente.getDniCliente() == null || cliente.getDniCliente() == "")
            throw new MissingResourceException("El campo dniCliente es necesario para crear un Cliente","","dniCliente");
        return clienteDAO.addOne(new Cliente(cliente.getNombreCliente(), cliente.getDniCliente()));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente updateOne(Cliente cliente) {
        return clienteDAO.updateOne(cliente);
    }

    @Override
    public Cliente findOneByDni(String dniCliente) {
        return clienteDAO.findOneByDni(dniCliente);
    }

    @Override
    public Cliente findOne(UUID idCliente) {
        return clienteDAO.findOne(idCliente);
    }
}
