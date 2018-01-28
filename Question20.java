package com.revature.homework1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {
	public String toString() {
		return "Name:  \n" +  "Age:  \n" + "State:  \n";
		
	}

	public static void main(String[] args) throws IOException {
		
		
		int ch;
		
		//check to see if the file can be read
		FileReader fi = null;
		try {
			fi=new FileReader("C:\\Users\\HP-\\Documents\\Data.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}

		//read the whole file
		while((ch=fi.read())!=-1)
			System.out.println((char) ch);
		
		
		//close the file
	fi.close();
	

	}
}

