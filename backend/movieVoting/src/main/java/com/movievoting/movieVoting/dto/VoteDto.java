package com.movievoting.movieVoting.dto;

import lombok.Data;

@Data
public class VoteDto {
    int userId;
    int movieId;
    int groupId;
}
