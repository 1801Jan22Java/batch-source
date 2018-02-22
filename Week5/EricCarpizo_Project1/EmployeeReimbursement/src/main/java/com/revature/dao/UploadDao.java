package com.revature.dao;

import java.util.List;

import com.revature.beans.Upload;

public interface UploadDao 
{
	public List<Upload> getUploads();
	
	public Upload getUploadById(int id);
	
	public Upload getUploadByRequestId(int id);
	
	public Upload addUpload(String filename, int requestId);
	
	public boolean updateUpload(int id, String value, String columnName);
	
	public boolean deleteUpload(int id);
}
