package com.manu.ClientesSpring;

import com.manu.ClientesSpring.gui.Ventana;
import com.manu.ClientesSpring.gui.VentanaController;
import com.manu.ClientesSpring.servicios.ClienteServicioImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesSpringApplication {

	public static void main(String[] args) {

//		Ventana ventana = new Ventana();
//		ClienteServicioImpl clienteServicio = new ClienteServicioImpl();
//		VentanaController ventanaController = new VentanaController(ventana,clienteServicio);

		SpringApplication.run(ClientesSpringApplication.class, args);

	}

}
