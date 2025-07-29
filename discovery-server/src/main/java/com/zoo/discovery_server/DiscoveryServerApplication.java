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
	 * Questo componente gestisce la **registrazione e scoperta** dei microservizi all'interno 
	 * dell'architettura.
	 * 
	 * Eureka supporta la gestione della disponibilità dei servizi, ad esempio, tramite 
	 * il meccanismo di heartbeats che segnala se un servizio è attivo o no.
	 * 
	 * I client (gateway o altri microservizi) possono chiamare i servizi registrati 
	 * tramite il loro nome (non IP, grazie alla registrazione dinamica).
	 * 
	 * 
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
