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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="QUESTION_SCORE_SEQUENCE")
	@SequenceGenerator(name="QUESTION_SCORE_SEQUENCE",sequenceName="QUESTION_SCORE_SEQUENCE")
	@Column(name="QUESTION_SCORE_ID")
	private Integer questionScoreId;
	
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
	@Column(name = "BEGIN_TIME")
	private Date beginTime;

	public QuestionScore(Integer questionScoreId, Question question, Screening screening, Double score,
			String commentary, Date beginTime) {
		super();
		this.questionScoreId = questionScoreId;
		this.question = question;
		this.screening = screening;
		this.score = score;
		this.commentary = commentary;
		this.beginTime = beginTime;
	}

	public Integer getQuestionScoreId() {
		return questionScoreId;
	}

	public void setQuestionScoreId(Integer questionScoreId) {
		this.questionScoreId = questionScoreId;
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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
}
