package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import com.revature.collections.Book;
import com.revature.collections.Movie;
import com.revature.media.Media;



public class Serialize {
	
	public static void main(String[] args){
		
		Book b1 = new Book("Anthony Burgess","A Clockwork Orange",1962,"social commentary");
		String filename = "src/serializedThings/MediaDemo";
		//writeObject(filename,b1);
		//readObject(filename);
		
		Movie m1 = new Movie("Stanley Kubrick","A Clockwork Orange",1971,"social commentary");
		//writeObject(filename,m1);
		readObject(filename);
		
		
	}
	
	static void writeObject(String filename, Serializable s){
		//try with resources
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(s);
			System.out.println("wrote to file: "+s.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// Experiment with FileOutputStream and objects
//		try(FileOutputStream fos=new FileOutputStream(filename)){
//			fos.write((int) s);
//			System.out.println("Wrote to file: "+s.toString());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	

	
	static Serializable readObject(String filename){
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			s = (Serializable) ois.readObject();
			System.out.println("read object: "+s.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
