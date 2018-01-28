package com.revature.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Question20 {
	public static void readTheData() {
		try {
			// set filename
			File file = new File("Q20Data.txt");
			String line;
			String[] words;
			// open new buffered reader (for readLine) containing fileReader of file
			BufferedReader buffRead = new BufferedReader(new FileReader(file));
			// for each line in file that can be read
			while ((line = buffRead.readLine()) != null) {
				// tokenize the line
				words = line.split(":");
				// print out the data in the specified format
				System.out.println("Name: " + words[0] + " " + words[1]);
				System.out.println("Age: " + words[2]);
				System.out.println("State: " + words[3] + "\n");
			}
			// close the bufferedStream
			buffRead.close();
			// catch those checked exceptions
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
