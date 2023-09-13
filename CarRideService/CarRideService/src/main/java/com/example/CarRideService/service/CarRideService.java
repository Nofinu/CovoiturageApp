package com.example.CarRideService.service;


import com.example.CarRideService.dto.CarRideDto.CarRideDtoRequest;
import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.entity.CarRide;
import com.example.CarRideService.exception.SeatNegativeNumberException;

import java.util.List;

public interface CarRideService {
    CarRideDtoResponse createCarRide(CarRideDtoRequest carRideDtoRequest) ;
    CarRideDtoResponse updateCarRide(int idCarRide, CarRideDtoRequest carRideDtoRequest) throws SeatNegativeNumberException;
    boolean deleteCarRide(int idCarRide) ;
    CarRideDtoResponse getCarRideById(int idCarRide) ;
   List<CarRideDtoResponse> getAllPCarRide() ;
    CarRide getCarRideByIdEntity(int idCarRide);
    List<CarRideDtoResponse> findAllwithoutUserId(int idUser);
    List<CarRideDtoResponse> findAllCarRideByUserId(int idUser);
}
