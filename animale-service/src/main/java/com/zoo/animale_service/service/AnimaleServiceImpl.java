package com.zoo.animale_service.service;

import com.zoo.animale_service.dto.AnimaleDTO;
import com.zoo.animale_service.entity.Animale;
import com.zoo.animale_service.mapper.AnimaleMapper;
import com.zoo.animale_service.repository.AnimaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimaleServiceImpl implements AnimaleService{

    /**
     * Implementazione dell'interfaccia Service per la gestione della logica di business
     * relativa all'entità associata. Questa classe è annotata con @Service per essere
     * rilevata da Spring e permette l'iniezione dei repository e di altri componenti necessari.
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
                .orElseThrow(() -> new RuntimeException("Animale non trovato"));
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
