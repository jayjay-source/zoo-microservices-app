package com.zoo.animale_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimaleDTO {

    /**
     * Una classe DTO (Data Transfer Object) è una struttura semplice usata per trasportare dati
     * tra processi o livelli di un'applicazione. Contiene solo campi, costruttori e metodi getter/setter,
     * senza logica di business, ed è pensata per facilitare il trasferimento efficiente e sicuro delle informazioni.
     */
    private Long id;
    private String nome;
    private String specie;
    private LocalDate dataNascita;
    //private Long habitatId;

}

