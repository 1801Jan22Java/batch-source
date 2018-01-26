package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question7 {

	public static void main(String[] args) {
		
		//I'm sorry
		Question7 q = new Question7();
		ArrayList<Employee> e = new ArrayList<>();
		
		//should've made a separate employee class but oh well
		Employee e1 = q.new Employee();
		e1.name = "tony";
		e1.department = "finance";
		e1.age = 32;
		e.add(e1);
		
		Employee e2 = q.new Employee();
		e2.name = "pete";
		e2.department = "hr";
		e2.age = 27;
		e.add(e2);
		
		//delightfully vile code because I made all my classes a part of Question7
		NameCompare nc = q.new NameCompare();
		DeptCompare dc = q.new DeptCompare();
		AgeCompare ac = q.new AgeCompare();
		
		//sort by name
		System.out.println("sorting by name");
		Collections.sort(e, nc);
		System.out.println(e.toString());
		
		//sort by department
		System.out.println("sorting by department");
		Collections.sort(e, dc);
		System.out.println(e.toString());
		
		//sort by age
		System.out.println("sorting by age");
		Collections.sort(e, ac);
		System.out.println(e.toString());
		
	}

	class Employee {

		public String name;

		public String department;

		public int age;
		
		@Override
		public String toString() {
			return "Name:"+this.name+" Department:"+this.department+" Age:"+this.age;
		}
	}

	class NameCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {

			String name1 = e1.name;

			return name1.compareTo(e2.name);
		}
	}

	class DeptCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {

			String dept1 = e1.department;

			return dept1.compareTo(e2.department);
		}
	}

	class AgeCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {

			Integer dept1 = e1.age;

			return dept1.compareTo(e2.age);
		}
	}

}
