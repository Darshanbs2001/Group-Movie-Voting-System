package com.movievoting.movieVoting.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;


public class LoginDto {
    @Email
    String email;
    @Pattern(regexp =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d)[A-Za-z\\d\\W]{7,}$")
    String password;

    public LoginDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
