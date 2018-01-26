package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize {
	
	public static void main(String[] args) {
		
	}
	
	static void writeObject(String filename,Serializable s) {
		//try with resources 
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			
		}catch(FileNotFoundException e) {
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	
	
	// relative path starts from where we are not having to add the C:\\namespace info

}
	static  Serializable readObject(String filename) {
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
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
