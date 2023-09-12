package com.example.gatewayservice.exception;

public class AlreadyExistException extends Exception{
    public AlreadyExistException(String entity) {
        super(entity+"Already Exist");
    }
}
