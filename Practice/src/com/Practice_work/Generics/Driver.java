package com.Practice_work.Generics;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<>();
		Movie m1 = new Movie("Force Awakens",8.3,2015);
		Movie m2 = new Movie("Star Wars",8.7,1977);
		Movie m3 = new Movie("Empire Strikes Back",8.8,1980);
		Movie m4 = new Movie("Return of the Jedi",8.4,1983);
		
		Collections.addAll(list, m1,m2,m3,m4);
		
	}

}
