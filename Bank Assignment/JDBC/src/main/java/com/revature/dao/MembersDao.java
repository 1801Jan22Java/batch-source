package com.revature.dao;

import java.util.List;
import com.revature.beans.Members;

public interface MembersDao {
	public Members login(String username, String password);
	public void updateMember(Members member, String username, String password);
	
	
	public List<Members> getAllUsers();
}
