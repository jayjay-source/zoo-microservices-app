package com.zoo.habitat_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.habitat_service.entity.Habitat;

public interface HabitatRepository extends JpaRepository<Habitat, Long>{

    Optional<Habitat> findByUuid(String uuid);

}
