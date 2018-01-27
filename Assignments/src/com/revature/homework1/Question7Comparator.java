package com.revature.homework1;

import java.util.Comparator;

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
