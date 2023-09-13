package com.example.gatewayservice.controller;

import com.example.gatewayservice.dto.CarRIdeDto.CarRideDtoResponse;
import com.example.gatewayservice.dto.CommentDto.CommentDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/car_ride")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CarRIdeController {

    @GetMapping("")
    public ResponseEntity<List<CarRideDtoResponse>> getAllCarRide (){
        RestClient<CarRideDtoResponse[]> carRideRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride");
        List<CarRideDtoResponse> carRideDtoResponses = Arrays.stream(carRideRestCLient.getRequest(CarRideDtoResponse[].class)).toList();
        return new ResponseEntity<>(carRideDtoResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRideDtoResponse> getCarRideById (@PathVariable int id){
        RestClient<CarRideDtoResponse> carRideRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/"+id);
        CarRideDtoResponse carRideDtoResponse = carRideRestCLient.getRequest(CarRideDtoResponse.class);
        return new ResponseEntity<>(carRideDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/car_ride_without/{idUser}")
    public ResponseEntity<List<CarRideDtoResponse>> getAllCarRideWithoutUser (@PathVariable int idUser){
        RestClient<CarRideDtoResponse[]> carRideRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/car_ride_without/"+idUser);
        List<CarRideDtoResponse> carRideDtoResponses = Arrays.stream(carRideRestCLient.getRequest(CarRideDtoResponse[].class)).toList();
        return new ResponseEntity<>(carRideDtoResponses,HttpStatus.OK);
    }
}
