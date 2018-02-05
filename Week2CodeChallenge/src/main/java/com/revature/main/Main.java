package com.revature.main;

import java.util.List;

import com.revature.dao.MainDao;
import com.revature.dao.MainDaoImpl;
import com.revature.vo.DepartmentsVo;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	MainDao dao = new MainDaoImpl();
		
		List<DepartmentsVo> depts = dao.getDepartmentsList();
		for (DepartmentsVo vo : depts ) {
			System.out.println(vo.toString());
		}
		
		dao.callStoredProcedure(3);
    }
}
