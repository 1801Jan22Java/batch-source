package com.revature.homework1;

public class Question18 {

	public static void main(String[] args) {
		SubClass sub = new SubClass();
		String word = "FlorIDa", num = "12345";
		if(sub.isAllUppercase(word))
		{
			System.out.println(word + " is all upper case");
		}
		else
		{
			System.out.println(word + " is not all upper case");
		}
		
		System.out.println("Original: "+ word);
		System.out.println("All Caps: " + sub.convertToUppercase(word));
		
		int sum = Integer.parseInt(num)+10;
		System.out.println("The sum of " + num+ " and 10 equals " + sum);
	}

}
