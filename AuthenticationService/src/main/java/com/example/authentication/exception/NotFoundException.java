package com.example.authentication.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Not Found");
    }
}
