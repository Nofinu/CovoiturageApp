package com.example.CarRideService.repository;

import com.example.CarRideService.entity.Booking;
import com.example.CarRideService.entity.CarRide;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer> {
    @Query("SELECT b from Booking as b where b.id_User = ?1 and b.carRide = ?2 ")
    Booking findBookingByuserIdAndCarRide (int id, CarRide carRide);

    List<Booking> findBookingByCarRide (CarRide carRide);

    List<Booking> findBookingById_User (int userId);
}
