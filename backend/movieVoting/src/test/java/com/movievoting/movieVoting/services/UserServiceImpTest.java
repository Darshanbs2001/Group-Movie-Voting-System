package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import org.assertj.core.api.Assertions;
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
    @Test
    public void test_if_user_is_not_found(){
        assertThrows(UserNotFoundException.class,()->service.findByEmail("darshandarshan59@gmail.com"));
    }
    @Test
    public void test_if_user_is_found(){

        assertDoesNotThrow(()->service.findByEmail("vinay@gmail.com"));
        User user =service.findByEmail("vinay@gmail.com");
        Assertions.assertThat(user.getUserName()).isEqualTo("vinay b s");

    }

    @Test
    public void test_delete_User_When_Found(){
        UserDto userTodelete= new UserDto("vinay b s","Vi@9141525275","vinay@gmail.com");
        assertTrue(service.deleteUser(userTodelete));
    }

}