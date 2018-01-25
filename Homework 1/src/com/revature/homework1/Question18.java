//Done!

package com.revature.homework1;

//Create the abstract class with the abstract methods, not implementing them yet.
abstract class Question18Super{
	public abstract boolean hasUpper(String str);
	public abstract String toUpper(String str);
	public abstract int toInt(String str);
}

public class Question18 extends Question18Super{
	
	//Implement the three abstract methods from Question18Super here
	
	//Check whether the string literal converted to all lower case 
	//is the same as the original string. If yes, there are no upper case,
	//so return false. If not, return true.
	public boolean hasUpper(String str)
	{
		if(str.toLowerCase().equals(str)) {
			return false;
		}
		return true;
	}
	
	public String toUpper(String str) {
		//Simply return the String converted to upper case using String's method
		return str.toUpperCase();
	}
	
	public int toInt(String str) {
		int result = 0;
		for(int i = str.length()-1; i >= 0; i--) {
			//Add each digit to the result, multiplying by the appropriate powers of 10
			//First factor = the String parsed into an int using Integer's static method
			//Second factor = using Math's static method to raise 10 to the appropriate power.
			result += Integer.parseInt(String.valueOf(str.charAt(i)))*((int)(Math.pow(10, str.length()-1-i)));
		}
		return result+10;
	}
	
	public static void main(String[] args) {
		Question18 q18 = new Question18();
		
		String str1 = "cAtS";
		String str2 = "cats";
		String str3 = "10589";
		
		System.out.println(str1 + " has uppercase: " + q18.hasUpper(str1));
		System.out.println(str2 + " has uppercase: " + q18.hasUpper(str2));
		
		System.out.println(str1 + " converted to uppercase: " + q18.toUpper(str1));
		System.out.println(str2 + " converted to uppercase: " + q18.toUpper(str2));
		
		System.out.println(str3 + " converted to an int and added to 10 = " + q18.toInt(str3));
	}
}
