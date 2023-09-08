package com.example.gatewayservice.controller.logedController;

import com.example.gatewayservice.dto.CarRIdeDto.CarRideDtoRequest;
import com.example.gatewayservice.dto.CarRIdeDto.CarRideDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/car_ride")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class CarRideEditController {

    private ObjectMapper om;

    public CarRideEditController() {
        this.om = new ObjectMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<CarRideDtoResponse> createCarRide (@RequestBody CarRideDtoRequest carRideDtoRequest) throws JsonProcessingException {
        RestClient<CarRideDtoResponse> carRIdeRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/create");
        CarRideDtoResponse CarRideDtoResponses = carRIdeRestCLient.postRequest(om.writeValueAsString(carRideDtoRequest),CarRideDtoResponse.class);
        return new ResponseEntity<>(CarRideDtoResponses, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CarRideDtoResponse> updateCarRide (@RequestBody CarRideDtoRequest carRideDtoRequest,@PathVariable int id) throws JsonProcessingException {
        RestClient<CarRideDtoResponse> carRIdeRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/update/"+id);
        CarRideDtoResponse CarRideDtoResponses = carRIdeRestCLient.postRequest(om.writeValueAsString(carRideDtoRequest),CarRideDtoResponse.class);
        return new ResponseEntity<>(CarRideDtoResponses, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarRide (@PathVariable int id) throws JsonProcessingException {
        RestClient<String> carRIdeRestCLient = new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/car_ride/delete/"+id);
        String stringResponse = carRIdeRestCLient.getRequest(String.class);
        return new ResponseEntity<>(stringResponse, HttpStatus.OK);
    }
}
