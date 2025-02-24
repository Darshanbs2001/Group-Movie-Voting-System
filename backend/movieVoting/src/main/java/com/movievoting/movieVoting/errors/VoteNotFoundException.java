package com.movievoting.movieVoting.errors;

public class VoteNotFoundException extends RuntimeException{
 static String msg="Vote not found";;
 public VoteNotFoundException(){
     super(msg);
 }
}
