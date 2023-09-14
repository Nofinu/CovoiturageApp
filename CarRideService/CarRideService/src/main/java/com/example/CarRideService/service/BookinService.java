package com.example.CarRideService.service;

import com.example.CarRideService.dto.BookingDto.BookingDtoRequest;
import com.example.CarRideService.dto.BookingDto.BookingDtoResponse;
import com.example.CarRideService.exception.SeatNegativeNumberException;

import java.awt.print.Book;
import java.util.List;

public interface BookinService {

    BookingDtoResponse bookASeat (BookingDtoRequest bookingDtoRequest) throws SeatNegativeNumberException;
    boolean unBookASeat (BookingDtoRequest bookingDtoRequest);
    List<BookingDtoResponse> findAllBookingByCarRideId (int id);
    List<BookingDtoResponse> findAllBookingByUserId(int id);
    BookingDtoResponse findBookingByIdUserAndIdCarRide(int idUser, int idCarRide);


}
