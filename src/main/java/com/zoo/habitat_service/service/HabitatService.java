package com.zoo.habitat_service.service;

import java.util.List;

import com.zoo.habitat_service.dto.HabitatDTO;

public interface HabitatService {

    List<HabitatDTO> getAll();
    HabitatDTO findByUuid(String uuid);
    HabitatDTO save(HabitatDTO dto);
    HabitatDTO update(String uuid, HabitatDTO dto);
    void delete(Long id);

}
