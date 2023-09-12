package com.example.userservice.service;

import com.example.userservice.dto.UserDtoResponse;
import com.example.userservice.entity.UserApp;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDtoResponse findById (int id);

    UserDtoResponse findByEmail (String email);
}
