package com.zoo.discovery_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	/**
	 * Questo progetto rappresenta il Discovery Server configurato con Eureka Server, 
	 * componente centrale dell'architettura a microservizi. 
	 * Il server permette la registrazione automatica dei servizi client 
	 * e consente il loro rilevamento dinamico da parte di altri microservizi. 
	 * Viene creato come Spring Boot Application con la dipendenza 'spring-cloud-starter-netflix-eureka-server' 
	 * e annotato con @EnableEurekaServer.
	 */


	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
