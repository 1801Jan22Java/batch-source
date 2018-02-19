package DAOTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import dao.DocumentDAOImpl;
import dao.EmployeeDAOImpl;

public class EmployeeDAOImplTest
{
	@Test
	public final void getEmployees()
	{
		EmployeeDAOImpl empDao = new EmployeeDAOImpl();
		assertNotNull("wat", empDao.getEmployees());
	}
}
