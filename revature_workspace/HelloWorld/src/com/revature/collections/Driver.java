package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		//funWithLists();
		funWithMaps();
	}
	


	public static void funWithLists()

	{
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction");
		Book b2 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 1866,
				"Fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993,
				"science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// Use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}

		// print out list elements with iterator and while loop
		// remove any elements published before 1870

		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("Removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}

		Iterator<Media> it2 = mediaList.iterator();

		while (it2.hasNext()) {
			Media m = it2.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("Removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}

	}

	public static void funWithMaps() {
		// new hashmap with key-value pairs
		Map<Integer, Media> hashMap = new HashMap<>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction");
		Book b2 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 1866,
				"Fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993,
				"science fiction");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		System.out.println(hashMap.get(1));
		System.out.println(hashMap);
		
		//No duplicate keys.  Keys are set.
		hashMap.put(2,  new Book("Dr. Seuss","The Lorax",1971,"allegory"));
		
		System.out.println(hashMap);
		
		System.out.println();
		
		System.out.println("size of hashMap: " + hashMap.size());
		
		// while Maps are not Collections, the EntrySet of a Map IS a collection.
		
		for(Entry<Integer,Media> entry: hashMap.entrySet())
		{
			System.out.println(entry.getKey() + "\t"+ entry.getValue());
			System.out.println(entry.toString());
		}

	}

	
}
