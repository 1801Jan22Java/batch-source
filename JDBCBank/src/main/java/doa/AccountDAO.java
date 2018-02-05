package doa;

import java.util.List;
import beans.*;

public interface AccountDAO 
{
	public List<Account> getAccounts();
	public Account getAccountByUser(int u);
}
