package com.example.CarRideService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carRide;
    private int id_user_driver;
    private String start_point;
    private String end_point;
    private LocalDate startDate;
    private int seatMax;
    private int seatAvailable;
    private float price;


    public CarRide(String start_point, String end_point, int seatMax, float price, int id_user_driver,LocalDate startDate) {
        this.start_point = start_point;
        this.end_point = end_point;
        this.seatMax = seatMax;
        this.seatAvailable = seatMax;
        this.price = price;
        this.id_user_driver = id_user_driver;
        this.startDate = startDate;
    }
}
