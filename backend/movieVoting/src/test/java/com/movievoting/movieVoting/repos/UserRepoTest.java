package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepoTest {

    @Autowired
    UserRepo repo;
    @BeforeEach
    void setUp(){
        User user=new User();
        user.setUserName("Darshan B S");
        user.setEmail("darshandarsha59@gmail.com");
        user.setPassword("something");
        repo.save(user);
    }
    @Test
    void test_findByEmail_user(){
        assertThrows(UserNotFoundException.class,()->repo.findByEmail("darshandarsha@gmail.com").orElseThrow(()->new UserNotFoundException()));
        assertThat(repo.findByEmail("darshandarsha59@gmail.com")).isNotNull();

    }

}