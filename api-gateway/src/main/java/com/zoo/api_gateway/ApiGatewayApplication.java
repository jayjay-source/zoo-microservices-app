package com.zoo.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	/**
	 * API Gateway - Spring Cloud Gateway:
	 * 
	 * Questo componente funge da punto di ingresso unico per tutte le richieste client verso i microservizi.
	 * 
	 * Responsabilità:
	 * - Instradamento dinamico delle richieste ai microservizi.
	 * - Sicurezza (autenticazione, autorizzazione).
	 * - Logging, rate limiting, gestione degli errori.
	 * - Caching e compressione.
	 * 
	 * Design Pattern utilizzato: 
	 * - **Proxy Pattern**: il gateway agisce come un proxy che incapsula le chiamate ai servizi interni.
	 * 
	 * Il Gateway è integrato con il Discovery Server (es. Eureka) per conoscere dinamicamente i servizi 
	 * disponibili.
	 */


	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
