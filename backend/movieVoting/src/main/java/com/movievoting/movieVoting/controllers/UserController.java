package com.movievoting.movieVoting.controllers;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.services.UserService;
import jakarta.validation.Valid;
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
    	try {
    		us.signUP(user.getEmail());
    		return ResponseEntity.ok("you have sign up successfully using email:"+user.getEmail());
    	}catch(RuntimeException e) {
    		return ResponseEntity.status(400).body(e.getMessage());
    	}
    /*    System.out.println("controller:" + user);
        return ResponseEntity.ok(us.createUser(user));
        */
    }

    @GetMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody @Valid LoginDto user) {
        return ResponseEntity.ok(us.findByEmail(user.getEmail()));
    }


}
