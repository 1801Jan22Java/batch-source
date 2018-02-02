package com.revature.homework1;

import java.util.Comparator;

public class DepartmentComparator implements Comparator<Employee>{
	
	public int compare(Employee emp1,Employee emp2)
	{   
		return emp1.dept.compareTo(emp2.dept);  
	}

}
