package com.revature.vo;

public class RequestVo {

	public int no;
	public int status; 			// 1:Pending  2:Approved 3:Denied
	public String day;			// date type in DB
	public int amount;
	public String purpose;
	public int employee_no;
	public int manager_no;
	public int cnt;					// count no. on anything related to Request
	public int rowNum;		// pageNation
	public String employee_id;
	public String manager_id;
	
	public RequestVo() {
		
	}
	
	public RequestVo(int status, int cnt) {
		super();
		this.status = status;
		this.cnt = cnt;
	}

	public RequestVo(int amount, String purpose, int employee_no) {
		super();
		this.amount = amount;
		this.purpose = purpose;
		this.employee_no = employee_no;
	}

	public RequestVo(int no, int status, String day, int amount, String purpose, int employee_no) {
		super();
		this.no = no;
		this.status = status;
		this.day = day;
		this.amount = amount;
		this.purpose = purpose;
		this.employee_no = employee_no;
	}
	
	public RequestVo(int no, int status, String day, int amount, String purpose, int employee_no, int manager_no) {
		super();
		this.no = no;
		this.status = status;
		this.day = day;
		this.amount = amount;
		this.purpose = purpose;
		this.employee_no = employee_no;
		this.manager_no = manager_no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(int employee_no) {
		this.employee_no = employee_no;
	}

	public int getManager_no() {
		return manager_no;
	}

	public void setManager_no(int manager_no) {
		this.manager_no = manager_no;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	@Override
	public String toString() {
		return "RequestVo [no=" + no + ", status=" + status + ", day=" + day + ", amount=" + amount + ", purpose="
				+ purpose + ", employee_no=" + employee_no + ", manager_no=" + manager_no + ", cnt=" + cnt + ", rowNum="
				+ rowNum + ", employee_id=" + employee_id + "]";
	}

}
