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

}
