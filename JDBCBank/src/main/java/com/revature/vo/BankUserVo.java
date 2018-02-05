package com.revature.vo;

public class BankUserVo {

	public int id;			// user id
	public String name;		// user login name
	public String pw;		// user login pw
	public int lv;			// 0:super user 1:basic user
	public int totalBalance;
	
	public BankUserVo() {
		super();
	}
	 
	public BankUserVo(int id, String name, int totalBalance) {
		super();
		this.id = id;
		this.name = name;
		this.totalBalance = totalBalance;
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

	public int getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "BankUserVo [id=" + id + ", name=" + name + ", pw=" + pw + ", lv=" + lv + ", totalBalance="
				+ totalBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + lv;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankUserVo other = (BankUserVo) obj;
		if (id != other.id)
			return false;
		if (lv != other.lv)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	
	

}
