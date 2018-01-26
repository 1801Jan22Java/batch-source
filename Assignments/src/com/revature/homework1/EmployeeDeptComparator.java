package com.revature.homework1;

import java.util.Comparator;

public class EmployeeDeptComparator implements Comparator<Employee>, java.io.Serializable {

	@Override
	public int compare(Employee e1, Employee e2) {
		String dept1 = e1.getDepartment();
		String dept2 = e2.getDepartment();
		return dept1.compareTo(dept2);
	}
}
