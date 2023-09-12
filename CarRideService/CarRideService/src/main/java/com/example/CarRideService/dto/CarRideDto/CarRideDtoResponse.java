package com.example.CarRideService.dto.CarRideDto;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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
