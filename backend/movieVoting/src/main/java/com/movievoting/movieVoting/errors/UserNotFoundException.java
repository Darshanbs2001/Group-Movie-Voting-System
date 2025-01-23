package com.movievoting.movieVoting.errors;

public class UserNotFoundException extends RuntimeException{
    String message;

    public UserNotFoundException() {
        this.message = "Sorry user not found";
    }
}
