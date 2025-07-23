package com.zoo.animale_service.repository;

import com.zoo.animale_service.entity.Animale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaleRepository extends JpaRepository<Animale, Long> {

    /**
     * Questa interfaccia rappresenta un repository Spring Data JPA.
     * Estende JpaRepository per fornire operazioni CRUD e funzionalità avanzate
     * di accesso ai dati su una specifica entità.
     * Spring genera automaticamente l'implementazione al runtime.
     */


}
