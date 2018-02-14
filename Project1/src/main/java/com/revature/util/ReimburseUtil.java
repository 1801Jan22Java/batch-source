package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimburseOracle;

public class ReimburseUtil {
	private ReimburseOracle ro = new ReimburseOracle();
	
	public List<Reimbursement> getPending(String username){
		List<Reimbursement> temp = ro.viewAllRequestsEmp(username);
		List<Reimbursement> output = new ArrayList<>();
		for(Reimbursement r : temp) {
			if(r.getReimburse_status_id()==1) {
				output.add(r);
			}
		}
		return output;
	}
	public List<Reimbursement> getResolved(String username){
		List<Reimbursement> temp = ro.viewAllRequestsEmp(username);
		List<Reimbursement> output = new ArrayList<>();
		for(Reimbursement r : temp) {
			if(r.getReimburse_status_id()>1) {
				output.add(r);
			}
		}
		return output;
	}
}
