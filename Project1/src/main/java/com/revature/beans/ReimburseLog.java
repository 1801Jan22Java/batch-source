package com.revature.beans;

import java.io.Serializable;

public class ReimburseLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private int log_id;
	private int reimburse_id;
	private int reimburse_status_id;
	private String log_date;
	private int resolved_by;

	public ReimburseLog(int log_id, int reimburse_id, int reimburse_status_id, String log_date, int resolved_by) {
		super();
		this.log_id = log_id;
		this.reimburse_id = reimburse_id;
		this.reimburse_status_id = reimburse_status_id;
		this.log_date = log_date;
	}

	public ReimburseLog() {
		super();
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public int getReimburse_id() {
		return reimburse_id;
	}

	public void setReimburse_id(int reimburse_id) {
		this.reimburse_id = reimburse_id;
	}

	public int getReimburse_status_id() {
		return reimburse_status_id;
	}

	public void setReimburse_status_id(int reimburse_status_id) {
		this.reimburse_status_id = reimburse_status_id;
	}

	public String getLog_date() {
		return log_date;
	}

	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}

	public int getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(int resolved_by) {
		this.resolved_by = resolved_by;
	}

}
