package com.revature.beans;

import java.io.Serializable;

/**
 * The type Simple Note.
 */
public class SimpleNote implements Serializable {
	private static final long serialVersionUID = 2951603247957437593L;

	private Integer noteId;
	private String content;
	private Short week;
	private Integer batchId;
	private Integer traineeId;
	private TrainerRole maxVisibility;
	private NoteType type;
	private Boolean qcFeedback;
	private QCStatus qcStatus;

	public SimpleNote() {
		super();
		this.maxVisibility = TrainerRole.ROLE_TRAINER;
	}

	public SimpleNote(Integer noteId, String content, Short week, Integer batchId, Integer traineeId,
			TrainerRole maxVisibility, NoteType type, Boolean qcFeedback, QCStatus qcStatus) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.week = week;
		this.batchId = batchId;
		this.traineeId = traineeId;
		this.maxVisibility = maxVisibility;
		this.type = type;
		this.qcFeedback = qcFeedback;
		this.qcStatus = qcStatus;
	}

	public SimpleNote(Note src) {
		super();
		this.noteId = src.getNoteId();
		this.content = src.getContent();
		this.week = src.getWeek();
		this.batchId = src.getBatch() != null ? src.getBatch().getBatchId() : null;
		this.traineeId = src.getTrainee() != null ? src.getTrainee().getTraineeId() : null;
		this.maxVisibility = src.getMaxVisibility();
		this.type = src.getType();
		this.qcFeedback = src.isQcFeedback();
		this.qcStatus = src.getQcStatus();
	}

	/**
	 * Factory method to construct new QC weekly batch note
	 * 
	 * @param content
	 * @param week
	 * @param batchId
	 * @param qcStatus
	 * @return
	 */
	public static SimpleNote qcBatchNote(String content, Short week, Integer batchId, QCStatus qcStatus) {
		SimpleNote note = new SimpleNote();

		note.setContent(content);
		note.setWeek(week);
		note.setBatchId(batchId);
		note.setMaxVisibility(TrainerRole.ROLE_QC);
		note.setType(NoteType.QC_BATCH);
		note.setQcFeedback(true);
		note.setQcStatus(qcStatus);

		return note;
	}

	/**
	 * Factory method for creating new QC weekly individual trainee note
	 * 
	 * @param content
	 * @param week
	 * @param traineeId
	 * @param qcStatus
	 * @return
	 */
	public static SimpleNote qcIndividualNote(String content, Short week, Integer traineeId, QCStatus qcStatus) {
		SimpleNote note = new SimpleNote();

		note.setContent(content);
		note.setWeek(week);
		note.setTraineeId(traineeId);
		note.setMaxVisibility(TrainerRole.ROLE_QC);
		note.setType(NoteType.QC_TRAINEE);
		note.setQcFeedback(true);
		note.setQcStatus(qcStatus);
		;

		return note;
	}

	/**
	 * Factory method for creating a new Trainer weekly batch note
	 * 
	 * @param content
	 * @param week
	 * @param batchId
	 * @return
	 */
	public static SimpleNote trainerBatchNote(String content, Short week, Integer batchId) {
		SimpleNote note = new SimpleNote();

		note.setContent(content);
		note.setWeek(week);
		note.setBatchId(batchId);
		note.setMaxVisibility(TrainerRole.ROLE_TRAINER);
		note.setType(NoteType.BATCH);
		note.setQcFeedback(false);

		return note;
	}

	/**
	 * Factory method for creating a new Trainer weekly individual trainee note
	 * 
	 * @param content
	 * @param week
	 * @param traineeId
	 * @return
	 */
	public static SimpleNote trainerIndividualNote(String content, Short week, Integer traineeId) {
		SimpleNote note = new SimpleNote();

		note.setContent(content);
		note.setWeek(week);
		note.setTraineeId(traineeId);
		note.setMaxVisibility(TrainerRole.ROLE_TRAINER);
		note.setType(NoteType.TRAINEE);
		note.setQcFeedback(false);

		return note;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Short getWeek() {
		return week;
	}

	public void setWeek(Short week) {
		this.week = week;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public TrainerRole getMaxVisibility() {
		return maxVisibility;
	}

	public void setMaxVisibility(TrainerRole maxVisibility) {
		this.maxVisibility = maxVisibility;
	}

	public NoteType getType() {
		return type;
	}

	public void setType(NoteType type) {
		this.type = type;
	}

	public Boolean isQcFeedback() {
		return qcFeedback;
	}

	public void setQcFeedback(Boolean qcFeedback) {
		this.qcFeedback = qcFeedback;
	}

	public QCStatus getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(QCStatus qcStatus) {
		this.qcStatus = qcStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((maxVisibility == null) ? 0 : maxVisibility.hashCode());
		result = prime * result + ((noteId == null) ? 0 : noteId.hashCode());
		result = prime * result + (qcFeedback ? 1231 : 1237);
		result = prime * result + ((qcStatus == null) ? 0 : qcStatus.hashCode());
		result = prime * result + ((traineeId == null) ? 0 : traineeId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((week == null) ? 0 : week.hashCode());
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
		SimpleNote other = (SimpleNote) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (maxVisibility != other.maxVisibility)
			return false;
		if (noteId == null) {
			if (other.noteId != null)
				return false;
		} else if (!noteId.equals(other.noteId))
			return false;
		if (qcFeedback != other.qcFeedback)
			return false;
		if (qcStatus != other.qcStatus)
			return false;
		if (traineeId == null) {
			if (other.traineeId != null)
				return false;
		} else if (!traineeId.equals(other.traineeId))
			return false;
		if (type != other.type)
			return false;
		if (week == null) {
			if (other.week != null)
				return false;
		} else if (!week.equals(other.week))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", content=" + content + ", week=" + week + ", batchId=" + batchId
				+ ", traineeId=" + traineeId + ", maxVisibility=" + maxVisibility + ", type=" + type + ", qcFeedback="
				+ qcFeedback + ", qcStatus=" + qcStatus + "]";
	}

}
