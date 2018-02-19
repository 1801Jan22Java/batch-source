package dao;

import java.util.ArrayList;

import beans.Employee;
import beans.Manager;

public interface ManagerDAO 
{
	public ArrayList<Manager> getManagers();
	public boolean addManager(Manager m);
	public boolean removeManager(int id);
	public Manager getManagerById( int id);
}
