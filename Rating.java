package com.movierating.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

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
	private long tconst;
	
	@Column(name="averageRating")
	private float averageRating;
	
	@Column(name="numVotes")
	private long numVotes;
	
	
}
