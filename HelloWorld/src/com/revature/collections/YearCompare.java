package com.revature.collections;

import java.util.Comparator;

public class YearCompare implements Comparator<Movie>
{
	@Override
	public int compare(Movie m1, Movie m2) 
	{
		Integer year1 = m1.getYearPublished();
		Integer year2 = m2.getYearPublished();
		return year1.compareTo(year2);
	}

}
