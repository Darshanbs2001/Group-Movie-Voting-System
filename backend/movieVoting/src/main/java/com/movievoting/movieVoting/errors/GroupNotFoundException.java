package com.movievoting.movieVoting.errors;

public class GroupNotFoundException extends RuntimeException {
    String msg;
    public GroupNotFoundException(){
        this.msg="Sorry doesn't exist";

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
