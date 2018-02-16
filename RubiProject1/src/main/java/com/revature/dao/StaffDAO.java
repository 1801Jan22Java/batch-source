package com.revature.dao;

import com.revature.beans.Staff;
import java.util.List;

/*EmployeeId NUMBER NOT NULL,
 * LastName VARCHAR2(20) NOT NULL,
 * FirstName VARCHAR2(20) NOT NULL,
 * Email VARCHAR2(60) NOT NULL,
 * Pass VARCHAR2(20) NOT NULL,
 * Username VARCHAR2(20),
 * IsManager NUMBER,
 * ReportsTo NUMBER
 */

public interface StaffDAO {
	
	public List<Staff> getAllStaff();
	
	public Staff getStaff(String email);

}
