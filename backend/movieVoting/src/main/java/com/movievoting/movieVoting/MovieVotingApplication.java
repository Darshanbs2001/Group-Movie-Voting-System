package com.movievoting.movieVoting;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.movievoting.movieVoting.services.UserService;
import com.movievoting.movieVoting.services.UserServiceImp;

@SpringBootApplication
public class MovieVotingApplication {

	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieVotingApplication.class, args);
	}

}
