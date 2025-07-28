package com.zoo.animale_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.animale_service.entity.Animale;

@Repository //singleton bean
public interface AnimaleRepository extends JpaRepository<Animale, Long> {

    /**
     * Questa interfaccia rappresenta un repository Spring Data JPA.
     * Estende JpaRepository per fornire operazioni CRUD e funzionalità avanzate
     * di accesso ai dati su una specifica entità.
     * Spring genera automaticamente l'implementazione al runtime.
     */


    // Interfaccia, riduce accoppiamento (SOLID – Dependency Inversion)

    /**
     * Principi SOLID:
     * 
     * SOLID è un acronimo che rappresenta cinque principi fondamentali della programmazione orientata agli 
     * oggetti, pensati per scrivere codice più comprensibile, flessibile e manutenibile:
     * 
     * S - Single Responsibility Principle (SRP): una classe dovrebbe avere una sola responsabilità.
     * O - Open/Closed Principle (OCP): il codice dovrebbe essere aperto all'estensione ma chiuso alla 
     * modifica.
     * L - Liskov Substitution Principle (LSP): una sottoclasse deve poter sostituire la classe base senza 
     * rompere il comportamento.
     * I - Interface Segregation Principle (ISP): è meglio avere molte interfacce specifiche che una generica 
     * e pesante.
     * D - Dependency Inversion Principle (DIP): le classi dovrebbero dipendere da astrazioni, non da classi 
     * concrete.
     */

     /**
      * QUI ED IN ALTRE PARTI DEL PROGRAMMA UTILIZZIAMO IL DESIGN PATTERN SINGLETON
     * Design Pattern: Singleton
     * 
     * Il Singleton è un pattern creazionale che garantisce che una classe abbia una sola istanza globale
     * e fornisce un punto di accesso condiviso a quell'istanza.
     * 
     * Caratteristiche:
     * - Costruttore privato per impedire la creazione di nuove istanze.
     * - Istanza statica accessibile tramite un metodo pubblico (es. getInstance()).
     * 
     * Utilizzo tipico:
     * - Logger, configurazioni globali, connessioni centralizzate.
     * 
     * Singleton in Spring:
     * - Per impostazione predefinita, tutti i Bean di Spring hanno scope Singleton.
     *   Ciò significa che Spring crea **una sola istanza** del Bean per l'intero ApplicationContext,
     *   che viene riutilizzata ovunque venga iniettata.
     * 
     * Nota: Il Singleton di Spring è **gestito dal contenitore**, non ha bisogno di implementare il pattern manualmente.
     */


    


}
