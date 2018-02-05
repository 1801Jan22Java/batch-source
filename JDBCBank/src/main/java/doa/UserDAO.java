package doa;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import beans.*;

public interface UserDAO 
{
	public ArrayList<User> getUsers();
	public void registerNewUser(String userName, String password, String firstName, String lastName, String state, String zipCode, Date bDay, String address, String ssn) throws ParseException;
	public User getUsersByUserName(String userName);
}
