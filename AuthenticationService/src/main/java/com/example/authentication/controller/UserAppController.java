package com.example.authentication.controller;


import com.example.authentication.dto.*;
import com.example.authentication.entity.UserApp;
import com.example.authentication.security.JWTGenerator;
import com.example.authentication.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserAppController {
    private final AuthenticationManager authenticationManager;

    private final UserAppService userAppService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public UserAppController(AuthenticationManager authenticationManager, UserAppService userAppService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDto.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDTO) {
        try {
            registerRequestDTO.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
            UserApp userApp = userAppService.enregistrerUtilisateur(registerRequestDTO);
            return ResponseEntity.ok(RegisterResponseDto.builder().id(userApp.getId_user()).email(userApp.getEmail()).lastname(userApp.getLastname()).firstname(userApp.getFirstname()).phone(userApp.getPhone()).role(userApp.getRole().toString()).build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
