package com.movierating.payload;

import lombok.Data;

@Data
public class RatingDto {

	private long tconst;

	private float averageRating;
	
	private long numVotes;
}
