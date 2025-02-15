package com.movievoting.movieVoting.errors;

public class GroupNotFoundException extends RuntimeException {
    String msg;
    public GroupNotFoundException(){
        this.msg="Sorry doesn't exist";
    }

}
