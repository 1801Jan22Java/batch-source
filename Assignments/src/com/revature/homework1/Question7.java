package com.revature.homework1;
/*
 * Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class Question7 {
	public static void main(String[] args) {
		Employee empl1 = new Employee("Bob", "Computer", 30);
		Employee empl2 = new Employee("Andy", "Math", 40);
		
		System.out.println(compareEmpl(empl1, empl2) + "\n");
		
		empl1 = new Employee("Andy", "Math", 40);
		empl2 = new Employee("Andy", "Math", 40);
		
		System.out.println(compareEmpl(empl1, empl2) + "\n");
		
		
		empl1 = new Employee("Andy", "Computer", 40);
		empl2 = new Employee("Andy", "Math", 40);
		
		System.out.println(compareEmpl(empl1, empl2) + "\n");
		
		empl1 = new Employee("Andy", "Math", 20);
		empl2 = new Employee("Andy", "Math", 30);
		
		System.out.println(compareEmpl(empl1, empl2) + "\n");
	}
	
	public static String compareEmpl(Employee empl1, Employee empl2) {
		EmployeeComparator eComp = new EmployeeComparator();
		int result = eComp.compare(empl1, empl2);
		if (result == 0) {
			return empl1.toString() + " is equal to " + empl2.toString();
		}
		else if (result >= 1) {
			return empl1.toString() + " is greater than " + empl2.toString();
		}
		return empl1.toString() + " is less than " + empl2.toString();
	}
}
