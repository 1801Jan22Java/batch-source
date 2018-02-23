package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bear")
public class Bear extends Animal implements Serializable {

	private static final long serialVersionUID = -4967294071231049038L;

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(String name, Cave cave, String bearType) {
		super(name, cave);
		this.bearType = bearType;
	}

	@Column(name="BEAR_TYPE")
	private String bearType;

	@Override
	public String toString() {
		return super.toString() +  " [bearType=" + bearType + "]";
		//return "Bear [bearType=" + bearType + "]";
	}

	public String getBearType() {
		return bearType;
	}

	public void setBearType(String bearType) {
		this.bearType = bearType;
	}

	
}