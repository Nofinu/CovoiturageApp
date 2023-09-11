package com.example.CarRideService.dto.CarRideDto;

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
    private String startDateStr;
    private int seatMax;
    private float price;

}
