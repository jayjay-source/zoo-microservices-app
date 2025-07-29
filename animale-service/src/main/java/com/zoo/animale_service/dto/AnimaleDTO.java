package com.zoo.animale_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimaleDTO {

    /**
     * Una classe DTO (Data Transfer Object) è una struttura semplice usata per trasportare dati
     * tra processi o livelli di un'applicazione. Contiene solo campi, costruttori e metodi getter/setter,
     * senza logica di business, ed è pensata per facilitare il trasferimento efficiente e sicuro delle 
     * informazioni.
     * 
     * Creiamo il dto soltanto per dare al front-end i dati essenziali per non mostrare quelli sensibili
     */
    // Serve a separare entity dal layer REST (Single Responsibility Principle)
    /*Qui potevo utilizzare il Factory, un design pattern creazionale, che definisce un'interfaccia per creare un oggetto
     * e lascia che siano le sottoclassi a decidere cosa istanziare. A seconda dell'animale che poteva essere in un
     * determinato habitat potevo utilizzare il Factory
     */
    private Long id;
    private String nome;
    private String specie;
    private LocalDate dataNascita;
    
    //private Long habitatId;

}

