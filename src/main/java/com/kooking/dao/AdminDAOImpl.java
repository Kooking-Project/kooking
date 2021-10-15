package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kooking.dto.UserDTO;
import com.kooking.util.DbUtil;


public class AdminDAOImpl implements AdminDAO {

	@Override
	public int checkUserStatues(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select USER_STATUS from USERS where USER_NO=?";
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
		String sql = "update USERS set USER_STATUS=? where USER_NO=?";
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
