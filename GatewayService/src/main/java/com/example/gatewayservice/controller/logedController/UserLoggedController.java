package com.example.gatewayservice.controller.logedController;

import com.example.gatewayservice.dto.UserDto.UserDtoRequest;
import com.example.gatewayservice.dto.UserDto.UserDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class UserLoggedController {

    private final ObjectMapper om;
    public UserLoggedController() {
        this.om = new ObjectMapper();
    }

    @PostMapping("/finduser")
    public ResponseEntity<UserDtoResponse> findUser (@RequestBody UserDtoRequest userDtoRequest) throws JsonProcessingException {
        RestClient<UserDtoResponse> userRestClient = new RestClient<>("http://localhost:"+ PortApi.portUser +"/api/user/findbyemail");
        UserDtoResponse userDtoResponse = userRestClient.postRequest(om.writeValueAsString(userDtoRequest),UserDtoResponse.class);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }
}
