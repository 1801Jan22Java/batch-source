package com.revature.Driver;

import com.revature.dao.*;
import com.revature.beans.*;

public class Driver {
	
	public static void main(String[] args) {
		
		DepartmentDao dd = new DepartmentDaoSQL();
		dd.getNameAvg(1003);
		
	}

}
