package com.revature.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.EmployeeInformation;

import junit.framework.TestCase;

public class EmployeeInformationDaoTest extends TestCase{

	@Test
	public void testGetEmployeeInformation() {
		EmployeeInformationDao eids = new EmployeeInformationDaoSQL();
		List<EmployeeInformation> listEmployeeInformation = eids.getEmployeeInformation();
		assertTrue(listEmployeeInformation.size() > 0);
		for(EmployeeInformation ei : listEmployeeInformation) {
			assertNotNull(ei);
			EmployeeInformation employeeInformationById = eids.getEmployeeInformationByID(ei.getEmployeeInformationId());
			assertEquals(ei.getEmployeeInformationId(),employeeInformationById.getEmployeeInformationId());
			System.out.println(employeeInformationById.getEmployeeInformationId());
			assertEquals(ei.getEmail(),employeeInformationById.getEmail());
			assertEquals(ei.getFname(),employeeInformationById.getFname());
			assertEquals(ei.getLname(),employeeInformationById.getLname());
			assertEquals(ei.getAddress(),employeeInformationById.getAddress());
		}
	}
	
	@Test
	public void testGetEmployeeInformationById() {
		EmployeeInformationDao eids = new EmployeeInformationDaoSQL();
		EmployeeInformation employeeInformationById = eids.getEmployeeInformationByID(1000);
		assertNotNull(employeeInformationById);
		System.out.println(employeeInformationById.toString());
		assertEquals(1000,employeeInformationById.getEmployeeInformationId());
		assertEquals("email2",employeeInformationById.getEmail());
		assertEquals("first",employeeInformationById.getFname());
		assertEquals("last",employeeInformationById.getLname());
		assertEquals("the address",employeeInformationById.getAddress());
		
	}
	
	@Test
	public void testUpdateEmployeeInformation() {
		EmployeeInformationDao eids = new EmployeeInformationDaoSQL();
		eids.updateInformation(1000, "email2", "first", "last", "the address");
		EmployeeInformation employeeInformationById = eids.getEmployeeInformationByID(1000);
		assertNotNull(employeeInformationById);
		assertEquals(1000,employeeInformationById.getEmployeeInformationId());
		assertEquals("email2",employeeInformationById.getEmail());
		assertEquals("first",employeeInformationById.getFname());
		assertEquals("last",employeeInformationById.getLname());
		assertEquals("the address",employeeInformationById.getAddress());
		
	}

}
