package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class CompareExample {

	public static void main(String[] args) {

		List<Movie> movieList = new ArrayList<Movie>();
		Movie m1 = new Movie("Leo Tolstoy", "Anna Karenina", 1877, "action");
		Movie m2 = new Movie("Fyodor Dostoevsky", "Crime and Punishment", 1866,
				"romcom");
		Movie m3 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m4 = new Movie("Michael Crichton", "Jurassic Park", 1993,
				"science fiction");
		Collections.addAll(movieList,m1,m2,m3,m4);
		for(Movie m: movieList)
		{
			System.out.println(m);
		}
		
		List<Movie> l=sortWithComparable(movieList);
		sortWithComparator(movieList);
		
	}
	
	public static List<Movie> sortWithComparable(List<Movie>l)
	{
		Collections.sort(l);
		System.out.println("Movies after sortWithComparable");
		for(Movie m: l)
		{
			System.out.println(m);
		}
		return l;
		
		
	}
	
	public static List<Movie> sortWithComparator(List <Movie> l)
	{
		YearCompare yc = new YearCompare();
		Collections.sort(l,yc);
		System.out.println("Movies after sortWithComparator: ");
		for(Movie m: l)
		{
			System.out.println(m);
		}

		return l;
	}

}
