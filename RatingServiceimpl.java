package com.movierating.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.movierating.entity.Movie;
import com.movierating.entity.Rating;
import com.movierating.exception.ResourceNotFoundexception;
import com.movierating.payload.MovieDto;
import com.movierating.payload.RatingDto;
import com.movierating.repository.MovieRepository;
import com.movierating.repository.RatingRepository;

@Service
public class RatingServiceimpl implements RatingServices {

	private RatingRepository ratingRepo;
	private MovieRepository movieRepo;
	private ModelMapper mapper;
	
	
	public RatingServiceimpl(RatingRepository ratingRepo, MovieRepository movieRepo, ModelMapper mapper) {
		super();
		this.ratingRepo = ratingRepo;
		this.movieRepo = movieRepo;
		this.mapper = mapper;
	}


	@Override
	public RatingDto createRating(long movieId, RatingDto ratingDto) {
		
		Rating rating= mapToEntity(ratingDto);
		Movie movie=movieRepo.findById(movieId).orElseThrow(()-> new ResourceNotFoundexception("Movie","id",movieId));
		//rating.setMovie(movie);
		Rating newRating=ratingRepo.save(rating);
		return mapToDTO(newRating);
	}


	private RatingDto mapToDTO(Rating rating) {
		RatingDto ratingDto=mapper.map(rating, RatingDto.class);
		return null;
	}

	private Rating mapToEntity(RatingDto ratingDto) {
		Rating rating=mapper.map(ratingDto, Rating.class);
		return null;
	}


	@Override
	public List<RatingDto> getRatingByMovieId(long movieId) {
		
        List<Rating> ratings = ratingRepo.findByMovieId(movieId);

        return ratings.stream().map(rating -> mapToDTO(rating)).collect(Collectors.toList());

	}


	@Override
	public RatingDto getRatingById(Long movieId, Long ratingId) {
		
        
        Movie movie  = movieRepo.findById(movieId).orElseThrow(
                () -> new ResourceNotFoundexception("Movie", "id", movieId));

        
        Rating rating = ratingRepo.findById(ratingId).orElseThrow(() ->
                new ResourceNotFoundexception("Rating", "id", ratingId));

        return mapToDTO(rating);

	}

}
