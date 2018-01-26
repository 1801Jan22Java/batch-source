package com.revature.homework1;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee>, java.io.Serializable {
	
	@Override
	public int compare(Employee e1, Employee e2) {
		Integer age1 = new Integer(e1.getAge());
		Integer age2 = new Integer(e2.getAge());
		return age1.compareTo(age2);
	}
	
}
