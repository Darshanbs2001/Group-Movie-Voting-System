package com.movievoting.movieVoting.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
