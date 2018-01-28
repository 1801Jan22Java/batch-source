package com.revature.homework1;

import java.util.ArrayList;

public class Question7Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Question7 e1 = new Question7("Micheal Smith", 23, "Finance");
		System.out.println("My name is: " + e1.getName() + " and I am " + e1.getAge() + " and I work in the " + e1.getDepartment() + " department.");
		Question7 e2 = new Question7("Thomas Moore", 45, "Computer");
		System.out.println("My name is: " + e2.getName() + " and I am " + e2.getAge() + " and I work in the " + e2.getDepartment() + " department.");
	}

}
