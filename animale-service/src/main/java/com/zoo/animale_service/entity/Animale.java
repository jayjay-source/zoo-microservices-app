package com.zoo.animale_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Incapsulamento: attributi privati + metodi getter/setter. 
//l'incapsulamento è quel principio della programmazione OOP che consente di nascondere i dettagli
//interni di implementazione dell'oggetto
public class Animale {

    /**
     * Una classe in Java è un modello (o blueprint) che definisce le proprietà (attributi)
     * e i comportamenti (metodi) di un oggetto. Rappresenta un'entità logica nel programma
     * e viene utilizzata per creare istanze (oggetti) che condividono la stessa struttura e funzionalità.
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Principio SRP, ogni classe una responsabilità

    /**
     * SRP - Single Responsibility Principle:
     * Ogni classe dovrebbe avere una sola responsabilità, ovvero un solo motivo per cambiare.
     * In questo caso, la classe Animale si occupa solo di rappresentare i dati di un animale
     * e non gestisce logiche di business o persistenza.
     */

    private String nome;
    private String specie;
    private LocalDate dataNascita;

    //private Long habitatId;
}
