package com.movierating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.payload.RatingDto;
import com.movierating.services.RatingServices;

@RestController
@RequestMapping("/api/")
public class RatingController {

	
	private RatingServices ratingSer;
	
    public RatingController(RatingServices ratingSer) {
		super();
		this.ratingSer = ratingSer;
	}

	@PostMapping("")
    public ResponseEntity<RatingDto> createComment(@PathVariable(value = "postId") long postId,  @RequestBody RatingDto ratingDto){
        
return new ResponseEntity<>(ratingSer.createRating(postId, ratingDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<RatingDto> getCommentsByPostId(@PathVariable(value = "movieId") Long movieId){
        return ratingSer.getRatingByMovieId(movieId);
    }

    @GetMapping("")
    public ResponseEntity<RatingDto> getCommentById(@PathVariable(value = "movieId") Long movieId,
                                                     @PathVariable(value = "id") Long ratingId){
        RatingDto commentDto = ratingSer.getRatingById(movieId, ratingId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

}
