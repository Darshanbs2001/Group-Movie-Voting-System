package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;

public interface UserService {
    public User createUser(UserDto user);
    public UserDto deleteUser(UserDto user);
    public UserDto updateUser(UserDto user);
    public User findByEmail(String email);
}
