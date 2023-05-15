package com.movierating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movierating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

	List<Rating> findByMovieId(long movieId);

	

}
