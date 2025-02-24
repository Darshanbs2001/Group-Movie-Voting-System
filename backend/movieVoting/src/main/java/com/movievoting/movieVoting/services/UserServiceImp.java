package com.movievoting.movieVoting.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.movievoting.movieVoting.dto.LoginDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.Movie;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.MovieRepo;
import com.movievoting.movieVoting.repos.UserRepo;
import com.movievoting.movieVoting.response.LoginResponseDto;
import com.movievoting.movieVoting.security.JwtService;

@Service
public class UserServiceImp implements UserService{//added abstract because of unimplemented method 
    

	@Autowired
    ModelMapper mapper;
    @Autowired
    UserRepo ur;
    @Autowired
    MovieRepo mr;
    @Autowired
    AuthenticationManager manager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtService jwts;
    @Autowired
    PasswordEncoder encoder;
    @Override
    public User createUser(UserDto user) {
        //User convertedUser=mapper.map(user,User.class);
        User convertedUser=new User();
        convertedUser.setName(user.getName());
        convertedUser.setEmail(user.getEmail());
    	convertedUser.setPassword(encoder.encode(user.getPassword()));
        System.out.println("service:"+convertedUser);
        return ur.save(convertedUser);
    }

    @Override
    public boolean deleteUser(int userId) {
        User foundUser= ur.findById(userId).orElseThrow(()->new UserNotFoundException());
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
            foundUser.setName(user.getName());
            return mapper.map(foundUser,UserDto.class);

        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return ur.findByEmail(email).orElseThrow((()-> new UserNotFoundException()));

    }
    public List<User> findAll(){
        List<User> users=ur.findAll();
    	System.out.println(users);
        return users;

    }
    @Override
    public LoginResponseDto loginUser(LoginDto login){
        User u=ur.findByEmail(login.getEmail()).orElseThrow(()->new UserNotFoundException());
        Authentication auth=manager.authenticate(new UsernamePasswordAuthenticationToken(
                login.getEmail(),login.getPassword()
        ));
        String token;
        if(auth.isAuthenticated()) {
            token= jwts.generateToken(userDetailsService.loadUserByUsername(login.getEmail()));

        }
        else {
            throw new UsernameNotFoundException("Invalid user");
        }
        LoginResponseDto loginResponseDto=new LoginResponseDto();
        loginResponseDto.setJwt(token);
        loginResponseDto.setUserId(u.getUserId());
        loginResponseDto.setAdmin(u.isAdmin());
        loginResponseDto.setUserName(u.getUsername());
        loginResponseDto.setEmail(u.getEmail());
        return loginResponseDto;
    }
}
