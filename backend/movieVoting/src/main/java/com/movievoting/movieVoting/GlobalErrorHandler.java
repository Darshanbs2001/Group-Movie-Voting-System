package com.movievoting.movieVoting;

import com.movievoting.movieVoting.errors.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> userNotFound(UserNotFoundException e) {
    	Map<String,String>errorResponse=new HashMap<>();
        errorResponse.put("error","user not found");
        errorResponse.put("message",e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
}
