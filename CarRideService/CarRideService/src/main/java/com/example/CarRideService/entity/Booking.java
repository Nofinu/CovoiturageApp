package com.example.CarRideService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int iduser;
    @ManyToOne
    private CarRide carRide;

    public Booking(int id_User, CarRide carRide) {
        this.iduser = id_User;
        this.carRide = carRide;
    }
}
