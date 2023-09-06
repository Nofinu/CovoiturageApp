package com.example.gatewayservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDtoRequest {
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private String password;
    private int role;
}
