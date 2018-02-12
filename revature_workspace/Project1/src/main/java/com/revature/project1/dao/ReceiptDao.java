package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.Receipt;

public interface ReceiptDao {
	public List<Receipt> getReceipts();
	public Receipt getReceiptByEmployee(Employee emp);
	public Receipt getReceiptByID(int id);
	public void addReceipt(Receipt receipt);
	public Receipt createReceiptObj();
}
