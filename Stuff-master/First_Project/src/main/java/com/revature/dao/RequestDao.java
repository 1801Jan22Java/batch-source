package com.revature.dao;

public interface RequestDao {
		
		public boolean createRequest(String description, double request_amount); 
		public String getPendingEmployeeReinbursments(int Employee_id); 
		
		public String getResolvedReinbursments(int Employee_Id); 
		
		public String getAllPendingEmployeeReinbursments(); 
		public String getAllResolvedEmployeeReinbursments(); 
}
