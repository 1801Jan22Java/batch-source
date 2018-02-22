package com.revature.dao;

import java.util.List;

import com.revature.vo.ImgVo;
import com.revature.vo.RequestVo;

public interface RequestDao {

	void insertImg(String filename, int request_no);
	RequestVo getRequestByRNo (int request_no);
	List<ImgVo> getImgByRNo(int request_no);
	List<RequestVo> getRequests(int pageNo);
	void resolveRequest(int status, int request_no, int manager_no);
}
