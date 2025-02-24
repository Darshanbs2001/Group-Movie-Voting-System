package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.response.LoginResponseDto;

public interface UserService {
     User createUser(UserDto user);

    boolean deleteUser(int userId);

    UserDto updateUser(UserDto user);
    User findByEmail(String email);
	LoginResponseDto loginUser(LoginDto login);
}
