package com.zoo.animale_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animale {

    /**
     * Una classe in Java è un modello (o blueprint) che definisce le proprietà (attributi)
     * e i comportamenti (metodi) di un oggetto. Rappresenta un'entità logica nel programma
     * e viene utilizzata per creare istanze (oggetti) che condividono la stessa struttura e funzionalità.
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String specie;
    private LocalDate dataNascita;

    //private Long habitatId;
}
