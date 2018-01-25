package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.revature.media.*;

public class CompareExample {

	public static void main(String[] args) {
		
		List<Movie> movieList = new ArrayList<>();
		Movie b1 = new Movie("Leo Tolstory", "Anna Karenia", 1877, "action");
		Movie b2 = new Movie("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "romcom");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichon", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(movieList, b1, b2, m1, m2);
		
		System.out.println("Movies before sort: ");
		
		for (Movie m : movieList) {
			System.out.println(m);
		}
		System.out.println();
		//sortWithComparable(movieList);
		
		sortWithComparator(movieList);

	}
	
	public static List<Movie> sortWithComparable(List<Movie> list){
		
		Collections.sort(list);
		
		System.out.println("Movies after sort with Comparable: ");
		
		for (Movie m : list) {
			System.out.println(m);
		}
		
		return list;
	}
	
public static List<Movie> sortWithComparator(List<Movie> list){
		
	
		Collections.sort(list, new YearCompare());
		
		System.out.println("Movies after sort with Comparator: ");
		
		for (Movie m : list) {
			System.out.println(m);
		}
		
		return list;
	}

}
