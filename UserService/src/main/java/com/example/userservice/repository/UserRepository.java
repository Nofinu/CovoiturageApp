package com.example.userservice.repository;

import com.example.userservice.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserApp,Integer> {

    UserApp findByEmail (String email);
}
