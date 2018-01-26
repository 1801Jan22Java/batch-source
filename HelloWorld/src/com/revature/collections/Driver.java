package com.revature.collections;

<<<<<<< HEAD


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.revature.media.Media;
=======
import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e

public class Driver {

	public static void main(String[] args) {
<<<<<<< HEAD
		// funWithLists();

		funWithMaps();
=======

		// funWithLists();

		funWithMaps();

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
<<<<<<< HEAD
		Book b1 = new Book("Leo Tolstoy", "Anna Kareina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");
		// Use Collections Framework
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// Use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}

		// Print list elements iwth iterator
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = (Media) it.next();
=======
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
				;
			}
		}

		// print out list elements with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}

<<<<<<< HEAD
		// Iterators are different objects when created
		Iterator<Media> it2 = mediaList.iterator();
		System.out.println(it == it2);

		while (it2.hasNext()) {
			Media m = (Media) it2.next();
=======
		Iterator<Media> it2 = mediaList.iterator();

		while (it2.hasNext()) {
			Media m = it2.next();
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it2.remove();
			} else {
				System.out.println(m.toString());
			}
		}
<<<<<<< HEAD
=======

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

	public static void funWithMaps() {

		// new hashmap with key-value pairs
		Map<Integer, Media> hashMap = new HashMap<>();

<<<<<<< HEAD
		Book b1 = new Book("Leo Tolstoy", "Anna Kareina", 1877, "fiction");
=======
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
<<<<<<< HEAD
		// This will replace b1 with m2.
		// hashMap.put(1, m2);
		
		System.out.println(hashMap);
		
		System.out.println(hashMap.get(2));
		
		System.out.println("Hashmap size: "+hashMap.size());
		
		// Maps are not Collection, but the EntrySet of a map IS
		// To iterate through map, we have to use Entry
		for(Entry<Integer,Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
		}
	}
	
	
=======
		System.out.println(hashMap);
		
		//no duplicate keys
		System.out.println(hashMap.get(2));
		hashMap.put(2, new Book("Dr. Seuss","The Lorax",1971,"allegory"));
		System.out.println(hashMap.get(2));
		
		System.out.println("size of hashMap: "+hashMap.size());
		
		//while Maps are not Collections, the EntrySet of a Map IS. 
		for (Entry<Integer,Media> entry : hashMap.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			//System.out.println(entry.toString());
		}
		
	}
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e

}
