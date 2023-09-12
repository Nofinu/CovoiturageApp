package com.example.CarRideService.dto.BookingDto;

import com.example.CarRideService.entity.CarRide;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoRequest {
    private int iduser;
    private int idcarRide;
}
