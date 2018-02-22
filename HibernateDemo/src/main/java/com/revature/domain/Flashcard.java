package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

//We can have multiple NamedQueries in each entity
@NamedQueries({ @NamedQuery(name="findCardByCategory",
	query="from Flashcard where category = :categoryVar")})


@Entity		//javax.persistence.*
@Table(name="FLASHCARD")
public class Flashcard implements Serializable{
	
	
	private static final long serialVersionUID = -1923111444811160415L;


	public Flashcard() {
		super();
	}
	public Flashcard(int id, String question, String answer, Category category) {
		this();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}
	
	//We need a constructor without setting id, so the sequence can set it automatically
	public Flashcard(String question, String answer, Category category) {
		super();
		this.question = question;
		this.answer = answer;
		this.category = category;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1,name="flashcardSequence",sequenceName="SQ_FLASHCARD_PK")	//sequenceName - how it shows up on SQL side
	@Column(name="FLASHCARD_ID")
	private int id;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="ANSWER")
	private String answer;
	
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", category=" + category + "]";
	}
	
}
