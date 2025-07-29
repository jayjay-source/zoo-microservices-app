package com.zoo.animale_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.animale_service.dto.AnimaleDTO;
import com.zoo.animale_service.entity.Animale;
import com.zoo.animale_service.exception.ResourceNotFoundException;
import com.zoo.animale_service.mapper.AnimaleMapper;
import com.zoo.animale_service.repository.AnimaleRepository;

import lombok.RequiredArgsConstructor;

// Design pattern Service per logica di business
/**
 * Design Pattern: Service
 * 
 * Il pattern Service separa la logica di business dal controller e dalle classi di accesso ai dati 
 * (repository).
 * 
 * Responsabilità:
 * - Incapsula la logica applicativa centrale.
 * - Coordina operazioni tra più repository, validazioni o trasformazioni.
 * - Rende il codice più modulare, riutilizzabile e testabile.
 * 
 * In un'architettura a livelli (layered architecture), il Service rappresenta il livello intermedio tra 
 * Controller e Repository.
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
     * Nota: Il Singleton di Spring è **gestito dal contenitore**, non ha bisogno di implementare il pattern 
     * manualmente.
     */
@Service
@RequiredArgsConstructor
public class AnimaleServiceImpl implements AnimaleService{

    /**
     * Implementazione dell'interfaccia Service per la gestione della logica di business
     * relativa all'entità associata. Questa classe è annotata con @Service per essere
     * rilevata da Spring e permette l'iniezione dei repository e di altri componenti necessari.
     */

     //@Autowired // Dependency Injection in Spring
     /**
     * Dependency Injection (DI) in Spring:
     * 
     * Spring gestisce automaticamente le dipendenze tra le classi grazie all'iniezione dei bean.
     * 
     * 
     * 
     * Tipi di iniezione:
     * - Costruttore (@Autowired o implicita in Spring Boot >= 4.3)
     * - Setter (meno usato)
     * - Field (non consigliato per testabilità)
     * 
     * Vantaggi:
     * - Riduce l'accoppiamento tra le classi.
     * - Migliora la manutenibilità e la testabilità del codice.
     * - Permette l’inversione del controllo (Inversion of Control - IoC), delegando a Spring la 
     * creazione degli oggetti.
     * 
     * Esempio: il costruttore riceve il repository come dipendenza e Spring lo inietta automaticamente.
     */

     /**
     * Spring Bean:
     * 
     * Un Bean è un oggetto gestito dal contenitore Spring (ApplicationContext).
     * 
     * Caratteristiche:
     * - Spring si occupa della creazione, configurazione e ciclo di vita del bean.
     * - Ogni bean viene istanziato una sola volta per impostazione predefinita (scope singleton).
     * 
     * Come si definisce un Bean:
     * - Annotando una classe con @Component, @Service, @Repository o @Controller (scansione automatica).
     * - Oppure manualmente con il metodo @Bean all'interno di una classe @Configuration.
     * 
     * Vantaggi:
     * - Permette l’iniezione delle dipendenze (Dependency Injection).
     * - Centralizza la gestione degli oggetti e migliora l'organizzazione del codice.
     */

    private final AnimaleRepository repository;
    private final AnimaleMapper mapper;
    

    @Override
    public List<AnimaleDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public AnimaleDTO findById(Long id) {
        Animale animale = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale con ID:" + id + " non trovato"));
        /*
         * qui ho gestito un eccezione con ResourceNotFoundException, prevedendo la possibilità che magari
         * un animale possa non venire trovato tramite il suo id, è una operazione molto comune da fare 
         * insieme
         * a .orElseThrow(), in quanto il flusso si interrompe e ottengo un messaggio grazie all'eccezione
         * personalizzata, utile per il debug
        */
        return mapper.toDto(animale);
    }

    @Override
    public AnimaleDTO save(AnimaleDTO dto) {
        //Animale animale = mapper.toEntity(dto);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public AnimaleDTO update(Long id, AnimaleDTO dto) {
        Animale existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animale non trovato"));
        existing.setNome(dto.getNome());
        existing.setSpecie(dto.getSpecie());
        existing.setDataNascita(dto.getDataNascita());

        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
