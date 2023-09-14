package com.example.CarRideService.service.impl;

import com.example.CarRideService.dto.BookingDto.BookingDtoRequest;
import com.example.CarRideService.dto.BookingDto.BookingDtoResponse;
import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.entity.Booking;
import com.example.CarRideService.entity.CarRide;
import com.example.CarRideService.exception.AlreadyExistException;
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
        CarRide carRide = carRideService.getCarRideByIdEntity(bookingDtoRequest.getIdcarRide());
        Booking bookingFind = bookingRepository.findBookingById_userAndCarRide(bookingDtoRequest.getIduser(),carRide);
        if(bookingFind == null){
            if (carRide.getSeatAvailable() > 0) {
                carRide.setSeatAvailable(carRide.getSeatAvailable() - 1);
                Booking booking = new Booking(bookingDtoRequest.getIduser(), carRide);
                carRideRepository.save(carRide);
                Booking bookingRegister = bookingRepository.save(booking);
                return new BookingDtoResponse(booking.getId(), bookingRegister.getIduser(), carRideService.getCarRideById(bookingRegister.getCarRide().getId_carRide()));
            } else {
                throw new SeatNegativeNumberException();
            }
        }
      throw new AlreadyExistException();
    }

    @Override
    public boolean unBookASeat(BookingDtoRequest bookingDtoRequest) {
        CarRide carRide = carRideService.getCarRideByIdEntity(bookingDtoRequest.getIdcarRide());
        Booking booking = bookingRepository.findBookingById_userAndCarRide(bookingDtoRequest.getIduser(), carRide);
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

    @Override
    public BookingDtoResponse findBookingByIdUserAndIdCarRide(int idUser, int idCarRide) {
        CarRide carRide = carRideService.getCarRideByIdEntity(idCarRide);
        Booking booking = bookingRepository.findBookingById_userAndCarRide(idUser,carRide);
        if(booking != null){
            return new BookingDtoResponse(booking.getId(),booking.getIduser(),carRideService.getCarRideById(carRide.getId_carRide()));
        }
        return null;
    }
}
