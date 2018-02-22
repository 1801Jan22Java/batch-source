package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.lang.Math.toIntExact;
import com.revature.exception.NotExistUserException;
import com.revature.exception.WrongPassworException;
import com.revature.util.ConnectionUtil;
import com.revature.util.LoggingClass;
import com.revature.vo.MemberVo;
import com.revature.vo.RequestVo;

public class MemberDaoImpl implements MemberDao {

	/*
	 * public static final int MEMBER_RIGHT_PW = 1; public static final int
	 * MEMBER_MANAGER_LV = 0; public static final int MEMBER_EMPLOYEE_LV = 1;
	 */

	public static String filename = "connection.properties";
	public static LoggingClass lc = new LoggingClass();

	@Override
	public MemberVo getMemberById(String id) {

		MemberVo mVo = new MemberVo();
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				mVo.setNo(rs.getInt("NO"));
				mVo.setId(rs.getString("ID"));
				mVo.setPwd(rs.getString("PWD"));
				mVo.setEmail(rs.getString("EMAIL"));
				mVo.setLv(rs.getString("LV"));
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mVo;
	}

	@Override
	public MemberVo getMemberByNo(int memberNo) {

		MemberVo mVo = new MemberVo();
		String sql = "SELECT * FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				mVo.setNo(rs.getInt("NO"));
				mVo.setId(rs.getString("ID"));
				mVo.setPwd(rs.getString("PWD"));
				mVo.setEmail(rs.getString("EMAIL"));
				mVo.setLv(rs.getString("LV"));
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mVo;
	}
	
