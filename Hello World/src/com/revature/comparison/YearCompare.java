package com.revature.comparison;

import java.util.Comparator;

import com.revature.media.*;

public class YearCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie arg0, Movie arg1) {

		Integer year1 = arg0.getYearPublished();
		return year1.compareTo(arg1.getYearPublished());
	}

}
