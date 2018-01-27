package com.revature.homework1;

import java.util.*;

class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.name.compareTo(e2.name) == 0) {
			if (e1.department.compareTo(e2.department) == 0) {
				return e1.age.compareTo(e2.age);
			}
			return e1.department.compareTo(e2.department);
		}
		return e1.name.compareTo(e2.name);
	}

}
