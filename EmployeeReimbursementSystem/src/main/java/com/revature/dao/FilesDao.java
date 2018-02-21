package com.revature.dao;

import com.revature.beans.Files;

public interface FilesDao {

	public int createFile(int fileID, String fname, int reqID, String fileURL);
	public Files getFileByID(int fileID);
}
