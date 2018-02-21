package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1, name="categorySequence", sequenceName="SQ_CATEGORY_PK")
	@Column(name="CATEGORY_ID")
	private int id;
	
	@Column(name="CATEGORY_NAME")
	private String name;

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
