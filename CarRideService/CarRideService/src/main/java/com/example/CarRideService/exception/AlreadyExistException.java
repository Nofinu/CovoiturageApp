package com.example.CarRideService.exception;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException() {
        super("Booking Already Exist");
    }
}
