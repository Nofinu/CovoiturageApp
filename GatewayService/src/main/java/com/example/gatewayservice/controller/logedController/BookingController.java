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

    @GetMapping("/book_car_ride/{userId}/{carRideId}")
    public ResponseEntity<BookingDtoResponse> setBooking (@PathVariable int userId, @PathVariable int carRideId) throws JsonProcessingException {
        RestClient<BookingDtoResponse> bookingRestClient =  new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/booking/book_car_ride");
        BookingDtoRequest bookingDtoRequest = new BookingDtoRequest(userId,carRideId);
        BookingDtoResponse bookingDtoResponse = bookingRestClient.postRequest(om.writeValueAsString(bookingDtoRequest), BookingDtoResponse.class);
        return new ResponseEntity<>(bookingDtoResponse,HttpStatus.OK);
    }

    @GetMapping("/unbook_car_ride/{userId}/{carRideId}")
    public ResponseEntity<String> unsetBooking (@PathVariable int userId, @PathVariable int carRideId) throws JsonProcessingException {
        RestClient<String> bookingRestClient =  new RestClient<>("http://localhost:"+ PortApi.portCarRide +"/api/booking/unbook_car_ride");
        BookingDtoRequest bookingDtoRequest = new BookingDtoRequest(userId,carRideId);
        String stringResponse = bookingRestClient.postRequest(om.writeValueAsString(bookingDtoRequest), String.class);
        return new ResponseEntity<>(stringResponse,HttpStatus.OK);
    }
}
