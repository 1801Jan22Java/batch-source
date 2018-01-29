package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareExample 
{
	public static void main(String args[])
	{
		List<Movie> movieList = new ArrayList();
		// Books
		Movie b1 = new Movie("Leo Tolstoy", "Anna Karenia", 1877, "fiction");
		Movie b2 = new Movie("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		// Movies
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurrassic Park", 1993, "Science Fiction");
		Collections.addAll(movieList, b1,b2,m1,m2);
		//sortWithComparable(movieList);
		sortWithComparator(movieList);
		
	}
	public static List<Movie> sortWithComparable(List<Movie> l)
	{
		Collections.sort(l);
		//System.out.println("Movies after sortWithComparable: "l.toString());
		return l;
	}
	public static List<Movie> sortWithComparator(List<Movie> l)
	{
		YearCompare yc = new YearCompare();
		Collections.sort(l,yc);
		for(Movie m: l)
		{
			System.out.println(m.yearPublished);
		}
		return l;
		
	}
}
