package com.example.gatewayservice.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Around;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {
    private int id_user;
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private int role;
}
