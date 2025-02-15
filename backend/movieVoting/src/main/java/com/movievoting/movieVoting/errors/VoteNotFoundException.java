package com.movievoting.movieVoting.errors;

public class VoteNotFoundException extends RuntimeException{
 String msg;
 public VoteNotFoundException(){
     this.msg="Vote not found";
 }
}
