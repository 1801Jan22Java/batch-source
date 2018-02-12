package com.revature.beans;

import java.util.Date;

public class Bear {
	public Bear(int id, int typeId, String name, Date birthday, int weight, int caveId) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.name = name;
		this.birthday = birthday;
		this.weight = weight;
		this.caveId = caveId;
	}
	private int id;
	private int typeId;
	private String name;
	private Date birthday;
	private int weight;
	private int caveId;
}
