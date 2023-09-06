package com.example.gatewayservice.dto.AuthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDtoRequest {
    private String email;
    private String password;
}
