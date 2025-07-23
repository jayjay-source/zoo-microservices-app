package com.zoo.animale_service.mapper;

import com.zoo.animale_service.dto.AnimaleDTO;
import com.zoo.animale_service.entity.Animale;
import org.springframework.stereotype.Component;

@Component
public class AnimaleMapper {

    /**
     * Una classe Mapper è responsabile della conversione tra entità e DTO (Data Transfer Object)
     * e viceversa. Consente di separare la logica di mapping dal resto dell'applicazione,
     * rendendo il codice più pulito e manutenibile.
     * Annotata con @Component per permettere l'iniezione automatica da parte di Spring.
     */

    public AnimaleDTO toDto(Animale animale){
        return AnimaleDTO.builder()
                .id(animale.getId())
                .nome(animale.getNome())
                .specie(animale.getSpecie())
                .dataNascita(animale.getDataNascita())
                //.habitatId(animale.getHabitatId())
                .build();
    }

    public Animale toEntity(AnimaleDTO dto){
        return Animale.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .specie(dto.getSpecie())
                .dataNascita(dto.getDataNascita())
                //.habitatId(dto.getHabitatId())
                .build();
    }

}
