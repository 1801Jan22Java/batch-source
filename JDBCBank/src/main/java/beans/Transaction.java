package beans;

import java.sql.Date;

public class Transaction
{
	public Transaction(int accountId, float balanceChange, Date date, int transactionId) {
		super();
		this.accountId = accountId;
		this.balanceChange = balanceChange;
		this.date = date;
		this.transactionId = transactionId;
	}
	private int accountId;
	private float balanceChange;
	private Date date;
	private int transactionId;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public float getBalanceChange() {
		return balanceChange;
	}
	public void setBalanceChange(float balanceChange) {
		this.balanceChange = balanceChange;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}
