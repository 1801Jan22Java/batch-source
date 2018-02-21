package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;


@Entity
@Table
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3312708082964678722L;

	// flashcardSequence is the name for the java side things
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
	@SequenceGenerator(allocationSize = 1, name = "categorySequence", sequenceName = "SQ_CATEGORY_PK")
	@Column(name = "CATEGORY_ID")
	private int id;

	@Column(name = "NAME")
	private String name;
	
	

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
