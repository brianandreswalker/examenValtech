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
	private static Map<UUID, Automovil> arrayAutomoviles = new HashMap<>();
	private static Map<UUID, Cliente> arrayClientes = new HashMap<>();
	private static Map<UUID, Promocion> arrayPromociones = new HashMap<>();

	public static void main(String[] args) {
		Automovil auto1 = new Automovil(UUID.randomUUID(), true, "AAA111");
		Automovil auto2 = new Automovil(UUID.randomUUID(), true, "BBB222");
		Automovil auto3 = new Automovil(UUID.randomUUID(), true, "CCC333");
		Automovil auto4 = new Automovil(UUID.randomUUID(), true, "DDD444");
		Automovil auto5 = new Automovil(UUID.randomUUID(), true, "EEE555");

		arrayAutomoviles.put(auto1.getIdAutomovil(), auto1);
		arrayAutomoviles.put(auto2.getIdAutomovil(), auto2);
		arrayAutomoviles.put(auto3.getIdAutomovil(), auto3);
		arrayAutomoviles.put(auto4.getIdAutomovil(), auto4);
		arrayAutomoviles.put(auto5.getIdAutomovil(), auto5);

		SpringApplication.run(AlquilautoApplication.class, args);
	}

	public static Map<UUID, Solicitud> getArraySolicitudes() {
		return arraySolicitudes;
	}

	public static void setArraySolicitudes(Map<UUID, Solicitud> arraySolicitudes) {
		AlquilautoApplication.arraySolicitudes = arraySolicitudes;
	}

	public static Map<UUID, Automovil> getArrayAutomoviles() {
		return arrayAutomoviles;
	}

	public static void setArrayAutomoviles(Map<UUID, Automovil> arrayAutomoviles) {
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

