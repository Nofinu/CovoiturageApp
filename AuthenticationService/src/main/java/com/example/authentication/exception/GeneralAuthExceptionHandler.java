package com.example.authentication.exception;

import com.example.authentication.dto.LoginResponseDto;
import com.example.authentication.dto.RegisterResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralAuthExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<RegisterResponseDto> UserAlreadyExistHandler (UserAlreadyExistException ex){
        RegisterResponseDto registerResponseDto = new RegisterResponseDto(-1,"email","lastname","firstname","phone",0);
        return new ResponseEntity<>(registerResponseDto, HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<LoginResponseDto> notFoundExceptionHandler (NotFoundException ex){
        LoginResponseDto loginResponseDto = new LoginResponseDto("NotFound");
        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }
}
