package com.revature.dao;

import java.time.LocalDate;

import com.revature.beans.Notes;

public interface NotesDao {

	public int createNote(int noteID, int reqID, LocalDate noteDate, String noteMess, int notetakerID);
	public Notes getNoteByID(int noteID);
}
