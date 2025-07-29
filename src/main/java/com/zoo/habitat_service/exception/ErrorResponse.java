package com.zoo.habitat_service.exception;

import java.time.LocalDateTime;

/**
 * Classe DTO utilizzata per rappresentare la struttura della risposta
 * restituita in caso di errore. Contiene timestamp, codice HTTP e messaggio
 * descrittivo dell'eccezione avvenuta.
 *
 * Viene usata dal GlobalExceptionHandler per restituire errori in formato JSON
 * comprensibile al client.
 */


public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;

    public ErrorResponse(LocalDateTime timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    // Getters e Setters
}
