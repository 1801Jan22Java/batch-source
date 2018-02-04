package jdbc.dao;

import java.util.List;

import jdbc.beans.BankUser;

public interface BankUserDao {

	public void addNewUser(String username, String password);
	public void updateUsername(String newName, int userId);
	public void updatePassword(String newPass, int userId);
	public void deleteUser(int userId);
	public List<BankUser> viewUser(int userId);
	public int getIdByUserAndPass(String username, String password);
	public boolean isSuper(String username, String password);
}
