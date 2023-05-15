package com.movierating.services;

import java.util.List;

import com.movierating.payload.MovieDto;
import com.movierating.payload.RatingDto;

public interface RatingServices {

	RatingDto createRating(long movieId,RatingDto ratingDto);
    List<RatingDto> getRatingByMovieId(long movieId);

    RatingDto getRatingById(Long movieId, Long ratingId);

}
