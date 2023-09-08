package com.example.gatewayservice.dto.BookingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoRequest {
    private int id_User;
    private int id_carRide;
}
