package com.example.gatewayservice.controller;

import com.example.gatewayservice.dto.LoginDtoRequest;
import com.example.gatewayservice.dto.LoginDtoResponse;
import com.example.gatewayservice.dto.RegisterDtoRequest;
import com.example.gatewayservice.dto.RegisterDtoResponse;
import com.example.gatewayservice.exception.UserAlreadyExistException;
import com.example.gatewayservice.exception.UserNotFoundException;
import com.example.gatewayservice.tools.RestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/auth/")
public class AuthentificationController {

    private ObjectMapper om;

    public AuthentificationController() {
        this.om = new ObjectMapper();
    }

    @PostMapping("register")
    public ResponseEntity<LoginDtoResponse> register (@RequestBody RegisterDtoRequest registerDtoRequest) throws JsonProcessingException, UserAlreadyExistException, UserNotFoundException {
        RestClient<RegisterDtoResponse> registerRestClient = new RestClient<>("http://localhost:8084/api/auth/register");
        RegisterDtoResponse registerDtoResponse = registerRestClient.postRequest(om.writeValueAsString(registerDtoRequest), RegisterDtoResponse.class);
        if(registerDtoResponse.getId() != -1){
            LoginDtoRequest loginDtoRequest = new LoginDtoRequest(registerDtoRequest.getEmail(),registerDtoRequest.getPassword());
            return loginMethod(loginDtoRequest);
        }
        throw new UserAlreadyExistException();
    }

    @PostMapping("login")
    public ResponseEntity<LoginDtoResponse> login (@RequestBody LoginDtoRequest loginDtoRequest) throws JsonProcessingException, UserNotFoundException {
        return loginMethod(loginDtoRequest);
    }

    private ResponseEntity<LoginDtoResponse> loginMethod (LoginDtoRequest loginDtoRequest) throws JsonProcessingException, UserNotFoundException {
        RestClient<LoginDtoResponse> loginRestClient = new RestClient<>("http://localhost:8084/api/auth/login");
        LoginDtoResponse loginDtoResponse = loginRestClient.postRequest(om.writeValueAsString(loginDtoRequest), LoginDtoResponse.class);
        if(!loginDtoResponse.getToken().equals("NotFound")){
            return new ResponseEntity<>(loginDtoResponse,HttpStatus.OK);
        }
        throw new UserNotFoundException();
    }
}
