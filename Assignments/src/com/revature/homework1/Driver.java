package com.revature.homework1;


public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to Leonard's Assignment 1 driver");
		System.out.println("Questions will be run in order below.");
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
		for(int i = 0; i < 10; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("--------------------------------------------------------");
		
		/*
		 * Question 2 Test
		 */
		System.out.println("Question 2 - First 25 Fiboancci numbers ");
		Question2 q2 = new Question2();
		System.out.println("1, 1, ");
		for(int i = 3; i < 26; i++) {
			if(i % 5 == 0)
				System.out.println("");
			
			System.out.print(((Long)(q2.getNext())).toString() + ", "); 
			
		}
		
		System.out.println("--------------------------------------------------------");
		
		/*
		 * Question 3 Test
		 */
		
		System.out.println("Question 3 - String Reversal");
		
		System.out.print("First string: fluffy" + '\t');
		Question3 q3a = new Question3("fluffy");
		System.out.println(q3a.getReversed());
		
		Question3 q3b = new Question3("Revature");
		System.out.print("Second string: Revature" + '\t');
		System.out.println(q3b.getReversed());
		
		Question3 q3c = new Question3("Plethora");
		System.out.print("Second string: Plethora" + '\t');
		System.out.println(q3c.getReversed());
		
		Question3 q3d = new Question3("United States");
		System.out.print("Second string: United States" + '\t');
		System.out.println(q3d.getReversed());
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Question 4 - N factorial");
		System.out.println("Computing 5!");
		Question4 q4 = new Question4(5);
		System.out.println("Result is " + q4.getResult());
		System.out.println("Computing 10!");
		q4.setN(10);
		System.out.println("Result is " + q4.getResult());
		System.out.println("Computing 20!");
		q4.setN(20);
		System.out.println("Result is " + q4.getResult());
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Question 5 - Custom Substring");
		System.out.println("String = 'Revature' , idx = 4");
		Question5 q5 = new Question5("Revature", 4);
		System.out.println("Result is: " + q5.doThing());
		
		System.out.println("String = 'I love core Java', idx = 10");
		q5.setOriginal("I love core java");
		q5.setIdx(10);
		System.out.println("Result is: " + q5.doThing());
		
		System.out.println("String = 'I wish I was in Texas' , idx = 15");
		q5.setOriginal("I wish I was in Texas");
		q5.setIdx(15);
		System.out.println("Result is: " + q5.doThing());
		
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Question 6 - Evaluating parity");
		System.out.println("1st number is 14");
		Question6 q6 = new Question6(14);
		if(q6.isEven())
			System.out.println(q6.getNum() + " is even");
		
		else
			System.out.println(q6.getNum() + " is odd");
		
		System.out.println("2nd number is 17");
		q6.setNum(17);
		if(q6.isEven())
			System.out.println(q6.getNum() + " is even");
		
		else
			System.out.println(q6.getNum() + " is odd");
		
		System.out.println("3nd number is 8");
		q6.setNum(8);
		if(q6.isEven())
			System.out.println(q6.getNum() + " is even");
		
		else
			System.out.println(q6.getNum() + " is odd");
		
		
		System.out.println("--------------------------------------------------------");
		
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
		
		
		System.out.println("Comparing Employee 1 to Employee 2");
		if(q7a.compareTo(q7b) > 0)
			System.out.println(q7a.getName() + " is after " + q7b.getName());
		else if (q7a.compareTo(q7b) < 0)
			System.out.println(q7a.getName() + " is before " + q7b.getName());
		else
			System.out.println(q7a.getName() + " is equal to " + q7b.getName());
		
		System.out.println("Comparing Employee 1 to Employee 4");
		if(q7a.compareTo(q7d) > 0)
			System.out.println(q7a.getName() + " is after " + q7d.getName());
		else if (q7a.compareTo(q7d) < 0)
			System.out.println(q7a.getName() + " is before " + q7d.getName());
		else
			System.out.println(q7a.getName() + " is after " + q7d.getName());
		
		System.out.println("Comparing Employee 4 to Employee 5");
		if(q7d.compareTo(q7e) > 0)
			System.out.println(q7d.getName() + " is after " + q7e.getName());
		else if (q7d.compareTo(q7e) < 0)
			System.out.println(q7d.getName() + " is before " + q7e.getName());
		else
			System.out.println(q7d.getName() + " is after " + q7e.getName());
		
		
		
	}

}
