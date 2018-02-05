package DOA;
import java.sql.Date;
import java.util.ArrayList;


import beans.*;
public interface DepartmentDAO 
{
	public ArrayList<department> getDepartments();
	public department addDepartment(String name);
}
