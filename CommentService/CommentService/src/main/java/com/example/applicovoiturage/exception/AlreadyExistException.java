package com.example.applicovoiturage.exception;

public class AlreadyExistException extends Exception{
    public AlreadyExistException() {
        super("comment already exist");
    }
}
