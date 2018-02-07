package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.collections.*;
interface LambdaThing {
	int lambdaSqr(int c);
}
public class Driver {

	public static void main(String[] args) {
		LambdaThing a = x -> {System.out.println("REEEEEEE");return 5;};
		
		System.out.println(a.lambdaSqr(5));
		funWithLists();
		funWithMaps();
	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();

		Book b1 = new Book(1877, "fiction", "Leo Tolstoy", "Anna Karenina");
		Book b2 = new Book(1877, "fiction", "Fyodor Dostayevsky", "Crime and Punishment");
		Movie m1 = new Movie(1995, "animation", "Pixar", "Toy Story");
		Movie m2 = new Movie(1993, "science fiction", "Michael Crichton", "Jurassic Park");

		// mediaList.add(b1);
		// mediaList.add(b2);
		// mediaList.add(m1);
		// mediaList.add(m2);

		// also works lul
		Collections.addAll(mediaList, b1, b2, m1, m2);

		for (Media m : mediaList) {

			if (m instanceof Book) {
				((Book) m).read();
			}

			else if (m instanceof Movie) {
				((Movie) m).watch();
			}
		}

		// print out list elements with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();

		while (it.hasNext()) {
			Media m = it.next();
			if (m.getYearPublished() <= 1878) {
				System.out.println("removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}

		}
	}

	public static void funWithMaps() {

		// new hashmap with key-value pairs
		Map<Integer, Media> hashMap = new HashMap<>();

		Book b1 = new Book(1877, "fiction", "Leo Tolstoy", "Anna Karenina");
		Book b2 = new Book(1877, "fiction", "Fyodor Dostayevsky", "Crime and Punishment");
		Movie m1 = new Movie(1995, "animation", "Pixar", "Toy Story");
		Movie m2 = new Movie(1993, "science fiction", "Michael Crichton", "Jurassic Park");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		System.out.println(hashMap);
		
		for(Entry<Integer,Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
		}

	}

}
