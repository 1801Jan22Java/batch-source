package com.revature.dao;

import java.util.List;

import com.revature.vo.DepartmentsVo;

public interface MainDao {

	List<DepartmentsVo> getDepartmentsList();
	void callStoredProcedure(int department_id);
}
