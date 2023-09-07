package com.example.CarRideService.exception;

public class SeatNegativeNumberException extends Exception{
    public SeatNegativeNumberException() {
        super("Seat cant be a negative value");
    }
}
