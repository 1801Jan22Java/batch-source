package com.revature.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CompareExample {

	public static void main(String[] args) {
		
		List<Movie> l = new ArrayList<Movie>();

		Movie b1 = new Movie(1877, "fiction", "Leo Tolstoy", "Anna Karenina");
		Movie b2 = new Movie(1877, "fiction", "Fyodor Dostayevsky", "Crime and Punishment");
		Movie m1 = new Movie(1995, "animation", "Pixar", "Toy Story");
		Movie m2 = new Movie(1993, "science fiction", "Michael Crichton", "Jurassic Park");
		
		Collections.addAll(l, b1,b2,m1,m2);
		for (Media m : l) {
			System.out.println(m);
		}
		
		sortWithComparable(l);
	}
	
	public static List<Movie> sortWithComparable(List<Movie> l) {
		Collections.sort(l);
		for (Media m : l) {
			System.out.println(m);
		}
		return l;
		
	}
}
