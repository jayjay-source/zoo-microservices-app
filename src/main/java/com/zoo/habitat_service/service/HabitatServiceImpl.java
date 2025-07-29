package com.zoo.habitat_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zoo.habitat_service.dto.HabitatDTO;
import com.zoo.habitat_service.entity.Habitat;
import com.zoo.habitat_service.exception.ResourceNotFoundException;
import com.zoo.habitat_service.mapper.HabitatMapper;
import com.zoo.habitat_service.repository.HabitatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitatServiceImpl implements HabitatService{

    private final HabitatRepository repository;
    private final HabitatMapper mapper;

    @Override
    public List<HabitatDTO> getAll() {
        return repository.findAll().stream()
                    .map(mapper::toDto)
                    .toList();
    }
    @Override
    public HabitatDTO findByUuid(String uuid) {
        Habitat habitat = repository.findByUuid(uuid)
                    .orElseThrow(() -> new ResourceNotFoundException("Habitat con Uuid:" + uuid + " non trovato"));
        return mapper.toDto(habitat);
    }
    @Override
    public HabitatDTO save(HabitatDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
    @Override
    public HabitatDTO update(String uuid, HabitatDTO dto) {
       Habitat existing = repository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Habitat non trovato"));
        existing.setName(dto.getName());

        return mapper.toDto(repository.save(existing));
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    



}
