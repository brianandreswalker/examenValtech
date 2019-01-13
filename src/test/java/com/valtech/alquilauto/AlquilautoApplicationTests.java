package com.valtech.alquilauto;

import com.valtech.alquilauto.entities.Solicitud;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlquilautoApplicationTests {

	@Test
	public void crearSolicitud() {
		Solicitud solicitud = new Solicitud();

		Assert.assertNotNull(solicitud);
	}

}

