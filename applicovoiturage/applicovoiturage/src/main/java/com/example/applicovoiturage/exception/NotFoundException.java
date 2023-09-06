package com.example.applicovoiturage.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Comment not found");
    }
}
