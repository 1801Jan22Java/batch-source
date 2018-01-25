//Done!

package com.revature.homework1;
import java.io.*;
import java.util.*;

public class Question20 {
	public static void main(String[] args) {
		Scanner sc;
		try {
			sc = new Scanner(new File("src/com/revature/homework1/Data.txt"));
			
			//Create a String to hold the next line
			String str;
			String[] data = new String[4];
			while(sc.hasNextLine()) {
				str = sc.nextLine();
				
				//Parse the line, splitting it into an Array of Strings delimited by :
				data = str.split(":");
						
				//Print the name first
				System.out.println("Name: " + data[0] + " " + data[1]);
				
				//Print the age
				System.out.println("Age: " + data[2] + " years");
				
				//Finally print the state
				System.out.println("State: " + data[3] + " State");
				
				System.out.println();
			}
		} catch (FileNotFoundException f) {
			//If the file is not found, this message will be printed instead.
			System.out.println("Where's the file? D:");
		}
		
	}
}
