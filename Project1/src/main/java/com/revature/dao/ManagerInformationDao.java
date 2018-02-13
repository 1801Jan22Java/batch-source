package com.revature.dao;

import java.util.List;

import com.revature.beans.ManagerInformation;

public interface ManagerInformationDao {
	public String filename = "connection.properties";

	public List<ManagerInformation> getManagerInformation();
	public ManagerInformation getManagerInformationByID(int ManagerInformationId);
	public boolean updateInformation(int managerInformationId,String email,String fname,String lname,String address);

}
