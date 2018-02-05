package doa;

import java.util.List;
import beans.*;
public interface AccountTypeDAO 
{
	public List<AccountType> getAccountTypes();
	public String getAccountName(int id);
	public void addAccountType(int id, String name);
}
