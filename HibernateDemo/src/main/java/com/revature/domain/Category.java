package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@Table(name="CATEGORY")
public class Category implements Serializable {

	public Category(int id, String question) {
		super();
		this.id = id;
		this.question = question;
	}
	
	public Category( String question) {
		super();
		this.question = question;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1,name="categorySequence",sequenceName="SQ_FLASHCARD_PK")
	@Column(name="CATEGORY_ID")
	private int id;
	
	@Column(name="CATEGORY_NAME")
	private String question;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", question=" + question + "]";
	}
	
	
}
