package com.example.authentication.dto;

import com.example.authentication.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private String password;
    private int role;
}
