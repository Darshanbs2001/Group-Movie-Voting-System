package com.movievoting.movieVoting.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.UserRepo;

@Service
public class UserServiceImp implements UserService{//added abstract because of unimplemented method 
    

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
    public boolean deleteUser(UserDto user) {
        User foundUser=this.findByEmail(user.getEmail());
        if(foundUser!=null){
            ur.delete(foundUser);
            return true;
        }
       return false;

    }

    @Override
    public UserDto updateUser(UserDto user) {
        User foundUser=this.findByEmail(user.getEmail());
        if(foundUser!=null){
            foundUser.setEmail(user.getEmail());
            foundUser.setPassword(user.getPassword());
            foundUser.setUserName(user.getUserName());
            return mapper.map(foundUser,UserDto.class);

        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return ur.findByEmail(email).orElseThrow((()->new UserNotFoundException()));

    }
    public List<User> findAll(){
    	return ur.findAll();
    }
}
