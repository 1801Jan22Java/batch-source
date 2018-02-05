package com.revature.vo;

public class BankUserVo {

	public int id;			// user id
	public String name;		// user login name
	public String pw;		// user login pw
	public int lv;			// 0:super user 1:basic user
	
	public BankUserVo() {
		super();
	}
	
	public BankUserVo(int id, String name, String pw, int lv) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.lv = lv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "BankUserVo [id=" + id + ", name=" + name + ", pw=" + pw + ", lv=" + lv + "]";
	}
	
}
