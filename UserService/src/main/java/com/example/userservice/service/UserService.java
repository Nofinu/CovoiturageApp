package com.example.userservice.service;

import com.example.userservice.entity.UserApp;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserApp findById (int id);
}
