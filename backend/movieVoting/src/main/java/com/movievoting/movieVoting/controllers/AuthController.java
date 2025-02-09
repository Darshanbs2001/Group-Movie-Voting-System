package com.movievoting.movieVoting.controllers;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.repos.UserRepo;
import com.movievoting.movieVoting.response.LoginResponseDto;
import com.movievoting.movieVoting.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auth")
@RestController
public class AuthController {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    UserService service;
    @PostMapping("/register")
    public ResponseEntity<User> signUP(@RequestBody @Valid UserDto user) {
          return ResponseEntity.ok(service.createUser(user));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> signIn(@RequestBody LoginDto login){
        return new ResponseEntity<>(service.loginUser(login), HttpStatus.ACCEPTED);
    }
    @GetMapping("/some")
    public String hello(){
        return "Hello";
    }
}
