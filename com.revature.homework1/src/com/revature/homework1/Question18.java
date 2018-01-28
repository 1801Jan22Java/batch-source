package com.revature.homework1;

public class Question18 {

	public static void main(String[] args)
	{
		//instantiate demExtaStrings and call the functions created by the 
		//abstract class demStrings
		demExtraStrings theBigOne = new demExtraStrings();
		
		theBigOne.upperCheck("Hello World");
		theBigOne.returnsString("Hello WOrLD");
		theBigOne.addTen("I'm not 8 I am...");
		
		
	}
}

abstract class demStrings
{
	//creates a sort of contract where demExtraStrings has to make an
	//implementation of each abstract method
	abstract boolean upperCheck(String theString);
	abstract String returnsString(String theArg);
	abstract void addTen(String theTen);
}

class demExtraStrings extends demStrings
{
	//constructor
	public demExtraStrings() {}
	
	//checks if string passed through has an uppercase letter
	public boolean upperCheck(String theString)
	{
		for (int i=0; i < theString.length(); i++)
	    {
	        if (Character.isLowerCase(theString.charAt(i)))
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	//makes all letters in the passed string uppercase
	public String returnsString(String theArg)
	{
		theArg = theArg.toUpperCase();
		return theArg;
	}
	
	//adds the string "10" to the end of a string
	public void addTen(String theTen)
	{
		System.out.println(theTen + "10");
	}
}
