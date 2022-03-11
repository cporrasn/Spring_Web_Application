package com.example.API_REST;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		Log log= LogFactory.getLog(ApiRestApplication.class);
		log.trace("Inicio");
		SpringApplication.run(ApiRestApplication.class, args);
	}

}
