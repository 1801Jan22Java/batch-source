package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.media.*;

public class Serialize implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4755131924146081581L;

	public static void main(String[] args)
	{
		Book b1 = new Book("Jimmy John", "Down with the Joneses", 2018, "Commedy", "plubsiher");
		String filename = "src/serializedThings/MediaDemo";
		writeObject(filename, b1);
		readObject(filename);
		
		Movie m = new Movie("You and I", "William", 2012, "Drama");
		m.setMovieID(32423421);
		writeObject(filename, m);
		readObject(filename);
		
		//if a file is not serialized, it will not be written to a file.
	}
	
	//Using a relative path means, using a path relative to the 
	//directory or folder you are in.
	static void writeObject(String filename, Serializable s)
	{
		//try with resource
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			oos.writeObject(s);
			System.out.println("Wrote to file: "+s.toString());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	static Serializable readObject(String filename)
	{
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{
			s = (Serializable) ois.readObject();
			System.out.println("Read object: "+s.toString());
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}
}
