package com.movievoting.movieVoting.utility;

import lombok.Data;

@Data
public class MovieWithVotes {
    int movieId;
    String tmdbId;
    String title;
    Double rating;
    String description;
    int voteCount;
    boolean hasVoted;
}
