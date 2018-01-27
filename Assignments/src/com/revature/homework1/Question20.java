package com.revature.homework1;

import java.io.*;
import java.util.Arrays;

public class Question20 {
	
	public static void readTextFile(String fileName) {
		
		// Reference one line at a time
		String line = null;
		
		try {
			FileReader fileReader = new FileReader(fileName);
			
			// Always wrap a FileReader with BufferedReader because one character at a time is costly
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			while((line = bufferReader.readLine()) != null) {
				String[] strOutput = line.split(":");
				System.out.println("Name: " + strOutput[0] + " " + strOutput[1]);
				System.out.println("Age: " + strOutput[2] + " years");
				System.out.println("State: " + strOutput[3]);
				System.out.println();
			}
			
			// Always make sure to close the file.
			bufferReader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Unable to open '" + fileName + "'");
		} catch(IOException e) {
			System.out.println("Error reading '" + fileName + "'");
			e.printStackTrace();
		} 
		
	}
	
}
