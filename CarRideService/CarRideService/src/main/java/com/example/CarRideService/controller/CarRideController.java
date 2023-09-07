package com.example.CarRideService.controller;

import com.example.CarRideService.dto.CarRideDto.CarRideDtoRequest;
import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.exception.SeatNegativeNumberException;
import com.example.CarRideService.service.CarRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car_ride")
public class CarRideController {
    @Autowired
    private CarRideService carRideService;

    @PostMapping("/create")
    public ResponseEntity<CarRideDtoResponse> createCarRide(@RequestBody CarRideDtoRequest carRideDtoRequest){

        System.out.println(carRideDtoRequest);
        return new ResponseEntity<>(carRideService.createCarRide(carRideDtoRequest), HttpStatus.CREATED);
    }
    @PostMapping("/update/{id_carRide}")
    public ResponseEntity<CarRideDtoResponse> updateCarRide(@PathVariable(value = "id_carRide")int id_carRide,
                                                             @RequestBody CarRideDtoRequest carRideDtoRequest) throws SeatNegativeNumberException {
        return new ResponseEntity<>(carRideService.updateCarRide(id_carRide,carRideDtoRequest),HttpStatus.OK);

    }
    @GetMapping("/delete/{id_carRide}")
    public ResponseEntity<String> deleteCarRide(@PathVariable(value = "id_carRide")int id_carRide){
        if(carRideService.deleteCarRide(id_carRide)){
            return new ResponseEntity<>("CarRide delete ",HttpStatus.OK);
        }
        return new ResponseEntity<>("Error durring deletion",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id_carRide}")
    public ResponseEntity<CarRideDtoResponse> getCarRideById(@PathVariable(value = "id_carRide")int id_carRide){
        return new ResponseEntity<>(carRideService.getCarRideById(id_carRide),HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<CarRideDtoResponse>> getAllPCarRide(){
        return new ResponseEntity<>(carRideService.getAllPCarRide(), HttpStatus.OK);
    }
}
