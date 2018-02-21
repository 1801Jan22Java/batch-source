package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="FLASHCARD")
public class Flashcard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7740007669339530100L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1, name="flashcardSequence", sequenceName="SQ_FLASHCARD_PK")
	@Column(name="FLASH_CARD_ID")
	private int id;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="ANSWER")
	private String answer;
	
	@ManyToOne(fetch=FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	
	public Flashcard() {
		super();
	}
	public Flashcard(String question, String answer, Category category) {
		super();
		this.question = question;
		this.answer = answer;
	}
	public Flashcard(int id, String question, String answer, Category category) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}
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
		return "Flashcard [id=" + id + ", question=" + question + ", answer="
				+ answer + ", category=" + category + "]";
	}
	
	
	
	

}
