package com.zoo.discovery_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	/**
	 * Eureka Discovery Server:
	 * 
	 * Questo componente gestisce la **registrazione e scoperta** dei microservizi all'interno dell'architettura.
	 * 
	 * Responsabilità:
	 * - Permette ai microservizi di registrarsi automaticamente all'avvio.
	 * - Consente agli altri servizi (es. Gateway) di scoprire dinamicamente gli endpoint disponibili.
	 * 
	 * Design Pattern utilizzato:
	 * - **Registry Pattern**: mantiene un registro centralizzato dei servizi attivi e delle loro istanze.
	 * 
	 * Funziona in combinazione con il Gateway per evitare configurazioni statiche degli indirizzi IP.
	 */



	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
