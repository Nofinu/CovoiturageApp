package com.example.gatewayservice.dto.BookingDto;

import com.example.gatewayservice.dto.CarRIdeDto.CarRideDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoResponse {
    private int id_Booking;
    private int iduser;
    private CarRideDtoResponse carRide;
}
