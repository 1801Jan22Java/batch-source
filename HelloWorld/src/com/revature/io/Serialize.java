package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.media.*;

public class Serialize {

	public static void main(String[] args) {
		
		Book b1 = new Book("Anthony Burgess", "A Clockwork Orange", 1962, "social commentary");
		// Need to create the file first before writing to it. Java will not create file for you.
		String filename = "src/serializedThings/MediaDemo";
		writeObject(filename, b1);
		
		readObject(filename);
		
		//Movie has not implemented Serializable, but its superclass, Media, has. 
		//This is to check is it is possible to read the object
		Movie m1 = new Movie("Stanley Cooper", "A ClockworkOrange", 1971, "social commentary");
		writeObject(filename, m1);
		readObject(filename);
	}
	
	static void writeObject(String filename, Serializable s) {
		// try with resources
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(s);
			System.out.println("Wrote to file: " + s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Serializable readObject(String filename) {
		
		Serializable s = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			s = (Serializable) ois.readObject();
			System.out.println("Read object: " + s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
}
