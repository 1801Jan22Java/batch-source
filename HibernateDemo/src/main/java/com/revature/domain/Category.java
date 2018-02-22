package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="CATEGORY")
public class Category implements Serializable{
	public Category() {
		super();
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="categorySequence")
	@SequenceGenerator(allocationSize=1,name="categorySequence",sequenceName="SQ_CATEGORY_PK")	//sequenceName - how it shows up on SQL side
	@Column(name="CATEGORY_ID")
	private int id;
	
	@Column(name="CATEGORY_NAME")
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
