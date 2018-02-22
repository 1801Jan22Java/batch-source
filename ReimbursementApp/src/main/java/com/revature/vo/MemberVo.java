package com.revature.vo;

public class MemberVo {

	public int no;
	public String id;		
	public String pwd;	// length should be more then 4
	public String email;	
	public String lv;				// 0: Manager  1:Employee
	
	public MemberVo() {
	}
	
	public MemberVo(int no, String id, String pwd, String email, String lv) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.lv = lv;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", lv=" + lv + "]";
	}
	
}
