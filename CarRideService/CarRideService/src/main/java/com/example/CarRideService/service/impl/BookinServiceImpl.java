package com.example.CarRideService.service.impl;

import com.example.CarRideService.dto.BookingDto.BookingDtoRequest;
import com.example.CarRideService.dto.BookingDto.BookingDtoResponse;
import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.entity.Booking;
import com.example.CarRideService.entity.CarRide;
import com.example.CarRideService.exception.NotFoundException;
import com.example.CarRideService.exception.SeatNegativeNumberException;
import com.example.CarRideService.repository.BookingRepository;
import com.example.CarRideService.repository.CarRideRepository;
import com.example.CarRideService.service.BookinService;
import com.example.CarRideService.service.CarRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookinServiceImpl implements BookinService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRideRepository carRideRepository;

    @Autowired
    private CarRideService carRideService;

    @Override
    public BookingDtoResponse bookASeat(BookingDtoRequest bookingDtoRequest) throws SeatNegativeNumberException {
        CarRide carRide = carRideService.getCarRideByIdEntity(bookingDtoRequest.getId_carRide());
        if (carRide.getSeatAvailable() > 0) {
            carRide.setSeatAvailable(carRide.getSeatAvailable() - 1);
            Booking booking = new Booking(bookingDtoRequest.getId_User(), carRide);
            carRideRepository.save(carRide);
            Booking bookingRegister = bookingRepository.save(booking);
            return new BookingDtoResponse(booking.getId(), bookingRegister.getIduser(), carRideService.getCarRideById(bookingRegister.getCarRide().getId_carRide()));
        } else {
            throw new SeatNegativeNumberException();
        }
    }

    @Override
    public boolean unBookASeat(BookingDtoRequest bookingDtoRequest) {
        CarRide carRide = carRideService.getCarRideByIdEntity(bookingDtoRequest.getId_carRide());
        Booking booking = bookingRepository.findBookingById_userAndCarRide(bookingDtoRequest.getId_User(), carRide);
        if (booking != null) {
            bookingRepository.delete(booking);
            if (carRide.getSeatAvailable() < carRide.getSeatMax()) {
                carRide.setSeatAvailable(carRide.getSeatAvailable() + 1);
                carRideRepository.save(carRide);
            }
            return true;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public List<BookingDtoResponse> findAllBookingByCarRideId(int id) {
        CarRide carRide = carRideService.getCarRideByIdEntity(id);
        List<BookingDtoResponse> bookingDtoResponses = new ArrayList<>();
        bookingRepository.findBookingByCarRide(carRide).forEach(b -> {
            bookingDtoResponses.add(new BookingDtoResponse(b.getId(),b.getIduser(),carRideService.getCarRideById(b.getCarRide().getId_carRide())));
        });
        return bookingDtoResponses;
    }

    @Override
    public List<BookingDtoResponse> findAllBookingByUserId(int id) {
        List<BookingDtoResponse> bookingDtoResponses = new ArrayList<>();
        bookingRepository.findBookingByIduser(id).forEach(b -> {
            bookingDtoResponses.add(new BookingDtoResponse(b.getId(),b.getIduser(),carRideService.getCarRideById(b.getCarRide().getId_carRide())));
        });
        return bookingDtoResponses;
    }
}
