package com.zoo.animale_service.controller;

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

import com.zoo.animale_service.dto.AnimaleDTO;
import com.zoo.animale_service.service.AnimaleService;

import lombok.RequiredArgsConstructor;

@RestController //singleton bean
@RequestMapping("/api/animali")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") //CORS
public class Controller {



    /**
     * Controller REST che espone le API per la gestione dell'entità associata.
     * Gestisce le richieste HTTP in ingresso e delega la logica al service.
     * Annotato con @RestController per indicare a Spring che si tratta di un controller RESTful.
     */

     /**
         * REST Controller - API REST:
         * 
         * Un controller annotato con @RestController espone un'API RESTful.
         * 
         * Cos'è un'API REST:
         * - È un'interfaccia che consente a client (come browser o applicazioni mobile) di comunicare con 
         * il backend tramite HTTP.
         * - Segue i principi REST (Representational State Transfer), usando metodi HTTP standard:
         *   - GET: per leggere dati
         *   - POST: per creare nuove risorse
         *   - PUT/PATCH: per aggiornare risorse esistenti
         *   - DELETE: per rimuovere risorse
         * 
         * Il controller:
         * - Riceve le richieste HTTP.
         * - Chiama i metodi del Service per elaborare i dati.
         * - Restituisce risposte JSON al client.
         * 
         * In Spring, @RestController combina @Controller e @ResponseBody, rendendo ogni metodo pronto a 
         * restituire dati serializzati (es. JSON).
         */


    private final AnimaleService service;

    @GetMapping
    public List<AnimaleDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimaleDTO> getById(@PathVariable Long id){
        /**
         * L'annotazione @PathVariable viene utilizzata per estrarre valori dinamici
         * dall'URL della richiesta e passarli come argomenti al metodo del controller.
         * È utile per accedere a risorse identificate da un parametro nel percorso.
         */
        AnimaleDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    /**
     * ResponseEntity rappresenta una risposta HTTP completa, che consente di
     * personalizzare sia il corpo della risposta che lo status code.
     * È utile per restituire messaggi dettagliati al client.
     */
    @PostMapping
    public ResponseEntity<AnimaleDTO> create(@RequestBody AnimaleDTO dto){
        /**
         * L'annotazione @RequestBody consente di mappare il corpo di una richiesta HTTP
         * (generalmente in formato JSON) su un oggetto Java.
         * È comunemente usata per ricevere dati da creare o aggiornare.
         */
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
        /**
         * Restituisce una ResponseEntity con status 201 (HttpStatus.CREATED)
         * e il corpo contenente il risultato dell’operazione di creazione
         * eseguita dal service. Indica la creazione riuscita di una nuova risorsa.
         */
    }
    @PutMapping("/{id}")
    public AnimaleDTO update(@PathVariable Long id, @RequestBody AnimaleDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
