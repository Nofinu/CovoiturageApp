package com.example.CarRideService.controller;

import com.example.CarRideService.dto.BookingDto.BookingDtoRequest;
import com.example.CarRideService.dto.BookingDto.BookingDtoResponse;
import com.example.CarRideService.exception.SeatNegativeNumberException;
import com.example.CarRideService.service.BookinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    @Autowired
    private BookinService bookinService;

    @PostMapping("/book_car_ride")
    public ResponseEntity<BookingDtoResponse> bookingCarRide (@RequestBody BookingDtoRequest bookingDtoRequest) throws SeatNegativeNumberException {
        return new ResponseEntity<>(bookinService.bookASeat(bookingDtoRequest), HttpStatus.OK) ;
    }

    @PostMapping("/unbook_car_ride")
    public ResponseEntity<String > unBookingCarRide (@RequestBody BookingDtoRequest bookingDtoRequest) throws SeatNegativeNumberException {
        if (bookinService.unBookASeat(bookingDtoRequest)){
            return new ResponseEntity<>("Booking cancel", HttpStatus.OK) ;
        }
        else{
            return new ResponseEntity<>("Error during booking cancel", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<BookingDtoResponse>> findAllBookingByUserId (@PathVariable int id){
        return new ResponseEntity<>(bookinService.findAllBookingByUserId(id),HttpStatus.OK);
    }

    @GetMapping("/car_ride/{id}")
    public ResponseEntity<List<BookingDtoResponse>> findAllBookingByCarRideId (@PathVariable int id){
        return new ResponseEntity<>(bookinService.findAllBookingByCarRideId(id),HttpStatus.OK);
    }

    @GetMapping("/isbooked/{iduser}/{idcarride}")
    public ResponseEntity<BookingDtoResponse> findByUserIdAndCarRideId (@PathVariable int iduser,@PathVariable int idcarride){
        return new ResponseEntity<>(bookinService.findBookingByIdUserAndIdCarRide(iduser,idcarride),HttpStatus.OK);
    }
}
