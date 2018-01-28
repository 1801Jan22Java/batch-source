package com.revature.homework1;

import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to Leonard's Assignment 1 driver");
		System.out.println("Questions will be run in order below.");
		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 1 Test
		 */
		Question1 q1 = new Question1();
		System.out.println("Question 1 - Bubble sort");
		System.out.println("Original array - {1,0,5,6,3,2,3,7,9,8,4}");
		int[] arr = new int[11];
		arr = q1.bubbleSort();

		System.out.print("Array: {");
		for (int i = 0; i < 10; i++) {
			if(i != 9)
				System.out.print(arr[i] + ", ");
			else
				System.out.println(arr[i] + "}");
		}

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 2 Test
		 */
		System.out.println("Question 2 - First 25 Fiboancci numbers ");
		Question2 q2 = new Question2();
		System.out.println("1, 1, ");
		for (int i = 3; i < 26; i++) {
			if (i % 5 == 4)
				System.out.println();

			if(i == 25)
				System.out.println(((Long) (q2.getNext())).toString());	
			
			else
				System.out.print(((Long) (q2.getNext())).toString() + ", ");

		}

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 3 Test
		 */

		System.out.println("Question 3 - String Reversal");

		System.out.print("First string: fluffy" + '\t');
		Question3 q3a = new Question3("fluffy");
		System.out.println(q3a.getReversed());

		q3a.setOriginal("Revature");
		System.out.print("Second string: Revature" + '\t');
		System.out.println(q3a.getReversed());

		q3a.setOriginal("Plethora");
		System.out.print("Third string: Plethora" + '\t');
		System.out.println(q3a.getReversed());

		q3a.setOriginal("United States");
		System.out.print("Fourth string: United States" + '\t');
		System.out.println(q3a.getReversed());

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 4 testing
		 */

		System.out.println("Question 4 - N factorial");
		System.out.println("Computing 5!");
		Question4 q4 = new Question4(5);
		System.out.println("Result is " + q4.getResult());
		System.out.println("Computing 8!");
		q4.setN(8);
		System.out.println("Result is " + q4.getResult());
		System.out.println("Computing 10!");
		q4.setN(10);
		System.out.println("Result is " + q4.getResult());

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 5 testing
		 */

		System.out.println("Question 5 - Custom Substring");
		
		System.out.println("String = 'Revature' , idx = 4");
		Question5 q5 = new Question5("Revature", 4);
		System.out.println("Result is: " + q5.doThing());

		System.out.println("String = 'I love core Java', idx = 11");
		q5.setOriginal("I love core java");
		q5.setIdx(11);
		System.out.println("Result is: " + q5.doThing());

		System.out.println("String = 'I wish I was in Texas' , idx = 15");
		q5.setOriginal("I wish I was in Texas");
		q5.setIdx(15);
		System.out.println("Result is: " + q5.doThing());

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 6 testing
		 */

		System.out.println("Question 6 - Evaluating parity");
		System.out.println("1st number is 14");
		Question6 q6 = new Question6(14);
		if (q6.isEven())
			System.out.println(q6.getNum() + " is even");

		else
			System.out.println(q6.getNum() + " is odd");

		System.out.println("2nd number is 17");
		q6.setNum(17);
		if (q6.isEven())
			System.out.println(q6.getNum() + " is even");

		else
			System.out.println(q6.getNum() + " is odd");

		System.out.println("3nd number is 8");
		q6.setNum(8);
		if (q6.isEven())
			System.out.println(q6.getNum() + " is even");

		else
			System.out.println(q6.getNum() + " is odd");

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 7 testing
		 */

		System.out.println("Question 7 - Sorting employees");
		System.out.println("Employee 1 - 'John Doe', 'Development', 27 years old");
		System.out.println("Employee 2 - John Doe, 'Development, 22 years old");
		System.out.println("Employee 3 - John Doe, 'Accounting', 25 years old");
		System.out.println("Employee 4 - 'Alexander Hamilton', 'Legal', 261 years old");
		System.out.println("Employee 5 - 'Issac Asimov, 'Media', '98 years old'");

		Question7 q7a = new Question7("John Doe", "Development", 27);
		Question7 q7b = new Question7("John Doe", "Development", 22);
		Question7 q7c = new Question7("John Doe", "Accounting", 25);
		Question7 q7d = new Question7("Alexander Hamilton", "Legal", 261);
		Question7 q7e = new Question7("Issac Asimov", "Media", 98);
		System.out.println();
		
		System.out.println("Comparing Employee 1 to Employee 2");
		if (q7a.compareTo(q7b) > 0)
			System.out.println(q7a.getName() + " is after " + q7b.getName());
		else if (q7a.compareTo(q7b) < 0)
			System.out.println(q7a.getName() + " is before " + q7b.getName());
		else
			System.out.println(q7a.getName() + " is equal to " + q7b.getName());

		System.out.println("Comparing Employee 1 to Employee 4");
		if (q7a.compareTo(q7d) > 0)
			System.out.println(q7a.getName() + " is after " + q7d.getName());
		else if (q7a.compareTo(q7d) < 0)
			System.out.println(q7a.getName() + " is before " + q7d.getName());
		else
			System.out.println(q7a.getName() + " is after " + q7d.getName());

		System.out.println("Comparing Employee 3 to Employee 5");
		if (q7c.compareTo(q7e) > 0)
			System.out.println(q7c.getName() + " is after " + q7e.getName());
		else if (q7c.compareTo(q7e) < 0)
			System.out.println(q7c.getName() + " is before " + q7e.getName());
		else
			System.out.println(q7d.getName() + " is after " + q7e.getName());

		System.out.println("Comparing Employee 4 to Employee 5");
		if (q7d.compareTo(q7e) > 0)
			System.out.println(q7d.getName() + " is after " + q7e.getName());
		else if (q7d.compareTo(q7e) < 0)
			System.out.println(q7d.getName() + " is before " + q7e.getName());
		else
			System.out.println(q7d.getName() + " is after " + q7e.getName());

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		/*
		 * Question 8 testing
		 */

		System.out.println("Question 8 - palindromes");
		Question8 q8 = new Question8();
		q8.doThing();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Question 9 - Prime numbers between 1 and 100");
		Question9 q9 = new Question9();
		q9.getPrimes();
		q9.printPrimes();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Question 10 - ternary operators");
		System.out.println("Starting with numbers 8 and 5");
		int num1 = 8;
		int num2 = 5;

		Question10 q10 = new Question10(8, 5);
		int result = q10.doThing();
		System.out.println("Determined that " + result + " is less than " + ((num1 == result) ? num2 : num1));

		System.out.println("Comparing 1 and 7");
		num1 = 1;
		num2 = 7;
		q10.setNum1(num1);
		q10.setNum2(num2);
		result = q10.doThing();
		System.out.println("Determined that " + result + " is less than " + ((num1 == result) ? num2 : num1));

		System.out.println("Comparing 11 and 7000");
		num1 = 11;
		num2 = 7000;
		q10.setNum1(num1);
		q10.setNum2(num2);
		result = q10.doThing();
		System.out.println("Determined that " + result + " is less than " + ((num1 == result) ? num2 : num1));

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Question 11 - setting floats to 3.14 and 2.71");
		com.revature.dummyPackage.FloatArithmatic floats = new com.revature.dummyPackage.FloatArithmatic(3.14f, 2.71f);
		Question11 q11 = new Question11();
		q11.getFloats(floats);

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Question 12 - Even numbers between 1 and 100");
		Question12 q12 = new Question12();
		q12.doThing();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Quesiton 13 - Displaying Triangle");
		Question13 q13 = new Question13();
		q13.doThing();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Question 14 - Switch statement cases");
		Question14 q14 = new Question14(1, 144.0);
		q14.doThing();
		q14.setCaseNum(2);
		q14.doThing();
		q14.setCaseNum(3);
		q14.doThing();
		/*
		 * I am not outputting anything to the console here because the printing is done
		 * by the Question14 object in doThing()
		 */

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		System.out.println("Question 15 - Basic arithmatic through implemented interface");
		Question15 q15 = new Question15(81, 9);
		System.out.println("1st operation -> 81 + 9 = " + q15.addition());
		System.out.println("2nd operation -> 81 - 9 = " + q15.subtraction());
		System.out.println("3rd operation -> 81 * 9 = " + q15.multiplication());
		System.out.println("Final operation -> 81 / 9 = " + q15.division());

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");
		/*
		System.out.println("Question 16 - Number of characters for a string input");
		String str = args[1];
		String str1 = args[2];
		String str2 = args[3];
		System.out.println("Strings are: " + str + " ,\t" + str1 + " , \t" + str2);
		Question16 q16 = new Question16(str);
		q16.doThing();
		q16.setStr(str1);
		q16.doThing();
		q16.setStr(str2);
		q16.doThing();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");
		*/
		System.out.println("Quesiton 17 - calculating accrued intrest");
		Question17 q17 = new Question17();
		q17.doThing();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");

		String suffix0 = " does not have uppercase letters";
		String suffix1 = " does have uppercase letters";
		String string = "virginia";
		
		System.out.println("Question 18 - abstract class implementation");
		System.out.println("Starting with string 'virginia' ");

		Question18 q18 = new Question18(string);
		System.out.println((q18.findUpper()) ? (string.concat(suffix0)) : (string.concat(suffix1)));
		System.out.println("Uppercase version of " + string + " is " + q18.allCaps());
		System.out.println("Parsing " + q18.getStr() + " as integer, result is: ");
		q18.stringToInt();

		q18.setStr("1234");
		System.out.println("Parsing " + q18.getStr() + " as integer, result is: ");
		q18.stringToInt();

		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Question 19 - ArrayLists");
		Question19 q19 = new Question19();
		q19.doThing();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Quesiton 20 - file I/O");
		
		try {
			Question20 q20 = new Question20();
			q20.doThing();
		} catch(FileNotFoundException f) {
			System.out.println("Could not find file Data.txt");
			f.printStackTrace();
		}
		
		System.out.println("--------------------------------------------------------");
		System.out.println("********************************************************");
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Completed execution of Questions. Program Terminating");
	}

}
