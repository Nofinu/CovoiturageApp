package com.example.userservice.service.impl;

import com.example.userservice.Exception.NotFoundException;
import com.example.userservice.entity.UserApp;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserApp findById(int id) {
        Optional<UserApp> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new NotFoundException();
    }
}
