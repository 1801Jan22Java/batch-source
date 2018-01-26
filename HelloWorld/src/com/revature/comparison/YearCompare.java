package com.revature.comparison;

import java.util.Comparator;

<<<<<<< HEAD
import com.revature.collections.Movie;
=======
import com.revature.media.Movie;
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e

public class YearCompare implements Comparator<Movie>{

	@Override
	public int compare(Movie m1, Movie m2) {
		Integer year1 = m1.getYearPublished();
<<<<<<< HEAD
		
		// We use Integer because Integer is comparable
		//return year1.compareTo(m2.getYearPublished());
		
		// or
		return m1.getYearPublished()-m2.getYearPublished();
	}

	
	
=======
		return year1.compareTo(m2.getYearPublished());
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
