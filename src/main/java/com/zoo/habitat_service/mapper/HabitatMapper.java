package com.zoo.habitat_service.mapper;

import org.springframework.stereotype.Component;

import com.zoo.habitat_service.dto.HabitatDTO;
import com.zoo.habitat_service.entity.Habitat;

@Component
public class HabitatMapper {

    public HabitatDTO toDto(Habitat habitat){
        return HabitatDTO.builder()
        .id(habitat.getId())
        .uuid(habitat.getUuid())
        .name(habitat.getName())
        .build();
    }

    public Habitat toEntity(HabitatDTO dto){
        return Habitat.builder()
                .id(dto.getId())
                .uuid(dto.getUuid())
                .name(dto.getName())
                .build();
    }

}
