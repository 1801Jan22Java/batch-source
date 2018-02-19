package dao;

import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;

import beans.Document;

public interface DocumentDAO 
{
	public ArrayList<Document> getDocuments();
	public ArrayList<Document> getDocuments(int requestId);
	public boolean uploadDocument(int rid, byte[] pic);
	public ArrayList<Blob> downloadDocuments(int rid);
	public boolean removeDocuments(int rid);
	public boolean updateDocument(int id,byte[] pic);
}
