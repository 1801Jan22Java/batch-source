package com.revature.homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Question20 {

	//string to hold the location of the file
	private static final String FILENAME = "C:\\Users\\omen\\Desktop\\GitRepo\\batch-source\\Data.txt";

	
	public static void main(String[] args) throws Exception {
		
		//bufferedreader reads text from character input stream
		//filereader reads character files
		BufferedReader br = null;
		FileReader fr = null;
		Scanner sc = new Scanner(":");

		try
		{
			//assigns the file location to the filereader
			//also assigns buffered reader the characters from the file
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			//assign delimiter to look for colon char and separates each element with a space instead
			String sCurrentLine;
			sc.useDelimiter(":");
			//loop reads each line into the sCurrentLine string until it hits a null character
			while ((sCurrentLine = br.readLine()) != null)
			{		
				//assigns the string object to the new string array separating each element with the delimiter
				//the name is the first two elements in the array
				//the age is the third element in the array
				//the state is the fourth element in the array
				String[] splitCurrentLine = sCurrentLine.split(":");
				System.out.println("Name: " + splitCurrentLine[0] + " " + splitCurrentLine[1]);
				System.out.println("Age: " + splitCurrentLine[2]);
				System.out.println("State: " + splitCurrentLine[3]);
				//when the while loop finishes the first iteration, it will read the next line 
				//and reassign the new elements to the already existing array
			}
			
		}
		//catches exception if the file doesn't exits
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(br != null)
					br.close();
				
				if(fr != null)
					fr.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		sc.close();
	}
}
