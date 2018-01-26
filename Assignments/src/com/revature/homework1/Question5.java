package com.revature.homework1;
/**
 * Substring
 * @author Nabeela Hassan
 *
 */
public class Question5 {
 
	
	
	/**
	 * 
	 * @param str String used to create substring 
	 * @param index place to end the substring (not inclusive) 
	 * @return substring
	 */
	private static String substring(String str, int index)
	{
		String substring = "";
		for(int i = 0; i<index;i++)				//loop through the String and stop at the index 
		{
			substring+=(str.charAt(i));			//add the character at the current index to the substring
		}
		return substring;						// return the substring
	}
	
	public static void main(String[] args) {
		String word = "Greetings";
		int index = 5;
		System.out.println("Original: ");
		System.out.println("Substring: " + substring(word, index));

	}
}
