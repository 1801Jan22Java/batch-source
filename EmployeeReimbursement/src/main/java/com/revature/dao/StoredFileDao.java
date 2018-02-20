package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;

import com.revature.beans.StoredFile;

public interface StoredFileDao {
	public void createStoredFile(String fileName, int requestID, InputStream fileContents);
	
	public StoredFile readStoredFile(int requestID);
	
}