	 @Override
	public int ifEmailExist(String email, int empNo) {
		 String sql = "SELECT COUNT(*) AS CNT FROM MEMBER WHERE EMAIL = ?  AND NO != ?";
			PreparedStatement pstmt = null;

			int cnt = 0;
			try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setInt(2, empNo);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					cnt = rs.getInt("CNT"); // if cnt is 0, not-exist
				}
				 //if (cnt < 1) { throw new NotExistUserException(); }
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
			} catch (IOException e) {
			}
	
		 return cnt;
	}
	 @Override
	public void updateMember(MemberVo mVo) {
		 
		 String sql = "UPDATE MEMBER SET " + 
		 		" PWD =  ? ,  " + 
		 		" EMAIL = ? " + 
		 		" WHERE NO = ? ";
			PreparedStatement pstmt = null;

			try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, mVo.getPwd());
				pstmt.setString(2, mVo.getEmail());
				pstmt.setInt(3, mVo.getNo());
				
				pstmt.executeUpdate();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

			}
			
	}
	
	@Override
	public int insertMember(MemberVo memberVo) {

		int result = 0;

		String sql = "INSERT INTO MEMBER (NO, ID, PWD, EMAIL, LV)  "
				+ "VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPwd());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getLv());

			pstmt.executeUpdate();
			result = 1;
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return result;
	}

	@Override
	public int insertRequest(RequestVo rVo) {
		String sql = "INSERT INTO REQUEST (NO, AMOUNT, PURPOSE, EMPLOYEE_NO) VALUES (REQUEST_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = null;

		int request_id = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String key[] = {"NO"};
			pstmt = con.prepareStatement(sql, key);
			
			pstmt.setInt(1, rVo.getAmount());
			pstmt.setString(2, rVo.getPurpose());
			pstmt.setInt(3, rVo.getEmployee_no());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				request_id = toIntExact(rs.getLong(1));
			}
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		return request_id; 
	}

	@Override
	public int ifMemberExist(String id) {
		String sql = "SELECT COUNT(*) AS CNT FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = null;

		int cnt = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt("CNT"); // if cnt is 0, not-exist
			}
			/*
			 * if (cnt < 1) { throw new NotExistUserException(); }
			 */
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} /*
			 * catch (NotExistUserException e) {
			 * 
			 * }
			 */
		return cnt;
	}

	@Override
	public int ifRightPwd(String id, String pwd) {
		String sql = "SELECT CASE WHEN PWD = ? THEN 1 ELSE 0 END AS IFRIGHTPW" + " FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = null;

		int ifRightPW = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ifRightPW = rs.getInt("IFRIGHTPW"); // if cnt is 0, not-exist
			}
			if (ifRightPW < 1) {
				throw new WrongPassworException();
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WrongPassworException e) {

		}
		return ifRightPW;
	}

	@Override
	public int ifRequestExistByEmployeeNo(int empNo) {
		String sql = "SELECT COUNT(*) AS CNT "
				+ "FROM MEMBER M  JOIN REQUEST R  ON M.NO = R.EMPLOYEE_NO  WHERE R.EMPLOYEE_NO = ? ";
		PreparedStatement pstmt = null;
		int cnt = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("CNT");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<RequestVo> getRequestsByEmployeeNo(int empNo, int pageNo) {
		String sql = "SELECT C.THEROW AS THEROW, C.R_NO AS R_NO, C.STATUS AS STATUS, " + 
				"								C.DAY AS DAY, C.AMOUNT AS AMOUNT, C.PURPOSE AS PURPOSE " + 
				"				FROM ( SELECT ROWNUM AS THEROW, A.R_NO AS R_NO, A.STATUS AS STATUS,  " + 
				"             					 A.DAY AS DAY, A.AMOUNT AS AMOUNT, A.PURPOSE AS PURPOSE " + 
				"        						FROM  (SELECT R.NO AS R_NO, R.STATUS AS STATUS,  " + 
				"               								TO_CHAR(R.DAY, 'YYYY-MM-DD') AS DAY,  " + 
				"                								R.AMOUNT AS AMOUNT, R.PURPOSE AS PURPOSE  " + 
				"                								FROM MEMBER M  JOIN REQUEST R   " + 
				"                								ON M.NO = R.EMPLOYEE_NO   " + 
				"        						WHERE R.EMPLOYEE_NO = ? ORDER BY R.NO DESC)A)C  " + 
				"				WHERE C.THEROW  BETWEEN (?*10-9) AND (?*10) ";
		PreparedStatement pstmt = null;

		List<RequestVo> vos = new ArrayList<RequestVo>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			pstmt.setInt(2, pageNo);
			pstmt.setInt(3, pageNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RequestVo vo = new RequestVo(rs.getInt("R_NO"), rs.getInt("STATUS"), rs.getString("DAY"),
						rs.getInt("AMOUNT"), rs.getString("PURPOSE"), empNo);
				vo.setRowNum(rs.getInt("THEROW"));
				vos.add(vo);
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vos;
	}

	@Override
	public List<HashMap<String, Object>> getRequestsOfAllEmployees(int pageNo) {
		
		String sql = "SELECT C.THEROW AS THEROW, C.EMPLOYEE_NO AS EMPLOYEE_NO, C.SUM AS TOTAL_AMOUNT, C.CNT AS CNT, " + 
				"(SELECT ID FROM MEMBER WHERE NO=C.EMPLOYEE_NO) AS EMPLOYEE_ID " + 
				"FROM (SELECT ROWNUM AS THEROW, A.EMPLOYEE_NO AS EMPLOYEE_NO, A.SUM AS SUM, A.CNT AS CNT " + 
				"FROM (SELECT EMPLOYEE_NO, SUM(AMOUNT) AS SUM, COUNT(*) AS CNT " + 
				"FROM REQUEST  GROUP BY EMPLOYEE_NO " + 
				"ORDER BY COUNT(*) DESC) A) C " + 
				"WHERE C.THEROW BETWEEN ( ? *10-9) AND ( ? *10) ";
		PreparedStatement pstmt = null;
		List<HashMap<String, Object>> vos = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			pstmt.setInt(2, pageNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("theRow", rs.getInt("THEROW"));
				map.put("employee_no", rs.getInt("EMPLOYEE_NO"));
				map.put("total_amount", rs.getInt("TOTAL_AMOUNT"));
				map.put("cnt", rs.getInt("CNT"));
				map.put("employee_id", rs.getString("EMPLOYEE_ID"));
				vos.add(map);
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vos;
	}
	 
}
