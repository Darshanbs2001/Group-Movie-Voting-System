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
@Table(name="app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
   // private int userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    String email;
    @JsonIgnore
    @OneToMany(mappedBy = "createdBy",fetch = FetchType.LAZY)
    private List<Group> groups=new ArrayList<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "members",fetch = FetchType.LAZY)
    private Set<Group> memberOfGroups=new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Movie> movies=new ArrayList<>();

}
