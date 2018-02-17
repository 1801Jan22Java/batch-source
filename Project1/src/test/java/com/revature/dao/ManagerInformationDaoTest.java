package com.revature.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.ManagerInformation;

import junit.framework.TestCase;

public class ManagerInformationDaoTest extends TestCase {

	@Test
	public void testGetManagerInformation() {
		ManagerInformationDao mids = new ManagerInformationDaoSQL();
		List<ManagerInformation> listManagerInformation = mids.getManagerInformation();
		assertTrue(listManagerInformation.size() > 0);
		for(ManagerInformation mi : listManagerInformation) {
			ManagerInformation managerInformationById = mids.getManagerInformationByID(mi.getManagerInformationId());
			assertEquals(mi.getManagerInformationId(),managerInformationById.getManagerInformationId());
			System.out.println(managerInformationById.getManagerInformationId());
			assertEquals(mi.getEmail(),managerInformationById.getEmail());
			assertEquals(mi.getFname(),managerInformationById.getFname());
			assertEquals(mi.getLname(),managerInformationById.getLname());
			assertEquals(mi.getAddress(),managerInformationById.getAddress());
		}
	}
	
//	@Test
//	public void testGetManagerInformationById() {
//		ManagerInformationDao mids = new ManagerInformationDaoSQL();
//		ManagerInformation managerInformationById = mids.getManagerInformationByID(1000);
//		assertNotNull(managerInformationById);
//		assertEquals(1000,managerInformationById.getManagerInformationId());
//		assertEquals("manager@email",managerInformationById.getEmail());
//		assertEquals("man_fname",managerInformationById.getFname());
//		assertEquals("man_lname",managerInformationById.getLname());
//		assertEquals("man_address",managerInformationById.getAddress());
//		
//	}
	
	@Test
	public void testUpdateManagerInformation() {
		ManagerInformationDao mids = new ManagerInformationDaoSQL();
		mids.updateInformation(1000, "email2", "first", "last", "the address");
		ManagerInformation managerInformationById = mids.getManagerInformationByID(1000);
		assertEquals(1000,managerInformationById.getManagerInformationId());
		assertEquals("email2",managerInformationById.getEmail());
		assertEquals("first",managerInformationById.getFname());
		assertEquals("last",managerInformationById.getLname());
		assertEquals("the address",managerInformationById.getAddress());
		
	}

}
