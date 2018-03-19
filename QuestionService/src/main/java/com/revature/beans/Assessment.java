package com.revature.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Assessment implements Serializable {
	private static final long serialVersionUID = 5030264218154828822L;

	private Long assessmentId;
	private String title;
	private Batch batch;
	private Integer rawScore;
	private AssessmentType type;
	private Short week;
	private Category category;
	private Set<Grade> grades = new HashSet<>();

	public Assessment() {
		super();
	}

	public Assessment(String title, Batch batch, Integer rawScore, AssessmentType type, Integer week,
			Category category) {
		this();
		this.title = title;
		this.batch = batch;
		this.rawScore = rawScore;
		this.type = type;
		this.week = week.shortValue();
		this.category = category;
	}

	public Assessment(SimpleAssessment simpleAssessment){
		this();
		this.assessmentId = simpleAssessment.getAssessmentId();
		this.title = simpleAssessment.getTitle();
		this.rawScore = simpleAssessment.getRawScore();
		this.type = simpleAssessment.getType();
		this.week = simpleAssessment.getWeek();
	}

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getTitle() {
		return this.category.getSkillCategory() + " " + this.type.name();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Integer getRawScore() {
		return rawScore;
	}

	public void setRawScore(Integer rawScore) {
		this.rawScore = rawScore;
	}

	public AssessmentType getType() {
		return type;
	}

	public void setType(AssessmentType type) {
		this.type = type;
	}

	public Short getWeek() {
		return week;
	}

	public void setWeek(Short week) {
		this.week = week;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + rawScore;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + week;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assessment other = (Assessment) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (rawScore != other.rawScore)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		if (week != other.week)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assessment [assessmentId= " + assessmentId + " title=" + title + ", batch=" + batch + ", rawScore="
				+ rawScore + ", type=" + type + ", week=" + week + ", category=" + category + "]";
	}
}
