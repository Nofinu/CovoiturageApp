package com.example.gatewayservice.controller;

import com.example.gatewayservice.dto.UserDto.UserDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findUserById (@PathVariable int id){
        RestClient<UserDtoResponse> userRestClient = new RestClient<>("http://localhost:"+ PortApi.portUser +"/api/user/"+id);
        UserDtoResponse userDtoResponse = userRestClient.getRequest(UserDtoResponse.class);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }
}
