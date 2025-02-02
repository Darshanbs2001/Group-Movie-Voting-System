package com.movievoting.movieVoting;

import com.movievoting.movieVoting.errors.UserNotFoundException;

import InvalidCredentialsException.InvalidCredentialsException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    	
    	Map<String, String> errors = new HashMap<>();
    	ex.getBindingResult().getAllErrors().forEach((error) ->{
    		
    		String fieldName = ((FieldError) error).getField();
    		String message = error.getDefaultMessage();
    		errors.put(fieldName, message);
    	});
    	return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String, String>> invalidCredentials(InvalidCredentialsException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "invalid credentials");
        errorResponse.put("message", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
