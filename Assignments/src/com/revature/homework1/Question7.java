package com.revature.homework1;

import java.util.ArrayList;
import java.util.Comparator;


public class Question7 {
	
	
	public static void main(String[] args) {
		Question7Employee employee1 = new Question7Employee("Tim", "Retail", 28);
		Question7Employee employee2 = new Question7Employee("Jill", "Produce", 20);
		ArrayList<Question7Employee> staff = new ArrayList<Question7Employee>();
		staff.add(employee1);
		staff.add(employee2);
		
		for (int i = 0; i < staff.size();i++) {
			System.out.println("Without Comparator");
			System.out.println(staff.get(i).getName());
			System.out.println(staff.get(i).getDepartment());
			System.out.println(staff.get(i).getAge());
		}
		
		
		ArrayList.sort( staff , Question7Comparator());;
		for (int i = 0; i < staff.size();i++) {
			System.out.println("Without Comparator");
			System.out.println(staff.get(i).getName());
			System.out.println(staff.get(i).getDepartment());
			System.out.println(staff.get(i).getAge());
		}
		

		
		
		
	
	
	

}


	
}
