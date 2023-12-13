package com.iva.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class LabSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabSpringApplication.class, args);
	}

}
