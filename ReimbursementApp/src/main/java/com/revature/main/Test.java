package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import com.revature.vo.MemberVo;

public class Test {

	public List<MemberVo> returnListMembers (){
		
		List<MemberVo> vos = new ArrayList<MemberVo>();
		vos.add( new MemberVo(1, "Emp1", "0001", "emp001@gmail.com", "1"));
		vos.add( new MemberVo(2, "Emp2", "0002", "emp002@gmail.com", "1"));
		vos.add( new MemberVo(3, "Emp3", "0003", "emp003@gmail.com", "1"));
		vos.add( new MemberVo(4, "Emp4", "0004", "emp004@gmail.com", "1"));
		vos.add( new MemberVo(5, "Emp5", "0005", "emp005@gmail.com", "1"));
		vos.add( new MemberVo(6, "Emp6", "0006", "emp006@gmail.com", "1"));
		vos.add( new MemberVo(7, "Emp7", "0007", "emp007@gmail.com", "1"));
		vos.add( new MemberVo(8, "Emp8", "0008", "emp008@gmail.com", "1"));
		vos.add( new MemberVo(9, "Emp9", "0009", "emp009@gmail.com", "1"));
		vos.add( new MemberVo(10, "Emp10", "00010", "emp0010@gmail.com", "1"));
		vos.add( new MemberVo(11, "Emp11", "00011", "emp0011@gmail.com", "1"));
		return vos;
	}
}
