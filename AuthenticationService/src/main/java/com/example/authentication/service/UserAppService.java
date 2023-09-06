package com.example.authentication.service;

import com.example.authentication.dto.RegisterRequestDto;
import com.example.authentication.dto.UserDto;
import com.example.authentication.entity.UserApp;
import com.example.authentication.exception.UserAlreadyExistException;
import com.example.authentication.repository.UserAppRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserAppService {

    private final UserAppRepository userRepository;

    public UserAppService(UserAppRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserApp enregistrerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserApp> userAppOptional = userRepository.findByEmail(registerRequestDto.getEmail());
        if(userAppOptional.isEmpty()){
            UserApp user = new UserApp(registerRequestDto.getEmail(), registerRequestDto.getLastname(), registerRequestDto.getFirstname(), registerRequestDto.getPhone(), registerRequestDto.getPassword(),0);
            return userRepository.save(user);
        }
        throw new UserAlreadyExistException();
    }


}
