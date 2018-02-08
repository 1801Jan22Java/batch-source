package com.revature.reflection;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) 
	{
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("S.E. Hilton", "The Outsiders", 1967, "fiction", "Viking Press, Dell Publishing");
		Book b2 = new Book("Ray Bradbury", "The Illustrated Man", 1951, "fiction", "Doubleday & Company" );
		Movie m1 = new Movie("Ron Howard", "A Beautiful Mind", 2001, "biographical drama");
		Movie m2 = new Movie("Woody Allen", "Midnight in Paris", 2011, "Comedy, Fantasy, Romance");
		Collections.addAll(mediaList, b1, b2, m1, m2);
		Collections.shuffle(mediaList);
		genericReflections(mediaList);

		//will return null
		Collections.addAll(mediaList, m1, m2);
		genericReflections(mediaList);


		reflectionPractice();
	}

	public static <T> T genericReflections(List<T> l)
	{
		for(T item : l)
		{
			if(item.getClass().getName().equals("com.revature.media.Book"))
				return item;
		}
		return null;
	}

	public static void reflectionPractice()
	{
		try {
			Class clazz = Class.forName("com.revature.media.Media");

			//getSimpleName() returns just the name of the class without the package name
			//getName() returns the package name and the class name together
			//there are other methods, like returning the methods, or fields, ...
			System.out.println(clazz.getName());

			//even though the fields in Media are protected, you are still able to 
			//display them using reflection
			Field[] fields = clazz.getDeclaredFields();
			for(Field f : fields)
				System.out.println(f.getName()+" with a datatype of "+f.getType());

			//new instance of Book
			Class clazz2 = Class.forName("com.revature.media.Book");
			Book b1 = (Book) clazz2.newInstance();
			System.out.println((b1));

			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b1, "Lianna la Havas");
			System.out.println(b1);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
