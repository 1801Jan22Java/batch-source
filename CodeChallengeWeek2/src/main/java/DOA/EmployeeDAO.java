package DOA;

import java.util.ArrayList;

import beans.*;

public interface EmployeeDAO 
{
	public ArrayList<employee> getEmployees();
	public department addEmployee(String fistName, String lastName, int departmentId, float salary, String email);
}
