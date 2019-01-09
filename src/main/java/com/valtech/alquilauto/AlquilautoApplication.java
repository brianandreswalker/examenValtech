package com.valtech.alquilauto;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.entities.TipoAlquiler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AlquilautoApplication {

	private static List<Solicitud> arraySolicitudes = new ArrayList<>();
	private static List<Automovil> arrayAutomoviles = new ArrayList<>();
	private static List<Cliente> arrayClientes = new ArrayList<>();
	private static List<TipoAlquiler> arrayTipoAlquileres = new ArrayList<>();

	public static void main(String[] args) {
		arrayAutomoviles.add(new Automovil(1L,true,"AAA111"));
		arrayAutomoviles.add(new Automovil(2L,true,"BBB222"));
		arrayAutomoviles.add(new Automovil(3L,true,"CCC333"));
		arrayAutomoviles.add(new Automovil(4L,true,"DDD444"));
		arrayAutomoviles.add(new Automovil(5L,true,"EEE555"));
		arrayAutomoviles.add(new Automovil(6L,true,"FFF666"));

		SpringApplication.run(AlquilautoApplication.class, args);

	}

	public List<Solicitud> getArraySolicitudes() {
		return arraySolicitudes;
	}

	public void setArraySolicitudes(List<Solicitud> arraySolicitudes) {
		this.arraySolicitudes = arraySolicitudes;
	}

	public List<Automovil> getArrayAutomoviles() {
		return arrayAutomoviles;
	}

	public void setArrayAutomoviles(List<Automovil> arrayAutomoviles) {
		this.arrayAutomoviles = arrayAutomoviles;
	}

	public List<Cliente> getArrayClientes() {
		return arrayClientes;
	}

	public void setArrayClientes(List<Cliente> arrayClientes) {
		this.arrayClientes = arrayClientes;
	}

	public List<TipoAlquiler> getArrayTipoAlquileres() {
		return arrayTipoAlquileres;
	}

	public void setArrayTipoAlquileres(List<TipoAlquiler> arrayTipoAlquileres) {
		this.arrayTipoAlquileres = arrayTipoAlquileres;
	}
}

