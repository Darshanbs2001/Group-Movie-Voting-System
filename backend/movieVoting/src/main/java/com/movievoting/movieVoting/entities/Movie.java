package com.movievoting.movieVoting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;
    String tmdbId;
    String title;
    Double rating;
    String description;
    
    String customNotes;
    @ManyToOne
    @JoinColumn(name="userId")
    User user;
    @ManyToOne
    @JoinColumn(name="groupId")
    Group group;
}
