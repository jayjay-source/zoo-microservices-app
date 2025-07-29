package com.zoo.animale_service.exception;

/**
 * Eccezione custom che rappresenta un errore di risorsa non trovata (404).
 * Viene lanciata nei service o nei controller quando un'entità con uno specifico ID
 * non è presente nel database.
 *
 * Viene gestita centralmente dal GlobalExceptionHandler.
 */


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
