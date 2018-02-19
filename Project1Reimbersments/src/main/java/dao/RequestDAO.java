package dao;

import java.sql.Blob;
import java.util.ArrayList;

import beans.Document;
import beans.Request;
import beans.Status;

public interface RequestDAO 
{
	public ArrayList<Request> getRequest();
	public ArrayList<Document> getRequestDocuments(int requestId);
	public float getAmount(int requestId);
	public int getStatus(int requestId);
	public boolean addRequest(int employeeId, float amountRequested);
	public float updateAmountRequested(int requestId, float newAmount);
	public boolean changeStaus(int requestId, int newStatus);
}
