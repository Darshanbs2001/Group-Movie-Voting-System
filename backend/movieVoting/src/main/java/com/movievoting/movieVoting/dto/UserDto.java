package com.movievoting.movieVoting.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Data;




@Data
public class UserDto {
    @NotEmpty(message = "Sorry user name cannot be empty")
    public String userName;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d)[A-Za-z\\d\\W]{7,}$")
    public String password;
    @Email
    public String email;

   
}
