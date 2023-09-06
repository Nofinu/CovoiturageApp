package com.example.CarRideService.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class CarRide {

    private int id_carRide;
    private String depart_point;
    private String end_point;
    private String seat;
    private String price;
    private int id_user_driver;

    public int getId_carRide() {
        return id_carRide;
    }

    public void setId_carRide(int id_carRide) {
        this.id_carRide = id_carRide;
    }

    public String getDepart_point() {
        return depart_point;
    }

    public void setDepart_point(String depart_point) {
        this.depart_point = depart_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId_user_driver() {
        return id_user_driver;
    }

    public void setId_user_driver(int id_user_driver) {
        this.id_user_driver = id_user_driver;
    }
}
