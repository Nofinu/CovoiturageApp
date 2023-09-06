package com.example.CarRideService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserObjet {
    private int id_user_driver;

    public int getId_user_driver() {
        return id_user_driver;
    }

    public void setId_user_driver(int id_user_driver) {
        this.id_user_driver = id_user_driver;
    }
}
