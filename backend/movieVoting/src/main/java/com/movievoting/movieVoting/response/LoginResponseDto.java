package com.movievoting.movieVoting.response;

import com.movievoting.movieVoting.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    String jwt;
    UserDto user;


}
