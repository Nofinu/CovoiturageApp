package com.example.gatewayservice.dto.CarRIdeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRideDtoResponse {
    private int id_carRide;
    private int id_user_driver;
    private String start_point;
    private String end_point;
    private int seatMax;
    private int seatAvailable;
    private LocalDate startDate;
    private float price;
}
