package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.errors.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepoTest {

    @Autowired
    UserRepo repo;
    void test_findByEmail_user(){
        assertThrows(UserNotFoundException.class,()->repo.findByEmail("darshandarsha@gmail.com"));
        assertNotNull(repo.findByEmail("darshandarsha59@gmail.com"));

    }

}