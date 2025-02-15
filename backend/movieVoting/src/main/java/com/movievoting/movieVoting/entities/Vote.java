package com.movievoting.movieVoting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int voteId;
    @Column
    private boolean vote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movieId")
    Movie movie;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    User user;
    @ManyToOne
    @JoinColumn(name="groupId")
    Group group;

}
