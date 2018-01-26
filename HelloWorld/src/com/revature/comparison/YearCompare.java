package com.revature.comparison;

import java.util.Comparator;

import com.revature.collections.Movie;

public class YearCompare implements Comparator<Movie>{

	@Override
	public int compare(Movie m1, Movie m2) {
		Integer year1 = m1.getYearPublished();
		
		// We use Integer because Integer is comparable
		//return year1.compareTo(m2.getYearPublished());
		
		// or
		return m1.getYearPublished()-m2.getYearPublished();
	}

	
	
}
