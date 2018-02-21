package com.revature.beans;

import java.time.LocalDate;

public class Notes {

	public Notes(int noteID, int requestID, LocalDate noteDate, String noteMessage, int notetakerID) {
		super();
		this.noteID = noteID;
		this.requestID = requestID;
		this.noteDate = noteDate;
		this.noteMessage = noteMessage;
		this.notetakerID = notetakerID;
	}
	
	private int noteID;
	private int requestID;
	private LocalDate noteDate;
	private String noteMessage;
	private int notetakerID;
	
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public LocalDate getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(LocalDate noteDate) {
		this.noteDate = noteDate;
	}
	public String getNoteMessage() {
		return noteMessage;
	}
	public void setNoteMessage(String noteMessage) {
		this.noteMessage = noteMessage;
	}
	public int getNotetakerID() {
		return notetakerID;
	}
	public void setNotetakerID(int notetakerID) {
		this.notetakerID = notetakerID;
	}
	
	
	@Override
	public String toString() {
		return "Notes [noteID=" + noteID + ", requestID=" + requestID + ", noteDate=" + noteDate + ", noteMessage="
				+ noteMessage + "notetakerID=" + notetakerID +"]";
	}
	
	
}
