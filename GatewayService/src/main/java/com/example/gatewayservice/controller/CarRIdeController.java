package com.example.gatewayservice.controller;

import com.example.gatewayservice.dto.CarRIdeDto.CarRideDtoResponse;
import com.example.gatewayservice.dto.CommentDto.CommentDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/car_ride")
public class CarRIdeController {

    @GetMapping("")
    public ResponseEntity<List<CarRideDtoResponse>> getAllCarRide (){
        RestClient<CarRideDtoResponse[]> carRIdeRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride");
        List<CarRideDtoResponse> CarRideDtoResponses = Arrays.stream(carRIdeRestCLient.getRequest(CarRideDtoResponse[].class)).toList();
        return new ResponseEntity<>(CarRideDtoResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRideDtoResponse> getCarRideById (@PathVariable int id){
        RestClient<CarRideDtoResponse> carRIdeRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/"+id);
        CarRideDtoResponse CarRideDtoResponse = carRIdeRestCLient.getRequest(CarRideDtoResponse.class);
        return new ResponseEntity<>(CarRideDtoResponse, HttpStatus.OK);
    }
}
