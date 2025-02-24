package com.movievoting.movieVoting.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.UserRepo;
import com.movievoting.movieVoting.response.LoginResponseDto;
import com.movievoting.movieVoting.security.JwtService;

/**
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {
	@Mock
	UserRepo ur;
	@InjectMocks
	UserServiceImp service;
	@Mock
	ModelMapper mapper;
	@Mock
	PasswordEncoder encoder;
	@Mock
	AuthenticationManager manager;
	@Mock
	UserDetailsService userDetailsService;
	@Mock
	JwtService jwts;
	private UserDto userToSave;
	private User user;

	@BeforeEach
	void setup() {
		userToSave = new UserDto();
		userToSave.setEmail("vinay@gmail.com");
		userToSave.setName("Vinay B S");
		user = new User();
		user.setName("vinay b s");
		user.setPassword(userToSave.getPassword());
		user.setEmail(userToSave.getEmail());
	}

	@Test
	@Order(1)
	public void testcreateUser() {

		when(encoder.encode(userToSave.getPassword())).thenReturn("Encoded string");
		// when(mapper.map(userToSave,User.class)).thenReturn(user);
		when(ur.save(Mockito.any(User.class))).thenReturn(user);
		assertNotNull(service.createUser(userToSave));
		assertEquals("vinay@gmail.com", service.createUser(userToSave).getUsername());

	}

	@Test
	@Order(3)
	public void test_if_user_is_not_found() {
		when(ur.findByEmail(Mockito.anyString())).thenThrow(new UserNotFoundException());
		assertThrows(UserNotFoundException.class, () -> service.findByEmail("darshandarshan59@gmail.com"));
	}

	@Test
	@Order(2)
	public void test_if_user_is_found() {
		when(ur.findByEmail(Mockito.anyString())).thenReturn(Optional.ofNullable(user));

		assertDoesNotThrow(() -> service.findByEmail("vinay@gmail.com"));
		User user = service.findByEmail("vinay@gmail.com");
		Assertions.assertThat(user.getUsername()).isEqualTo("vinay@gmail.com");

	}

	@Order(4)
	@Test
	public void test_delete_User_When_Found() {

		UserDto userTodelete = new UserDto("vinay b s", "Vi@9141525275", "vinay@gmail.com");
		when(ur.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(user));
		assertTrue(service.deleteUser(1));
		verify(ur, times(1)).delete(user);
	}

	@Disabled
	@Test
	@Order(5)
	public void test_loginUser_Success() {
		// Arrange
		User loginuser = new User();
		loginuser.setEmail("vinay@gmail.com");
		loginuser.setPassword("hashedPassword");

		LoginDto loginDto = new LoginDto("vinay@gmail.com", "plainPassword");

		// Mocking the repository to return the user
		when(ur.findByEmail("vinay@gmail.com")).thenReturn(Optional.of(user));

		// Mocking the AuthenticationManager to simulate successful authentication
		Authentication auth = mock(Authentication.class);
		when(auth.isAuthenticated()).thenReturn(true);
		when(manager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(auth);

		// Mocking userDetailsService to load user details
		UserDetails userDetails = mock(UserDetails.class);
		when(userDetailsService.loadUserByUsername("vinay@gmail.com")).thenReturn(userDetails);

		// Mocking the JWT utility to return a token
		when(jwts.generateToken(userDetails)).thenReturn("mocked-jwt-token");

		// Act
		LoginResponseDto response = service.loginUser(loginDto);

		// Assert
		assertNotNull(response);
		assertEquals("mocked-jwt-token", response.getJwt());
		assertEquals("vinay@gmail.com", response.getEmail());
	}

}