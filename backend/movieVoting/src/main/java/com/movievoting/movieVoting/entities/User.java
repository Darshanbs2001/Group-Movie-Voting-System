package com.movievoting.movieVoting.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    String email;
    @JsonIgnore
    @OneToMany(mappedBy = "createdBy")
    private List<Group> groups=new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Movie> movies=new ArrayList<>();

}
