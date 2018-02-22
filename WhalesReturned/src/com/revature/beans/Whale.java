package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="WHALE")
public class Whale implements Serializable{

	private static final long serialVersionUID = -78665743376883268L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="whaleSequence")
	@SequenceGenerator(allocationSize=1,name="whaleSequence",sequenceName="SQ_WHALE_PK")
	@Column(name="WHALE_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;

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

	public Whale(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Whale(String name) {
		super();
		this.name = name;
	}	
	
	public Whale() {}
	
}
