package com.example.CarRideService.utils;

import com.example.CarRideService.dto.CarRideDto.CarRideDtoRequest;
import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.entity.CarRide;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    //convert entity to dto
    public CarRideDtoResponse mapToDto(CarRide carRide) {

        ModelMapper mapper = new ModelMapper();
        CarRideDtoResponse carRideDtoResponse = mapper.map(carRide, CarRideDtoResponse.class);

        return carRideDtoResponse;

    }

    //convert dto to entity
    public CarRide mapToEntity(CarRideDtoRequest carRideDtoRequest) {

        ModelMapper mapper = new ModelMapper();
        CarRide carRide = mapper.map(carRideDtoRequest, CarRide.class);

        return carRide;
    }
}
