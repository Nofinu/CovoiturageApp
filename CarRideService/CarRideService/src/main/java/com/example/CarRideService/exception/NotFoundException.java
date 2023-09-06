package com.example.CarRideService.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Comment not found");
    }
}
