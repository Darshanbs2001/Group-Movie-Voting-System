package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.response.LoginResponseDto;

public interface UserService {
    public User createUser(UserDto user);
    public boolean deleteUser(UserDto user);
    public UserDto updateUser(UserDto user);
    public User findByEmail(String email);
	public LoginResponseDto loginUser(LoginDto login);
}
