package com.revature.main;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.UploadDaoImpl;

public class DaoHandler 
{
	private EmployeeDaoImpl edi;
	private RequestDaoImpl rdi;
	private UploadDaoImpl udi;
	
	public DaoHandler() {
		super();
		this.edi = new EmployeeDaoImpl();
		this.rdi = new RequestDaoImpl();
		this.udi = new UploadDaoImpl();
	}

	public EmployeeDaoImpl getEdi() {
		return edi;
	}

	public void setEdi(EmployeeDaoImpl edi) {
		this.edi = edi;
	}

	public RequestDaoImpl getRdi() {
		return rdi;
	}

	public void setRdi(RequestDaoImpl rdi) {
		this.rdi = rdi;
	}

	public UploadDaoImpl getUdi() {
		return udi;
	}

	public void setUdi(UploadDaoImpl udi) {
		this.udi = udi;
	}
	
	
}
