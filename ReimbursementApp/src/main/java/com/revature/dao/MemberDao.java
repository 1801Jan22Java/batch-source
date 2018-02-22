package com.revature.dao;

import java.util.HashMap;
import java.util.List;

import com.revature.vo.MemberVo;
import com.revature.vo.RequestVo;

public interface MemberDao {

	MemberVo getMemberById(String id);
	MemberVo getMemberByNo(int memberNo);
	void updateMember (MemberVo mVo);
	int insertMember(MemberVo memberVo);
	int insertRequest(RequestVo requestVo);
	int ifEmailExist(String email, int empNo);
	int ifMemberExist(String id);
	int ifRightPwd(String id, String pwd);
	int ifRequestExistByEmployeeNo(int empNo);
	List<RequestVo> getRequestsByEmployeeNo(int empNo, int pageNo);
	 List<HashMap<String, Object>> getRequestsOfAllEmployees(int pageNo);
}
