package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class UserServiceImp implements UserService{//added abstract because of unimplemented method 
    @Autowired
    ModelMapper mapper;
    @Autowired
    UserRepo ur;
    @Override
    public User createUser(UserDto user) {
        User convertedUser=mapper.map(user,User.class);
        System.out.println("service:"+convertedUser);
        return ur.save(convertedUser);
    }

    @Override
    public UserDto deleteUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return ur.findByEmail(email).orElseThrow((()->new UserNotFoundException()));

    }
}
