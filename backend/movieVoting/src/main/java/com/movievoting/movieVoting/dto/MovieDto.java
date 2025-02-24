package com.movievoting.movieVoting.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class MovieDto {
    int movieId;
    @NotBlank
    String tmdbId;
    @Range(min = 1, max = 5, message = "rating must be within the specified range")
    Double rating;
    @NotBlank
    String title;
    @NotBlank
    String description;
    @NotBlank
    String customNotes;


}
