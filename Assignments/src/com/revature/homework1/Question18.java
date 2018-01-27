package com.revature.homework1;

public class Question18 {
	
	public static void main(String [] args) {
		ImplementStringManipulation strMan = new ImplementStringManipulation();
		
		System.out.println(strMan.hasUpper("helllllOooooo"));
		System.out.println(strMan.hasUpper("String"));
		System.out.println(strMan.hasUpper("trinG"));
		System.out.println(strMan.hasUpper("string"));
		
		System.out.println(strMan.toUpper("domo"));
		System.out.println(strMan.toUpper("doMo"));
		System.out.println(strMan.toUpper("domO"));
		System.out.println(strMan.toUpper("Domo"));
		
		strMan.convertAndAdd("10");
		strMan.convertAndAdd("-9");
		strMan.convertAndAdd("15");
	}

}
