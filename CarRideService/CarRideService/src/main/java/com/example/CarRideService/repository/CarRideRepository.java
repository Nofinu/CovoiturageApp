package com.example.CarRideService.repository;

import com.example.CarRideService.entity.CarRide;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRideRepository extends CrudRepository<CarRide,Integer> {
    @Query("select c from CarRide as c where c.id_user_driver != ?1")
    List<CarRide> findAllWithoutIdUserDriver (int id);

    @Query("select c from CarRide as c where c.id_user_driver = ?1")
    List<CarRide> findAllCarRideByUserId (int id);
}
