package com.revature.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Request;
import com.revature.beans.Upload;

public interface RequestDao 
{
	public List<Request> getRequests();

	public Request getRequestById(int id);

	public Request addRequest(int employeeId, LocalDate dateOfCreation, double amount, String status, String purpose, String EmployeeNotes, int managerId, String managerNotes, Upload upload);

	public boolean updateRequest(int id, String value, String columnName);

	public boolean deleteRequest(int id);
}
