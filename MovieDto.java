package com.movierating.payload;

import lombok.Data;

@Data
public class MovieDto {
	
		private long id;
		private String titleType;
		private String primarytitle;
		private long runtimeMinutes;
		private String genres;
	}


