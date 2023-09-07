package com.example.CarRideService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarRideDtoRequest {
    private int id_user_driver;
    private String start_point;
    private String end_point;
    private int seatMax;
    private float price;

}
