package com.movievoting.movieVoting.response;

import com.movievoting.movieVoting.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    String jwt;
    int userId;
    String userName;
    String email;
    boolean isAdmin;



}
