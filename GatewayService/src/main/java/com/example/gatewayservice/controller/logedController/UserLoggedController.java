package com.example.gatewayservice.controller.logedController;

import com.example.gatewayservice.dto.UserDto.UserDtoRequest;
import com.example.gatewayservice.dto.UserDto.UserDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class UserLoggedController {
    @GetMapping("/find_user")
    public ResponseEntity<UserDtoResponse> findUser (@RequestBody UserDtoRequest userDtoRequest){

    }
}
