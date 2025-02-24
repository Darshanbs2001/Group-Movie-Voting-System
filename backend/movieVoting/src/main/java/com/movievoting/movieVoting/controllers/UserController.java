package com.movievoting.movieVoting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.services.UserServiceImp;

import jakarta.validation.Valid;
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
    UserServiceImp us;

    @PostMapping("/register")
    public ResponseEntity<String> signUP(@RequestBody @Valid  UserDto user) {
        //System.out.println("controller:" + user);
        return ResponseEntity.ok("user registration sucessfully"+us.createUser(user));
    }
//may be postMapping annotation
    @GetMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid LoginDto user) {
    	User u=us.findByEmail(user.getEmail());
        return ResponseEntity.ok("user login is successfull");
    }
    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAll(){
    	return ResponseEntity.ok(us.findAll());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "userId")int userId){
        if(us.deleteUser(userId))
        {
            return ResponseEntity.ok("Deleted the user");
        }
        return new ResponseEntity("Sorry unable to delete the user", HttpStatus.NOT_FOUND);
    }


}
