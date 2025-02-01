package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImpTest {
    @Autowired
    UserService service;

   @Test
    public void testcreateUser(){
       UserDto userToSave=new UserDto("vinay b s","Vi@9141525275","vinay@gmail.com");
       assertNotNull(service.createUser(userToSave));
   }
}