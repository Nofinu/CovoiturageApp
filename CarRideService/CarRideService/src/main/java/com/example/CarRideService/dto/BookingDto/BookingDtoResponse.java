package com.example.CarRideService.dto.BookingDto;

import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.entity.CarRide;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoResponse {
    private int id_Booking;
    private int iduser;
    private CarRideDtoResponse carRide;
}
