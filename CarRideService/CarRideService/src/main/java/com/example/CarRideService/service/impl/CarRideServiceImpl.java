package com.example.CarRideService.service.impl;

import com.example.CarRideService.dto.CarRideDto.CarRideDtoRequest;
import com.example.CarRideService.dto.CarRideDto.CarRideDtoResponse;
import com.example.CarRideService.entity.CarRide;
import com.example.CarRideService.exception.NotFoundException;
import com.example.CarRideService.exception.SeatNegativeNumberException;
import com.example.CarRideService.repository.CarRideRepository;
import com.example.CarRideService.service.CarRideService;
import com.example.CarRideService.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarRideServiceImpl implements CarRideService {
    @Autowired
    private CarRideRepository carRideRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public CarRideDtoResponse createCarRide(CarRideDtoRequest carRideDtoRequest) {
        CarRide carRide = new CarRide(carRideDtoRequest.getStart_point(),carRideDtoRequest.getEnd_point(),carRideDtoRequest.getSeatMax(),carRideDtoRequest.getPrice(),carRideDtoRequest.getId_user_driver(), LocalDate.parse(carRideDtoRequest.getStartDateStr()));
        CarRide newCarRide = carRideRepository.save(carRide);
        return mapper.mapToDto(newCarRide);
    }

    @Override
    public CarRideDtoResponse updateCarRide(int idCarRide, CarRideDtoRequest carRideDtoRequest) throws SeatNegativeNumberException {
       CarRide carRideFind = getCarRideByIdEntity(idCarRide);
       carRideFind.setStart_point(carRideDtoRequest.getStart_point());
       carRideFind.setEnd_point(carRideDtoRequest.getEnd_point());
       carRideFind.setSeatAvailable(carRideFind.getSeatAvailable()-(carRideFind.getSeatMax()-carRideDtoRequest.getSeatMax()));
       carRideFind.setStartDate(LocalDate.parse(carRideDtoRequest.getStartDateStr()));
       if(carRideFind.getSeatAvailable() < 0){
           throw new SeatNegativeNumberException();
       }
       carRideFind.setSeatMax(carRideDtoRequest.getSeatMax());
       carRideFind.setPrice(carRideDtoRequest.getPrice());
       CarRide updateCarRide = carRideRepository.save(carRideFind);
       return mapper.mapToDto(updateCarRide);
    }

    @Override
    public CarRide getCarRideByIdEntity(int idCarRide){
        Optional<CarRide> carRides = carRideRepository.findById(idCarRide);
        if (carRides.isPresent()){
            return carRides.get();
        }
        throw new NotFoundException();
    }

    @Override
    public List<CarRideDtoResponse> findAllwithoutUserId(int idUser) {
        List<CarRideDtoResponse> carRideDtoResponses = new ArrayList<>();
        carRideRepository.findAllWithoutIdUserDriver(idUser).forEach(c ->{
            carRideDtoResponses.add(new CarRideDtoResponse(c.getId_carRide(),c.getId_user_driver(),c.getStart_point(),c.getEnd_point(),c.getSeatMax(),c.getSeatAvailable(),c.getStartDate(),c.getPrice()));
        });
        return carRideDtoResponses;
    }

    @Override
    public List<CarRideDtoResponse> findAllCarRideByUserId(int idUser) {
        List<CarRideDtoResponse> carRideDtoResponses = new ArrayList<>();
        carRideRepository.findAllCarRideByUserId(idUser).forEach(c ->{
            carRideDtoResponses.add(new CarRideDtoResponse(c.getId_carRide(),c.getId_user_driver(),c.getStart_point(),c.getEnd_point(),c.getSeatMax(),c.getSeatAvailable(),c.getStartDate(),c.getPrice()));
        });
        return carRideDtoResponses;
    }

    @Override
    public boolean deleteCarRide(int idCarRide) {
        try {
            CarRide carRide = getCarRideByIdEntity(idCarRide);
            carRideRepository.delete(carRide);
            return true;
        }catch (Exception ex){
            throw  new RuntimeException();
        }
    }

    @Override
    public CarRideDtoResponse getCarRideById(int idCarRide) {
       Optional<CarRide>carRides =carRideRepository.findById(idCarRide);
       if(carRides.isPresent()){
           return mapper.mapToDto(carRides.get());
       }
       throw new NotFoundException();
    }

    @Override
    public List<CarRideDtoResponse> getAllPCarRide() {
        List<CarRide>carRides = (List<CarRide>) carRideRepository.findAll();
        List<CarRideDtoResponse>carRideDtoResponses=new ArrayList<>();
        for (CarRide cr: carRides ){
            CarRideDtoResponse carRideDtoResponse= mapper.mapToDto(cr);
            carRideDtoResponses.add(carRideDtoResponse);
        }
        return carRideDtoResponses;
    }
}
