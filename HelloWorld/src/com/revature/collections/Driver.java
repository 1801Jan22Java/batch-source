package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funWithMaps();
	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Steven Spielburg", "Jurrasic Park", 1993, "science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}

		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
			if (m.getYearPublished() < 1900) {
				System.out.println("removing " + m.getTitle());
				it.remove();
			} else {
				System.out.println("saving " + m.toString());
			}
		}
	}

	public static void funWithMaps() {
		Map<Integer, Media> myHashMap = new HashMap<>();

		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Steven Spielburg", "Jurrasic Park", 1993, "science fiction");

		myHashMap.put(1, b1);
		myHashMap.put(2, b2);
		myHashMap.put(3, m1);
		myHashMap.put(4, m2);
		System.out.println(myHashMap.get(2));
		myHashMap.put(2,  new Book("Dr. Seuss", "The Lorax", 1971, "allegory"));
		System.out.println(myHashMap.get(2));
		System.out.println("size of " + myHashMap.size());
		
		// ONLY WAY TO ITERATE THROUGH A MAP!!!!!!!
		for (Entry<Integer, Media> entry : myHashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().getCreator());
			System.out.println(entry.toString());
		}

	}

}
