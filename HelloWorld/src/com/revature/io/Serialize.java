package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.media.Book;
import com.revature.media.Movie;

public class Serialize {

	public static void main(String[] args) {
		
		Book b1 = new Book("Anthony Burgess", "A Clockwork Orange", 1962, "social commentary");
		String filename = "src/serializedThings/MediaDemo";
		//writeObject(filename, b1);	// for this to run, had to write click new file in the project folder
									// write the path in the first line and then MediaDemo at bottom
									 
		//readObject(filename);
		
		Movie m1 = new Movie("Stanley Kubrick", "A Clockwork Orange", 1971, "social commentary");
		//(filename, m1);
		
		readObject(filename);		// note, only reading and writing one object at a time since overriding
									// can serialize a collection of objects
		
	}
	
	// relative path: part of what we want, not the full path name
	// could use generics here but not necessary because works with any object, so don't lose type safety
	static void writeObject(String filename, Serializable s) {
		// try with resources
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(s);
			System.out.println("wrote to file: " + s.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Serializable readObject(String filename) {
		Serializable s = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			s = (Serializable) ois.readObject();
			System.out.println("read object: " + s.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
