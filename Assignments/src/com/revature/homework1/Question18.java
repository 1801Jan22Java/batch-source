package com.revature.homework1;

/*
 * Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  
 * Provide the following three implementations in the subclass corresponding to the abstract methods 
 * in the superclass:
 * 1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
 * 2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
 * 3. 	Convert the input string to integer and add 10, output the result to the console.
 * Create an appropriate class having a main method to test the above setup.

 */

public class Question18 {

	public static void main(String[] args) {
		SubClass sub = new SubClass();
		String str;
		
		str = "This is a string";
		System.out.println("Does \"" + str + "\" contain an uppercase character? " + sub.hasUppercase(str));
		System.out.println("When you capitalize all charcters in \"" + str + "\" it looks like \n\"" +
							sub.toUpperCase(str) + "\"");
		sub.printAsInt(str);
		
		System.out.println();
		
		str = "there are no uppercase characters in this string";
		System.out.println("Does \"" + str + "\" contain an uppercase character? " + sub.hasUppercase(str));
		System.out.println("When you capitalize all charcters in \"" + str + "\" it looks like \n\"" +
							sub.toUpperCase(str) + "\"");
		sub.printAsInt(str); 
		
		System.out.println();
		
		str = "2354";
		System.out.println("Does \"" + str + "\" contain an uppercase character? " + sub.hasUppercase(str));
		System.out.println("When you capitalize all charcters in \"" + str + "\" it looks like \n\"" +
							sub.toUpperCase(str) + "\"");
		sub.printAsInt(str);
		
		str = "2354k";
		System.out.println("Does \"" + str + "\" contain an uppercase character? " + sub.hasUppercase(str));
		System.out.println("When you capitalize all charcters in \"" + str + "\" it looks like \n\"" +
							sub.toUpperCase(str) + "\"");
		sub.printAsInt(str);

	}

}
