package com.revature.beans;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="QUESTION_SCORE")
public class QuestionScore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="questionScoreSequence")
	@SequenceGenerator(allocationSize=1,name="questionScoreSequence",sequenceName="QUESTION_SCORE_S1")
	@Column(name="QUESTION_SCORE_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private Screening screening;
	
	@Column(name="SCORE")
	private Double score;
	
	@Column(name="COMMENTARY")
	private String commentary;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME")
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
