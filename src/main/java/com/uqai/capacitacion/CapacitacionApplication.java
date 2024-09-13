package com.uqai.capacitacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // En nuevas versiones no es necesaria
@SpringBootApplication
public class CapacitacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapacitacionApplication.class, args);
	}

}
