package com.movievoting.movieVoting.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.UserRepo;
@Component
public class UtilityMethods {
	@Autowired
	UserRepo ur;
	public int returnId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
		{
			System.out.println(authentication.getPrincipal());
			String email=(String)authentication.getPrincipal();
			User user=ur.findByEmail(email).get();
			System.out.println(email);
			return user.getUserId();
		}
		else {
			throw new UserNotFoundException();
		}
		
		
	}
}
