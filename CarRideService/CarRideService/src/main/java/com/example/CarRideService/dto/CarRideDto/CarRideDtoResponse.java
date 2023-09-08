package com.example.CarRideService.dto.CarRideDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarRideDtoResponse {
    private int id_carRide;
    private int id_user_driver;
    private String depart_point;
    private String end_point;
    private int seatMax;
    private int seatAvailable;
    private float price;

}
