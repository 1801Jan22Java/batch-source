package com.revature.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class Driver {

	public static void main(String[] args) {

		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction", "Russia");
		Book b2 = new Book("Fryodor Dostoyevesky", "Crime and Punishment", 1866, "Fiction", "Russia");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);
		
		System.out.println(genericReflections(mediaList));
		Collections.shuffle(mediaList);
		System.out.println(genericReflections(mediaList));
		

	}
	
	public static void funWithReflections() {
		try {
			// get our class
			Class clazz = Class.forName("com.revature.media.Media");
			System.out.println(clazz.getSimpleName());

			// print fields
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				System.out.println(f.getName() + " with a data type of " + f.getType());
			}

			// new instance of Book
			Class clazz2 = Class.forName("com.revature.media.Book");
			Book b1 = (Book) clazz2.newInstance();
			System.out.println(b1.toString());
			Field creator = clazz2.getDeclaredField("publisher");
			creator.setAccessible(true);
			creator.set(b1, "Michael Bay");
			
			System.out.println(b1.toString());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> T genericReflections(List<T> l) {
		for(T item : l) {
			if(item.getClass().getName().equals("com.revature.media.Book")) 
				return item;
			
		}
		return null;
	}

}
