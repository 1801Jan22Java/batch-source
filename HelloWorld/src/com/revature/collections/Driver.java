package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Driver {

	public static void main(String[] args) {
		//funWithLists();
		funWithMaps();
	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		// Books
		Book b1 = new Book("Leo Tolstoy", "Anna Karenia", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		// Movies
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurrassic Park", 1993, "Science Fiction");

		Collections.addAll(mediaList, b1, b2, m1, m2);
		// use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
				;
			}

		}
		// print our list element with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it1 = mediaList.iterator();
		while (it1.hasNext()) {
			Media m = it1.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed" + m.getTitle());
				it1.remove();
			} else {
				System.out.println(m.toString());
			}
		}
		// Quick check to see it the iterator are the same
		Iterator<Media> it2 = mediaList.iterator();
		System.out.println(it1 == it2);
		// They are not...
	}

	public static void funWithMaps()
	{
		//new hashmap with key-value pairs
		Map<Integer,Media> hashMap = new HashMap<>();
		//Books
		Book b1 = new Book("Leo Tolstoy","Anna Karenia",1877,"fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		//Movies
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurrassic Park", 1993, "Science Fiction" );
		
		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		System.out.println(hashMap);
		
		//no duplicate keys
		System.out.println(hashMap.get(2));
		hashMap.put(2, new Book("Dr. Seuss", "The Lorax", 1971, "allegory"));
		System.out.println(hashMap.get(2));
		
		System.out.println("The size of our hashMap is: "+hashMap.size());
		
		//while Maps are not Collections, the EntrySet of a Map IS
		for(Entry<Integer,Media> entry: hashMap.entrySet())
		{
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
		}
	}
}
