package com.movievoting.movieVoting.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;
    @Column(nullable = false)
    String userName;
    @Column(nullable = false)
    String password;
    @Column(nullable = false,unique = true)
    String email;
    @ManyToMany
    @JoinTable(name = "group_members",joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns =
            @JoinColumn(name="groupId") )
    Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "user")
    List<Movie> movies=new ArrayList<>();

}
