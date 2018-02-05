package doa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import beans.*;

public interface AccountDAO 
{
	public ArrayList<Account> getAccounts();
	public Account getAccountByUser(int u);
	public Account createAccount(int accountId, int userId, String accountType, float balance);
	public void removeAccount(int accountId);
}
