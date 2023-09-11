package com.example.gatewayservice.controller.logedController;

import com.example.gatewayservice.dto.BookingDto.BookingDtoRequest;
import com.example.gatewayservice.dto.BookingDto.BookingDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;


@RestController()
@RequestMapping("api/booking")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class BookingController {

    private ObjectMapper om;

    public BookingController() {
        this.om = new ObjectMapper();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<BookingDtoResponse>> getAllBookingByUserId (@PathVariable int id){
        RestClient<BookingDtoResponse[]> bookingRestClient =  new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/booking/user/"+id);
        List<BookingDtoResponse> bookingDtoResponses = Arrays.stream(bookingRestClient.getRequest(BookingDtoResponse[].class)).toList();
        return new ResponseEntity<>(bookingDtoResponses, HttpStatus.OK);
    }

    @GetMapping("/car_ride/{id}")
    public ResponseEntity<List<BookingDtoResponse>> getAllBookingByCarRideId (@PathVariable int id){
        RestClient<BookingDtoResponse[]> bookingRestClient =  new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/booking/car_ride/"+id);
        List<BookingDtoResponse> bookingDtoResponses = Arrays.stream(bookingRestClient.getRequest(BookingDtoResponse[].class)).toList();
        return new ResponseEntity<>(bookingDtoResponses, HttpStatus.OK);
    }

    @PostMapping("/book_car_ride")
    public ResponseEntity<BookingDtoResponse> setBooking (@RequestBody BookingDtoRequest bookingDtoRequest) throws JsonProcessingException {
        RestClient<BookingDtoResponse> bookingRestClient =  new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/booking/book_car_ride");
        BookingDtoResponse bookingDtoResponse = bookingRestClient.postRequest(om.writeValueAsString(bookingRestClient), BookingDtoResponse.class);
        return new ResponseEntity<>(bookingDtoResponse,HttpStatus.OK);
    }

    @PostMapping("/unbook_car_ride")
    public ResponseEntity<String> unsetBooking (@RequestBody BookingDtoRequest bookingDtoRequest) throws JsonProcessingException {
        RestClient<String> bookingRestClient =  new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/booking/unbook_car_ride");
        String stringResponse = bookingRestClient.postRequest(om.writeValueAsString(bookingRestClient), String.class);
        return new ResponseEntity<>(stringResponse,HttpStatus.OK);
    }
}