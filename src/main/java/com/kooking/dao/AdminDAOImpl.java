package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kooking.dto.CommentDTO;
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
	public List<UserDTO> userSelectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql=proFile.getProperty("query.userSelectAll");
		UserDTO user=null;
		List<UserDTO> usertList = new ArrayList<UserDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				usertList.add(user);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return usertList;
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

	@Override
	public UserDTO userSelectByNo(int userNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql=proFile.getProperty("query.userSelectByNo");
		UserDTO user=null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return user;
	}
}
