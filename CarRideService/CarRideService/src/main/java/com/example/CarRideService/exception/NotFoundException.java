package com.example.CarRideService.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("CarRide not found");
    }
}
