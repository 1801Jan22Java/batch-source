package com.revature.dao;

import com.revature.beans.*;

public interface UploadDao {
	public boolean getUploads(Request thisRequest);
	public boolean isDuplicate(String randomFileName);
	public boolean addUpload(String displayName, Request thisRequest, Employee thisEmployee);
}
