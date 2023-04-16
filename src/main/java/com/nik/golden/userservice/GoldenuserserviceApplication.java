package com.nik.golden.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@CrossOrigin("http://localhost:3000/")
public class GoldenuserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldenuserserviceApplication.class, args);
	}

	
}
