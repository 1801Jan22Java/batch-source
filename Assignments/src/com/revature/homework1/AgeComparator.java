package com.revature.homework1;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee>{
	
	public int compare(Employee emp1,Employee emp2)
	{   
		return emp1.age - emp2.age;  
	}  

}
