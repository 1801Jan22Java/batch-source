package com.revature.homework1;


/*
 * Q3. Reverse a string without using a 
 * temporary variable.  Do NOT use reverse() 
 * in the StringBuffer or the StringBuilder APIs.
 * */
public class Question3 {
	
	/*
	 * method reverseAString(String a) takes in a string and returns
	 * a string (a).  Iterates through the length of String a and adds the 
	 * last element of String a and adds it to the beginning String result,
	 * and adds each character of the decreasing index of a
	 *  to each increasing index of String result.  
	 * 
	 * @param String a
	 * @return String result
	 * */
	public static String reverseAString(String a)
	{
		String result = "";
		for(int i=0;i<a.length();i++)
		{
			result+=a.charAt(a.length()-1-i);
		}
		return result;
	}
	
	public static void main(String [] args)
	{
		String reversed = reverseAString("wolf");
		String reversed2 = reverseAString("evil");
		System.out.println(reversed);
		System.out.println(reversed2);
	}

}
