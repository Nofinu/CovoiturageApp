package com.example.authentication.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ProtectedController {

    @GetMapping("")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Ok");
    }
}
