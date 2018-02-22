package com.revature.dao;

import com.revature.domain.Movie;

public interface MovieDao {

	public Movie getMovieById(int id);
	public int addMovie(Movie m);
}
