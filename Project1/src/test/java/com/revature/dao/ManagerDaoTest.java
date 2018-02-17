package com.revature.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.Manager;

import junit.framework.TestCase;

public class ManagerDaoTest extends TestCase{
	
	@Test
	public void testAddManager() {
		ManagerDaoSQL mds = new ManagerDaoSQL();
		int newManagerId = mds.addManager("new_manager","new_manager_password","manager@email","man_fname","man_lname","man_address");
		Manager newManager = mds.getManagerByID(newManagerId);
		assertNotNull(newManager);
		assertEquals(newManager.getManagerId(),newManagerId);
		assertEquals(newManager.getUsername(), "new_manager");
		assertEquals(newManager.getPassword(), "new_manager_password");
		assertEquals(newManager.getManagerInformationId(),1000);
	}

	@Test
	public void testGetListManager() {
		ManagerDaoSQL mds = new ManagerDaoSQL();
		List<Manager> listManager = mds.getManagers();
			assertTrue(listManager.size() > 0);
		for (Manager man: listManager) {
			Manager managerById = mds.getManagerByID(man.getManagerId());
			assertEquals(man.getManagerId(),managerById.getManagerId());
			assertEquals(man.getUsername(),managerById.getUsername());
			assertEquals(man.getPassword(),managerById.getPassword());
			assertEquals(man.getManagerInformationId(),managerById.getManagerInformationId());
			System.out.println(man.toString());
		}
		
	}
	
	@Test
	public void testGetManagerById() {
		ManagerDaoSQL mds = new ManagerDaoSQL();
		Manager managerById = mds.getManagerByID(1000);
		assertNotNull(managerById);
		assertEquals(managerById.getManagerId(),1000);
		assertEquals(managerById.getUsername(), "new_manager");
		assertEquals(managerById.getPassword(), "new_manager_password");
		assertEquals(managerById.getManagerInformationId(),1000);
	}
	
	@Test
	public void testGetManagerByCredentials() {
		ManagerDaoSQL mds = new ManagerDaoSQL();
		Manager managerByCredentials = mds.getManagerByCredentials("new_manager","new_manager_password");
		assertNotNull(managerByCredentials);
		assertEquals(managerByCredentials.getManagerId(),1000);
		assertEquals(managerByCredentials.getUsername(), "new_manager");
		assertEquals(managerByCredentials.getPassword(), "new_manager_password");
		assertEquals(managerByCredentials.getManagerInformationId(),1000);
		
	}
	


}
