package com.revature.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.Reimbursement;

public class ReimbursementDaoTest {
	
	@Test
	public void testSubmitReimbursement() {
		ReimbursementDao rd = new ReimbursementDaoSQL();
		int reimbursementId = rd.submitReimbursement(1000,200.00,null);
		Reimbursement reimbursementById = rd.getReimbursementByID(reimbursementId);
		assertNotNull(reimbursementById);
		assertEquals(reimbursementById.getEmployeeId(),1000);
		assertEquals(reimbursementById.getReimbursementValue(),200.00,0.01);
		assertNotNull(reimbursementById.getImage());
		assertEquals(reimbursementById.getManagerId(),0);
		assertEquals(reimbursementById.getStatus(),0);
	}

	@Test
	public void testGetReimbursement() {
		ReimbursementDao rd = new ReimbursementDaoSQL();
		List<Reimbursement> listReimbursement = rd.getReimbursement();
		assertTrue(listReimbursement.size() > 0);
		for (Reimbursement re : listReimbursement) {
			assertNotNull(re);
			Reimbursement reimbursementById = rd.getReimbursementByID(re.getReimbursementId());
			assertEquals(reimbursementById.getEmployeeId(),re.getEmployeeId());
			assertEquals(reimbursementById.getReimbursementValue(),re.getReimbursementValue(),0.01);
			assertNotNull(reimbursementById.getImage());
			assertEquals(reimbursementById.getManagerId(),re.getManagerId());
			assertEquals(reimbursementById.getStatus(),re.getStatus());
		}
	}
	
	@Test
	public void testUpdateReimbursement() {
		ReimbursementDao rd = new ReimbursementDaoSQL();
		rd.updateStatus(1000, 1000, 2);
		Reimbursement reimbursementById = rd.getReimbursementByID(1000);
		assertEquals(reimbursementById.getManagerId(),1000);
		assertEquals(reimbursementById.getStatus(),2);
		rd.updateStatus(1000, 1000, 0);
		reimbursementById = rd.getReimbursementByID(1000);
		assertEquals(reimbursementById.getManagerId(),1000);
		assertEquals(reimbursementById.getStatus(),0);
	}

}
