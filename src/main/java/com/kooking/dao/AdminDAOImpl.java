package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kooking.dto.UserDTO;
import com.kooking.util.DbUtil;


public class AdminDAOImpl implements AdminDAO {
	Properties proFile = new Properties();
	
	public AdminDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			System.out.println("proFile 로드됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int checkUserStatues(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("query.checkUserStatues");
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public int changeUserStatus(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.changeUserStatus");
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getStatus());
			ps.setInt(2, user.getNo());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
