package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="FLASHCARD")
public class Flashcard  implements Serializable {
	
	public Flashcard(int id, String question, String answer) {
		this();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}
	
	public Flashcard(String question, String answer) {
		this();
		this.question = question;
		this.answer = answer;
	}
	
	public Flashcard(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1,name="flashcardSequence",sequenceName="SQ_FLASHCARD_PK")
	@Column(name="FLASHCARD_ID")
	private int id;
	@Column(name="QUESTION")
	private String question;
	@Column(name="ANSWER")
	private String answer;
	

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
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	

}
