package com.example.userservice.service.impl;

import com.example.userservice.Exception.NotFoundException;
import com.example.userservice.dto.UserDtoResponse;
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
    public UserDtoResponse findById(int id) {
        Optional<UserApp> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            UserApp userApp = userOptional.get();
            return new UserDtoResponse(userApp.getId_user(),userApp.getEmail(),userApp.getLastname(),userApp.getFirstname(),userApp.getPhone(),userApp.getRole().ordinal());
        }
        throw new NotFoundException();
    }

    @Override
    public UserDtoResponse findByEmail(String email) {
        UserApp userApp = userRepository.findByEmail(email);
        if(userApp != null){
            return new UserDtoResponse(userApp.getId_user(),userApp.getEmail(), userApp.getLastname(), userApp.getFirstname(), userApp.getPhone(), userApp.getRole().ordinal());
        }
        return null;
    }
}
