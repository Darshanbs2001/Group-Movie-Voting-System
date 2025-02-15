package com.movievoting.movieVoting.errors;

public class MovieNotFoundException extends RuntimeException{
    String msg;
    public MovieNotFoundException(){
        this.msg="There are no movies with the specified details";
    }
}
