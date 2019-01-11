package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Qualifier("clienteService")
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    @Override
    public Cliente addOne(Cliente cliente) {
        return clienteDAO.addOne(cliente);
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
