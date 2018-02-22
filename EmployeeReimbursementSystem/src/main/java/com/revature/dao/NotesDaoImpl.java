package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


import com.revature.beans.Notes;
import com.revature.util.ConnectionUtil;

public class NotesDaoImpl implements NotesDao{

	private static String filename = "connection.properties";

	//Creates a Note Object
	public int createNote(int noteID, int reqID, LocalDate noteDate, String noteMess, int notetakerID) {
		int noteVal = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO NOTES (NOTE_ID, REQUEST_ID, NOTE_DATE, NOTE_MESSAGE, NOTETAKER_ID) "
					+" VALUES(NOTE_NUM_SEQ.NEXTVAL,?,SYSDATE,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  reqID);
			pstmt.setString(2,  noteMess);
			pstmt.setInt(3,  notetakerID);
			noteVal = pstmt.executeUpdate();
		con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return noteVal;
	}

	//Grabs a note by ID
	public Notes getNoteByID(int noteID) {
		PreparedStatement pstmt = null;
		Notes notes = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM NOTES WHERE NOTE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noteID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int nID = rs.getInt("NOTE_ID");
				int reqID = rs.getInt("REQUEST_ID");
				LocalDate noteDate = rs.getDate("NOTE_DATE").toLocalDate();
				String noteMessage = rs.getString("NOTE_MESSAGE");
				int notetakerID = rs.getInt("NOTETAKER_ID");
				notes = new Notes(nID, reqID, noteDate, noteMessage, notetakerID);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return notes;
	}
	
}
