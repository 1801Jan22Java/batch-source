package com.revature.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Image;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimburseOracle;

public class ReimburseUtil {
	private ReimburseOracle ro = new ReimburseOracle();

	public List<Reimbursement> getPending(String username) {
		List<Reimbursement> temp = ro.viewAllRequestsEmp(username);
		List<Reimbursement> output = new ArrayList<>();
		for (Reimbursement r : temp) {
			if (r.getReimburse_status_id() == 1) {
				output.add(r);
			}
		}
		return output;
	}

	public List<Reimbursement> getResolved(String username) {
		List<Reimbursement> temp = ro.viewAllRequestsEmp(username);
		List<Reimbursement> output = new ArrayList<>();
		for (Reimbursement r : temp) {
			if (r.getReimburse_status_id() > 1) {
				output.add(r);
			}
		}
		return output;
	}

	public List<Reimbursement> getAllUsername(String username) {
		List<Reimbursement> list = ro.viewAllRequestsEmp(username);
		return list;
	}

	public List<Reimbursement> getAllRequests() {
		return ro.viewAllRequests();

	}

	public boolean submitRequest(int user_id, double amount) {
		return ro.reimburseRequest(user_id, amount, "");
	}

	public boolean submitRequestNotes(int user_id, double amount, String notes) {
		return ro.reimburseRequest(user_id, amount, notes);
	}

	public boolean approveRequest(int request_id, int manager_id) {
		return ro.approveRequest(request_id, manager_id);
	}

	public boolean rejectRequest(int request_id, int manager_id) {
		return ro.denyRequest(request_id, manager_id);
	}

	public boolean uploadImage(int request_id, InputStream is) {
		return ro.uploadImage(request_id, is);
	}

	public ByteArrayOutputStream viewImage(int request_id) {
		return ro.viewImage(request_id);
	}

	public List<Image> getAllImages() {
		return ro.getAllImages();
	}
}
