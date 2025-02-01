package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.UserDto;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImpTest {
    @Autowired
    UserService service;

    @Test
    public void testcreateUser() {
        UserDto userToSave = new UserDto("vinay b s", "Vi@9141525275", "vinay@gmail.com");
        assertNotNull(service.createUser(userToSave));
    }
}