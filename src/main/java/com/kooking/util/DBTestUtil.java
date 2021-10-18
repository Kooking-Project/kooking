package com.kooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB 테스트를 위한 임시클래스 (삭제 예정)
 * @author Park
 *
 */


public class DBTestUtil {
	private static final String DB_URL = "jdbc:oracle:thin:@database-1.crewhtff8sbm.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
	private static final String DB_ID = "admin";
	private static final String DB_PWD = "admin1012";
	/**
	 * 로드
	 * */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
	}
	
	/**
	 * 닫기
	 * */
	public static void dbClose(Connection con, PreparedStatement st, ResultSet rs) {
		try {
			if(con != null) con.close();
			if(st != null) st.close();
			if(rs != null) rs.close();			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dbClose(AutoCloseable ...acArr) {
		if(acArr == null || acArr.length<=0) {
			return;
		}
		
		for(AutoCloseable ac : acArr) {
			if(ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
//	public static void main(String[] args) throws Exception{
//		Connection con = DBTestUtil.getConnection();
//		PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS");
//		ResultSet rs = ps.executeQuery();
//		UserDTO user = new UserDTO();
//		while(rs.next()) {
//			user.setNo(rs.getInt(1));
//			user.setId(rs.getString(2));
//			user.setPwd(rs.getString(3));
//			user.setNickName(rs.getString(4));
//			user.setGender(rs.getInt(5));
//			user.setEnrollDate(rs.getString(6));
//			user.setProfileImg(rs.getString(7));
//			user.setStatus(rs.getInt(8));
//		}
//		System.out.println(user);
//		DBTestUtil.dbClose(con,ps,rs);
//	}
}
