package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="QUESTION_TAG")
public class QuestionTag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="questionTagSequence")
	@SequenceGenerator(allocationSize=1,name="questionTagSequence",sequenceName="QUESTION_TAG_S1")
	@Column(name="QUESTION_TAG_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TAG_ID")
	private Tag tag;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_ID")
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
