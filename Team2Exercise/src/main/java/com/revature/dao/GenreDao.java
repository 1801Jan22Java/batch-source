package com.revature.dao;

import com.revature.domain.Genre;

public interface GenreDao {

	public Genre getGenreById(int id);
	public int addGenre(Genre g);
}
