package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {
		//funWithLists();
		funWithMaps();

	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction", "Russia");
		Book b2 = new Book("Fryodor Dostoyevesky", "Crime and Punishment", 1866, "Fiction", "Tzar Nicholas II");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			} else if (m instanceof Movie) {
				((Movie) m).watch();
			}
		}

		// print out list elements with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("Removing " + m.getTitle());
				it.remove();
			} else
				System.out.println(m.toString());
		}
	}

	public static void funWithMaps() {
		// new hashmap with key-value pairs;
		Map<Integer, Media> hashMap = new HashMap<>();

		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction", "Russia");
		Book b2 = new Book("Fryodor Dostoyevesky", "Crime and Punishment", 1866, "Fiction", "Russia");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		// no duplicate keys
		hashMap.put(2,  new Book("Dr. Seuss", "The Lorax", 1971, "Allegory", "America"));
		System.out.println("Size of Hashmap " + hashMap.size());
		
		// while maps are not collections, the entry set / key set is a collection. 
		for(Entry<Integer, Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
		}

	}

}
