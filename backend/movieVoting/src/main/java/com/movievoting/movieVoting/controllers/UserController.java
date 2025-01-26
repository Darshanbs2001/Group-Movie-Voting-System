package com.movievoting.movieVoting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.repos.UserRepo;
import com.movievoting.movieVoting.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService us;
    @Autowired
    UserRepo ur;

    @PostMapping("/register")
    public ResponseEntity<User> signUP(@RequestBody @Valid  UserDto user) {
        System.out.println("controller:" + user);
        return ResponseEntity.ok(us.createUser(user));
    }

    @GetMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody @Valid LoginDto user) {
        return ResponseEntity.ok(us.findByEmail(user.getEmail()));
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> listAll(){
        List<User> users=ur.findAll();
        return ResponseEntity.ok(users);
    }


}
