package com.valtech.alquilauto;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Promocion;
import com.valtech.alquilauto.entities.Solicitud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class AlquilautoApplication {

	private static Map<UUID, Solicitud> arraySolicitudes = new HashMap<>();
	private static Map<Long, Automovil> arrayAutomoviles = new HashMap<>();
	private static Map<UUID, Cliente> arrayClientes = new HashMap<>();
	private static Map<UUID, Promocion> arrayPromociones = new HashMap<>();

	public static void main(String[] args) {
		arrayAutomoviles.put(1L, new Automovil(1L,true,"AAA111"));
		arrayAutomoviles.put(2L, new Automovil(2L,true,"BBB222"));
		arrayAutomoviles.put(3L, new Automovil(3L,true,"CCC333"));
		arrayAutomoviles.put(4L, new Automovil(4L,true,"DDD444"));
		arrayAutomoviles.put(5L, new Automovil(5L,true,"EEE555"));
		arrayAutomoviles.put(6L, new Automovil(6L,true,"FFF666"));

		SpringApplication.run(AlquilautoApplication.class, args);
	}

	public static Map<UUID, Solicitud> getArraySolicitudes() {
		return arraySolicitudes;
	}

	public static void setArraySolicitudes(Map<UUID, Solicitud> arraySolicitudes) {
		AlquilautoApplication.arraySolicitudes = arraySolicitudes;
	}

	public static Map<Long, Automovil> getArrayAutomoviles() {
		return arrayAutomoviles;
	}

	public static void setArrayAutomoviles(Map<Long, Automovil> arrayAutomoviles) {
		AlquilautoApplication.arrayAutomoviles = arrayAutomoviles;
	}

	public static Map<UUID, Cliente> getArrayClientes() {
		return arrayClientes;
	}

	public static void setArrayClientes(Map<UUID, Cliente> arrayClientes) {
		AlquilautoApplication.arrayClientes = arrayClientes;
	}

	public static Map<UUID, Promocion> getArrayPromociones() {
		return arrayPromociones;
	}

	public static void setArrayPromociones(Map<UUID, Promocion> arrayPromociones) {
		AlquilautoApplication.arrayPromociones = arrayPromociones;
	}
}

