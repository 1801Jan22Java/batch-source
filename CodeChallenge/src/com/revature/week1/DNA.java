package com.revature.week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DNA {
	public final String FILE = "ValidMutations.txt";
	public ArrayList<String> mutations = new ArrayList<>();
	BufferedReader br = null;
	FileReader fr = null;
	private StringBuilder start;
	private StringBuilder end;
	
	
	public DNA(String s, String e) {
		super();
		
		start = new StringBuilder(s);
		end = new StringBuilder(e);
		fillBank();
		
	}
	public boolean checkSequence()
	{
		for (int i=0; i<end.length(); i++)
		{
			switch(end.charAt(i))
			{
				case 'A': break;
				case 'C': break;
				case 'G': break;
				case 'T': break;
				default:  System.out.println("invalid ending gene");return false;
			}
		}
		return true;
	}
	public void fillBank()
	{
		try 
		{
			fr = new FileReader(FILE);
			br = new BufferedReader(fr);

			String sCurrentLine;
			System.out.println("Printing contents of file");
			while ((sCurrentLine = br.readLine()) != null)			// while there is text
			{
				System.out.println(sCurrentLine);					//print the current line
				mutations.add(sCurrentLine);								//add the current line to the arraylist
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
	}
	
	public int getMutations()
	{
		int numMutations =0;
		for (int i=0; i<start.length(); i++)
		{
			if(!start.equals(end))
				{
					if (start.charAt(i)==end.charAt(i))
					{
						continue;
					}
					else
					{
						start.setCharAt(i,end.charAt(i));
						numMutations++;
						
						if (!mutations.contains(start.toString()))
						{
							return -1;
						}
						if(start.equals(end))
						{
							return numMutations;
						}
						
					}
				
				}
		}
		return numMutations;
	}
	
	
}
