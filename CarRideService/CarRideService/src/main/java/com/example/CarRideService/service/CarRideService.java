package com.example.CarRideService.service;


import com.example.CarRideService.dto.CarRideDtoRequest;
import com.example.CarRideService.dto.CarRideDtoResponse;
import com.example.CarRideService.exception.SeatNegativeNumberException;

import java.util.List;

public interface CarRideService {

    CarRideDtoResponse createCarRide(CarRideDtoRequest carRideDtoRequest) ;

   CarRideDtoResponse updateCarRide(int idCarRide, CarRideDtoRequest carRideDtoRequest) throws SeatNegativeNumberException;


   boolean deleteCarRide(int idCarRide) ;

     CarRideDtoResponse getCarRideById(int idCarRide) ;

    List<CarRideDtoResponse> getAllPCarRide() ;
}
