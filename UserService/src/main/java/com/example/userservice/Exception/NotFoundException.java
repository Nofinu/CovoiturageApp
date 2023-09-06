package com.example.userservice.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("User Not Found");
    }
}
