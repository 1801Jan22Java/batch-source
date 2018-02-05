package doa;

import java.util.ArrayList;

import beans.UserInfo;

public interface UserInfoDAO 
{
	public ArrayList<UserInfo> getUserInfo();
	public UserInfo getUserinfoByUserID(int id);
}
