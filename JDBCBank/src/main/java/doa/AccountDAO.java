package doa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import beans.*;
import util.NotEnoughMoneyException;

public interface AccountDAO 
{
	public ArrayList<Account> getAccounts();
	public ArrayList<Account> getAccountsByUser(int u);
	public Account createAccount(int accountId, int userId, int accountType, float balance);
	public void removeAccount(int accountId);
	public float updateAccount(float f, Account a) throws NotEnoughMoneyException;
}
