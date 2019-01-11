package com.valtech.alquilauto.daos;

import com.valtech.alquilauto.entities.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteDAO {

    Cliente findOneByDni(String dniCliente);

    Cliente findOne(UUID dniCliente);

    Cliente addOne(Cliente cliente);

    List<Cliente> findAll();

    Cliente updateOne(Cliente cliente);
}
