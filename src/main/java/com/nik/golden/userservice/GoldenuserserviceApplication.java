package com.nik.golden.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@CrossOrigin("http://localhost:3000/")
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot golden user service",
				description = "Spring boot golden user service",
				version = "v1.0",
				contact = @Contact(
					name = "Nikhil",
					email = "nik.bhatia.13@gmail.com",
					url = "https://www.google.com"
				),
				license = @License(
					name = "Apache 2.0",
					url = "https://www.google.com"
				)
			),
		externalDocs = @ExternalDocumentation(
					description = ""
				)
)
public class GoldenuserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldenuserserviceApplication.class, args);
	}

	
}
