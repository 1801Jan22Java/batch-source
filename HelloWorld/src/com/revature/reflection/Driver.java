package com.revature.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.collections.Book;
import com.revature.collections.Movie;
import com.revature.media.Media;

public class Driver {

	public static void main(String[] args) {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Kareina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");
		// Use Collections Framework
		Collections.addAll(mediaList, b1, b2, m1, m2);
		System.out.println(mediaList);
		Collections.shuffle(mediaList);
		System.out.println(genericReflections(mediaList));
		
	}

	public static <T> T genericReflections(List<T> l) {
		for (T item : l) {
			if (item.getClass().getName().equals("com.revature.media.Book")) {
				return item;
			}
		}
		return null;
	}

	public static void funWithReflections() {
		try {
			Class clazz = Class.forName("com.revature.media.Media");
			System.out.println(clazz.getSimpleName());

			// print fields that are protected, even private!!!!
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				System.out.println(f.getName() + " with a data type of: " + f.getType());
			}

			// new instance of Book
			Class clazz2 = Class.forName("com.revature.collections.Book");

			// Also note, we didn't have to import Media previously.
			Book b1 = (Book) clazz2.newInstance();
			System.out.println(b1);
			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b1, "Michael Bay");
			System.out.println(b1);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
