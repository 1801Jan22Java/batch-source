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
@Table(name="QUESTION")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="questionSequence")
	@SequenceGenerator(allocationSize=1,name="questionSequence",sequenceName="QUESTION_S1")
	@Column(name="QUESTION_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BUCKET_ID")
	private Bucket bucket;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_TAG_ID")
	private QuestionTag questionTag;
	
	@Column(name="QUESTION_TEXT")
	private String questionText;
	
	@Column(name="SAMPLE_ANSWER_1")
	private String SampleAnswer1;

	@Column(name="SAMPLE_ANSWER_2")
	private String SampleAnswer2;

	@Column(name="SAMPLE_ANSWER_3")
	private String SampleAnswer3;

	@Column(name="SAMPLE_ANSWER_4")
	private String SampleAnswer4;

	@Column(name="SAMPLE_ANSWER_5")
	private String SampleAnswer5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bucket getBucket() {
		return bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	public QuestionTag getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(QuestionTag questionTag) {
		this.questionTag = questionTag;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getSampleAnswer1() {
		return SampleAnswer1;
	}

	public void setSampleAnswer1(String sampleAnswer1) {
		SampleAnswer1 = sampleAnswer1;
	}

	public String getSampleAnswer2() {
		return SampleAnswer2;
	}

	public void setSampleAnswer2(String sampleAnswer2) {
		SampleAnswer2 = sampleAnswer2;
	}

	public String getSampleAnswer3() {
		return SampleAnswer3;
	}

	public void setSampleAnswer3(String sampleAnswer3) {
		SampleAnswer3 = sampleAnswer3;
	}

	public String getSampleAnswer4() {
		return SampleAnswer4;
	}

	public void setSampleAnswer4(String sampleAnswer4) {
		SampleAnswer4 = sampleAnswer4;
	}

	public String getSampleAnswer5() {
		return SampleAnswer5;
	}

	public void setSampleAnswer5(String sampleAnswer5) {
		SampleAnswer5 = sampleAnswer5;
	}
	
}
