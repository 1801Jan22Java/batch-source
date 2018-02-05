package com.revature.main;

import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
		DepartmentDao ddi = new DepartmentDaoImpl();
		int[] ids = {65, 68, 71};
		
		for (int i : ids) {
			ddi.nameAvgSalary(i);
			ddi.giveRaise(i);
		}
		
	}

}
