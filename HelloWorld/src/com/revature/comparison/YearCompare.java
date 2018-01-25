package com.revature.comparison;

import java.util.Comparator;

import com.revature.media.Movie;

public class YearCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		Integer year1 = o1.getYearPublished();
		Integer year2 = o2.getYearPublished();
		return year1.compareTo(year2);
	}

}
