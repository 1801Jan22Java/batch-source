package dao;

import java.util.ArrayList;

import beans.Status;

public interface StatusDAO 
{
	public ArrayList<Status> getStatuses();
	public ArrayList<Integer> getStatusIds();
	public String getStatusName(int id);
	public Integer getStatusId(String name);
	public boolean creatStatus(String name, int statusId);
}
