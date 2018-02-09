package com.revature.homework1;

import java.util.ArrayList;
import java.util.Comparator;


public class Question7 {
	
	public class Question7Comparator implements Comparator<Question7Employee> {

		public int compareName(Question7Employee e1, Question7Employee e2){
			String e1Name = e1.getName();
			String e2Name = e2.getName();
			return e1Name.compareTo(e2Name);
			
		}
		
		public int compareDepartment(Question7Employee e1, Question7Employee e2){
			String e1Department = e1.getDepartment();
			String e2Department = e2.getDepartment();
			return e1Department.compareTo(e2Department);
			
		}
		
		public int compareAge(Question7Employee e1, Question7Employee e2){
			int e1Age = e1.getAge();
			int e2Age = e2.getAge();
			
			if(e1Age == e2Age)
			       return 0;
			
			else if(e1Age > e2Age)
			       return 1;
			else
			       return -1;
			 }
		

	@Override
		public int compare(Question7Employee o1, Question7Employee o2) {
			// TODO Auto-generated method stub
			return 0;
		}

		
		
		
		
	}
	
	public class Employee{
		private String name;
		private String department;
		private int age;
		
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
	
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
		
		
		//ArrayList.sort( staff , Question7Comparator());;
		for (int i = 0; i < staff.size();i++) {
			System.out.println("Without Comparator");
			System.out.println(staff.get(i).getName());
			System.out.println(staff.get(i).getDepartment());
			System.out.println(staff.get(i).getAge());
		}
		

		
		
		
	
	
	

}


	
}
