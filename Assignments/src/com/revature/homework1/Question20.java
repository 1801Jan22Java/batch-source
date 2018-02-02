package com.revature.homework1;
import java.io.*;
import java.util.ArrayList;
public class Question20 {
	
	private static String FILE = "Data.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> list = new ArrayList<>(); 

		try 
		{
			fr = new FileReader(FILE);
			br = new BufferedReader(fr);

			String sCurrentLine;
			System.out.println("Printing contents of file");
			while ((sCurrentLine = br.readLine()) != null)			// while there is text
			{
				System.out.println(sCurrentLine);					//print the current line
				list.add(sCurrentLine);								//add the current line to the arraylist
			}
			System.out.println();
		}
		catch (FileNotFoundException e) 						//catch any exceptions
		{

			e.printStackTrace();

		} 
		catch (IOException e) 
		{

			e.printStackTrace();

		} 
		finally 											
		{

			try {

				if (br != null)				//close the buffered reader and file reader if open
					br.close();

				if (fr != null)
					fr.close();

			} 
			catch (IOException ex) 			//catch exceptions if thrown
			{

				ex.printStackTrace();

			}
		}

		for(int i = 0; i< list.size(); i++)		//go through the list
		{
			String[] words = list.get(i).split(":"); //split each line along : and print the information
			System.out.println("Name: " + words[0]+ " "+ words[1]);
			System.out.println("Age: "+ words[2]);
			System.out.println("State: " + words[3]+ " State");
			System.out.println();
		}

	}

}
