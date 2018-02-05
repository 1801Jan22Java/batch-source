package doa;

import java.util.List;
import beans.*;

public interface TransactionDAO 
{
	public List<Transaction> getTransactions();
	public Transaction getTransactionByUser(int user);
}
