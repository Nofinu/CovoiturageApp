package com.example.CarRideService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarRideDtoRequest {
    private int id_user_driver;
    private String depart_point;
    private String end_point;
    private String seat;
    private String price;

    public int getId_user_driver() {
        return id_user_driver;
    }

    public void setId_user_driver(int id_user_driver) {
        this.id_user_driver = id_user_driver;
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
}
