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
		
		Book b1 = new Book ("Anthony Burgess", "A Clockwork Orange", 1962, "Social Commentary");
		String fileName = "src/serializedThings/MediaDemo";
		
		//Does not create file automatically if it does not yet exist
		//Reflection happens when it decides what to serialize
		writeObject(fileName, b1);
		
		//Class and ALL of its parent classes whose fields we use must implement Serializable
		readObject(fileName);
		
		System.out.println();
		
		Movie m1 = new Movie("Stanley Kubrick", "A Clockwork Orange", 1971, "Social Commentary");
		m1.setMovieId(1);
		//Despite Movie not being Serializable, it works because Media is Serializable
		//If we give Movie another field, it also becomes Serializable
		//Any transient fields will get written, but it WON'T get read back in.
		//Transient fields don't get serialized
		writeObject(fileName, m1);
		readObject(fileName);
		
		
	}
	
	//Using a relative path for fileName (as opposed to absolute path)
	static void writeObject(String fileName, Serializable s) {
		//Try with resources
		//Since we're serializing an object, we want to use ObjectOutputStream
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(s);
			System.out.println("Wrote to file: " + s.toString());
			
		//The more specific exception, so it goes before IOException.
		//Usually want to handle it in a different way if a different catch block is used
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static Serializable readObject(String fileName) {
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			s = (Serializable) ois.readObject();
			System.out.println("Read object from file: " + s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
}
