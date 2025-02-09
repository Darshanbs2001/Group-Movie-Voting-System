package com.movievoting.movieVoting.security;

import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsImp implements UserDetailsService {
    @Autowired
    private UserRepo ur;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return ur.findByEmail(email).orElseThrow(()->new UserNotFoundException());
    }
}
