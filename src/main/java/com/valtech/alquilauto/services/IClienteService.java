package com.valtech.alquilauto.services;

import com.valtech.alquilauto.entities.Cliente;

import java.util.List;
import java.util.UUID;

public interface IClienteService {

    Cliente addOne(Cliente cliente);

    List<Cliente> findAll();

    Cliente updateOne(Cliente cliente);

    Cliente findOneByDni(String dniCliente);

    Cliente findOne(UUID idCliente);

}
