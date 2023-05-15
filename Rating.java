package com.movierating.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="ratings")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="average_rating",nullable=false)
	private float averageRating;
	
	@Column(name="num_votes",nullable=false)
	private long numVotes;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="movie_id",nullable=false)
	private Movie movie;

	
}
