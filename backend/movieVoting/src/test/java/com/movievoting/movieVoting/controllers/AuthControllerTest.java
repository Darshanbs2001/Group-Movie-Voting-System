package com.movievoting.movieVoting.controllers;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.response.LoginResponseDto;
import com.movievoting.movieVoting.security.JwtService;
import com.movievoting.movieVoting.services.UserService;
import com.movievoting.movieVoting.services.UserServiceImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(AuthController.class)
@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserServiceImp userService;// Add this line to mock JwtService

    @Test
    public void test_registerUser_Success() throws Exception {
        // Arrange
        UserDto userDto = new UserDto("Vinay", "password123", "vinay@gmail.com");
        User user = new User();
        user.setUserName("Vinay");
        user.setEmail("vinay@gmail.com");

        when(userService.createUser(Mockito.any(UserDto.class))).thenReturn(user);

        // Act & Assert
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Vinay\", \"password\": \"password123\", \"email\": \"vinay@gmail.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Vinay"))
                .andExpect(jsonPath("$.email").value("vinay@gmail.com"));
    }

    @Test
    public void test_loginUser_Success() throws Exception {
        // Arrange
        LoginDto loginDto = new LoginDto("vinay@gmail.com", "password123");
        LoginResponseDto loginResponseDto = new LoginResponseDto("mocked-jwt-token", new UserDto("Vinay", "password123", "vinay@gmail.com"));

        when(userService.loginUser(Mockito.any(LoginDto.class))).thenReturn(loginResponseDto);

        // Act & Assert
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"vinay@gmail.com\", \"password\": \"password123\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.token").value("mocked-jwt-token"))
                .andExpect(jsonPath("$.user.email").value("vinay@gmail.com"));
    }

    @Test
    public void test_loginUser_UserNotFound() throws Exception {
        // Arrange
        when(userService.loginUser(Mockito.any(LoginDto.class))).thenThrow(new UserNotFoundException());

        // Act & Assert
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"nonexistent@gmail.com\", \"password\": \"password123\"}"))
                .andExpect(status().isNotFound());
    }
}
