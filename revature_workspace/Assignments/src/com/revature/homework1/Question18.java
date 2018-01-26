package com.revature.homework1;
/*
Q18. Write a program having a concrete ;subclass that inherits three abstract methods from a superclass. 
 Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
3. 	Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
 */

abstract class Q18AbstractParentClass
{
	abstract boolean hasUppercase(String str);
	abstract String convertToUpper(String str);
	abstract int convertToInt(String str); 


}

class Q18ConcreteChildClass extends Q18AbstractParentClass
{

	@Override
	public boolean hasUppercase(String str) {
		boolean hasUpper=false;
		char[] charArr=str.toCharArray();
		for( char a : charArr)
		{
			if(Character.isUpperCase((Character)a))
			{
				hasUpper= true;
				break;
			}
			else
			{
				hasUpper=false;
			}
		}

		return hasUpper;
	}
	
	
	@Override
	 public String convertToUpper(String str) {
		String result="";
		char[] charArr=str.toCharArray();
		for(char a : charArr)
		{
			if(Character.isLowerCase((Character)a))
			{
				result+=Character.toUpperCase((Character)a);
				
			}
			else
			{
				result+=a;
			}
		}
		return result;
	}
	
	
	@Override
	public int convertToInt(String str) {
		int result = 10;
		char[] charArr=str.toCharArray();
		for(char a: charArr)
		{
			result+=Character.getNumericValue(a);
		}
		
		return  result;

	}
}

public class Question18 {
	public static void main(String []args)
	{
		Q18ConcreteChildClass c= new Q18ConcreteChildClass();
		
		System.out.println(c.convertToUpper("Hello"));
		
		System.out.println(c.hasUppercase("Hello"));
		System.out.println(c.convertToInt("Hello"));
		
	}
	

}
