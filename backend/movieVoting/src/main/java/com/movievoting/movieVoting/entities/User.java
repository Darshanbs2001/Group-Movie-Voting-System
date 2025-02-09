package com.movievoting.movieVoting.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="app_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    String email;
    @Column
     boolean isAdmin=false;
    @JsonIgnore
    @OneToMany(mappedBy = "createdBy",fetch = FetchType.LAZY)
    private List<Group> groups=new ArrayList<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "members",fetch = FetchType.LAZY)
    private Set<Group> memberOfGroups=new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Movie> movies=new ArrayList<>();





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> authorities=new HashSet<String>();
        authorities.add("User");
        if(isAdmin){
          authorities.add("Admin");
        }
        return authorities.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet());

    }

    @Override
    public String getUsername() {
        return email;
    }
}
