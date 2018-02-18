package com.revature.beans;

import java.sql.Date;
import java.util.Arrays;

public class Reimb {
	
	private int reimbId;
	private int empId;
	private int mgrId;
	private double amt;
	private int status;
	private byte[] image;
	private Date doc;
	private Date doad;

	public Reimb(int reimbId, int empId, int mgrId, double amt, int status, byte[] image, Date doc, Date doad) {
		super();
		this.reimbId = reimbId;
		this.empId = empId;
		this.mgrId = mgrId;
		this.amt = amt;
		this.status = status;
		this.image = image;
		this.doc = doc;
		this.doad = doad;
	}

	public Reimb(int empId, int mgrId, double amt, int status, byte[] image, Date doc, Date doad) {
		this.empId = empId;
		this.mgrId = mgrId;
		this.amt = amt;
		this.status = status;
		this.image = image;
		this.doc = doc;
		this.doad = doad;
	}

	public Reimb(int reimbId, int empId, double amt, int status, byte[] image, Date doc) {
		this.reimbId = reimbId;
		this.empId = empId;
		this.amt = amt;
		this.status = status;
		this.image = image;
		this.doc = doc;
	}

	public Reimb(int empId, double amt, int status, byte[] image, Date doc) {
		this.empId = empId;
		this.amt = amt;
		this.status = status;
		this.image = image;
		this.doc = doc;
	}
	
	public Reimb() {}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	public Date getDoad() {
		return doad;
	}

	public void setDoad(Date doad) {
		this.doad = doad;
	}

	public int getReimbId() {
		return reimbId;
	}

	public int getEmpId() {
		return empId;
	}
	
	private String parseStatus() {
		switch (this.status) {
		case 0:
			return "Pending";
		case 1:
			return "Resolved";
		case 2:
			return "Denied";
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		String statusString = "\"" + this.parseStatus() + "\"";
		java.util.Date docUtil = new java.util.Date(doc.getTime());
		String docString = "\"" + docUtil.toString() + "\"";
		java.util.Date doadUtil = null;
		String doadString = "\" \"";
		if (doad != null) {
			doadUtil = new java.util.Date(doad.getTime());
			doadString = "\"" + doadUtil.toString() + "\"";
		}
		return "{ \"reimbId\":" + reimbId + ", \"empId\":" + empId + ", \"mgrId\":" + mgrId + ", \"amount\":" + amt + ", \"status\":"
				+ statusString + ", \"image\":" + Arrays.toString(image) + ", \"doc\":" + docString + ", \"doad\":" + doadString + " }";
	}
	
}
