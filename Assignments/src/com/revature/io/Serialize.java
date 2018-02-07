package com.revature.io;

import java.io.*;

import com.revature.collections.*;

public class Serialize {
	
	public static void main(String[] args) {
		
		Book b1 = new Book(1962,"commentary","A Clockwork Orange","Anthony Burgess");
		String filename = "src/serializeThings/MediaDemo";
		writeObject(filename,b1);
		Book b2 = null;
		b2 = (Book)readObject(filename);
		
		Movie m1 = new Movie(1975,"commentary","A Clockwork Orange","Stanley Kubrick");
		m1.setMovieID(1208934);
		writeObject(filename,m1);
		readObject(filename);
	}
	
	static void writeObject(String filename, Serializable s) {
		//try with resources
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(s);
			System.out.println("wrote to file: " + s.toString());
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static Serializable readObject(String filename) {
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			s = (Serializable) ois.readObject();
			System.out.println("read object: " + s.toString());
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
