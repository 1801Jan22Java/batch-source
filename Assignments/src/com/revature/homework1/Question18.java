package com.revature.homework1;

public abstract class Question18 {

	public boolean containsUppercase(String s) {

		return false;
	}

	public String toUppercase(String s) {

		return "";
	}

	public void stringToIntPlusTen(String s) {

	}
	
	public static void main(String[] args) {
		
		subClass s = new subClass();
		
		String test1 = "hello";
		if(s.containsUppercase(test1)) {
			System.out.println(test1+" contains an uppercase letter");
		}
		else System.out.println(test1+" doesn't contain an uppercase letter");
		
		System.out.println();
		
		String test2 = "I'm Tony Montana!";
		System.out.println(test2+" converted to uppercase is "+s.toUppercase(test2));
		
		System.out.println();
		
		String test3 = "163";
		System.out.println("adding 10 with valid input "+test3+" is");
		s.stringToIntPlusTen(test3);
		
		String test4 = "sgah";
		System.out.println("with invalid input "+test4+" is");
		s.stringToIntPlusTen(test4);
	}
}

class subClass extends Question18 {

	public boolean containsUppercase(String s) {

		String lower = s.toLowerCase();
		
		if(lower.equals(s)) {
			return false;
		}
		else return true;
	}

	public String toUppercase(String s) {

		return s.toUpperCase();
	}

	public void stringToIntPlusTen(String s) {

		if(s.matches("[0-9]+") && s.length()>0) {
			Double d = Double.parseDouble(s);
			System.out.println(d+10);
		}
		else System.out.println("invalid input");
	}
}
