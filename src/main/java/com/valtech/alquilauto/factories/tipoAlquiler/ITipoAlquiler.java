package com.valtech.alquilauto.factories.tipoAlquiler;

import com.valtech.alquilauto.entities.Solicitud;

import java.util.MissingResourceException;

public interface ITipoAlquiler {

    void calcularCosto(Solicitud solicitud) throws MissingResourceException;
}
