package com.movievoting.movieVoting.errors;

public class MovieNotFoundException extends RuntimeException{
    static String msg="There are no movies with the specified details";
    ;
    public MovieNotFoundException(){
        super(msg);
    }
    
}
