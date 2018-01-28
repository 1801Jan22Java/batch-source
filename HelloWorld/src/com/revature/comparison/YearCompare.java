package com.revature.comparison;

import java.util.Comparator;

import com.revature.media.Movie;

public class YearCompare implements Comparator<Movie> {

	@Override	// using the Integer version of compareTo, usually use compareTo of a wrapper class here
	public int compare(Movie m1, Movie m2) {
		Integer year1 = m1.getYearPublished();
		return year1.compareTo(m2.getYearPublished());
	}

}
