package com.revature.dao;

public interface ReimbReqDAO {

	/* 
	 * ReqId NUMBER NOT NULL,
	 * EmployeeId NUMBER NOT NULL,
	 * ManagerId NUMBER NOT NULL, 
	 * ReqStatus VARCHAR2(20), 
	 * Receipt BLOB, 
	 * CONSTRAINT PK_ReimbReq PRIMARY KEY (ReqId)
	 */
	
	public int addNewReimbReq(int employeeId, String reqStatus, String receipt);
}
