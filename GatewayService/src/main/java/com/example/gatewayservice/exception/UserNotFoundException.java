package com.example.gatewayservice.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User Not found");
    }
}
