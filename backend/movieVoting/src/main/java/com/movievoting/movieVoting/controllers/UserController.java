package com.movievoting.movieVoting.controllers;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.services.UserService;
import jakarta.validation.Valid;

import java.util.concurrent.ExecutorService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
	
    @Autowired
    UserService us;

    @PostMapping("/register")
    public ResponseEntity<String> signUP(@RequestBody @Valid  UserDto user) {
        //System.out.println("controller:" + user);
    	us.createUser(user);
        return ResponseEntity.ok("user registration sucessfully"+us.createUser(user));
    }
//may be postMapping annotation
    @GetMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid LoginDto user) {
    	User u=us.findByEmail(user.getEmail());
        return ResponseEntity.ok("user login is successfull");
    }


}
