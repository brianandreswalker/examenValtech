package com.valtech.alquilauto;

import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.services.impl.SolicitudServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlquilautoApplicationTests {

	@Autowired
	SolicitudServiceImpl solicitudService;

	@Test
	public void crearSolicitud() {
		Cliente cliente = new Cliente("Pepe" , "43334434");
		Solicitud solicitud = new Solicitud(cliente);


		Assert.assertNotNull(solicitud);
	}

}

