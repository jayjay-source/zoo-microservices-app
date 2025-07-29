package com.zoo.habitat_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.habitat_service.dto.HabitatDTO;
import com.zoo.habitat_service.service.HabitatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/habitat")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") //CORS
public class HabitatController {

    private final HabitatService service;

    //di seguito andranno gli endpoint

    @GetMapping
    public List<HabitatDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("{uuid}")
    public ResponseEntity<HabitatDTO> getByUuid(@PathVariable String uuid){
        HabitatDTO dto = service.findByUuid(uuid);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<HabitatDTO> create(@RequestBody HabitatDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("{uuid}")
    public HabitatDTO update(@PathVariable String uuid, @RequestBody HabitatDTO dto){
        return service.update(uuid, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
