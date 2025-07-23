package com.zoo.animale_service.service;

import com.zoo.animale_service.dto.AnimaleDTO;

import java.util.List;

public interface AnimaleService {

    /**
     * Interfaccia Service che definisce le operazioni di business disponibili
     * per l'entità associata. Serve come contratto tra il controller e il livello
     * di accesso ai dati, favorendo la separazione delle responsabilità e la
     * manutenibilità del codice.
     */

    List<AnimaleDTO> getAll();
    AnimaleDTO findById(Long id);
    AnimaleDTO save(AnimaleDTO dto);
    AnimaleDTO update(Long id, AnimaleDTO dto);
    void delete(Long id);

}
