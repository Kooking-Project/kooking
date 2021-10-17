package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.ImageDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.UserDTO;
import com.kooking.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	Properties proFile = new Properties();
	
	public UserDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			System.out.println("proFile 로드됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserDTO loginCheck(String id, String pwd)throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql="select * from users where id=? and pwd=?";
		UserDTO dbDTO=null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dbDTO;
	}

	@Override
	public int insert(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into users(no,id,pwd,nickName,gender,enrollDate,profileImg,status) values(?,?,?,?,?,sysdate,?,?)");
			ps.setInt(1, userDTO.getNo());
			ps.setString(2, userDTO.getId());
			ps.setString(3, userDTO.getPwd());
			ps.setString(4, userDTO.getNickName());
			ps.setInt(5, userDTO.getGender());
			ps.setString(6, userDTO.getProfileImg());
			ps.setInt(7, userDTO.getStatus());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<UserDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int imageUpdate(int userNo, ImageDTO img) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userUpdate(UserDTO user) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		String sql=proFile.getProperty("query.userUpdate");
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPwd());
			ps.setString(2, user.getNickName());
			ps.setInt(3, user.getGender());
			ps.setInt(4, user.getNo());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<PostDTO> postSelectByUserNo(int userNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql=proFile.getProperty("query.postSelectByUserNo");
		PostDTO post=null;
		List<PostDTO> postList = new ArrayList<PostDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				post = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				postList.add(post);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return postList;
	}

	@Override
	public List<CommentDTO> commentSelectByUserNo(int userNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql=proFile.getProperty("query.commentSelectByUserNo");
		PostDTO post=null;
		List<PostDTO> postList = new ArrayList<PostDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				post = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				postList.add(post);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return null;
	}

	@Override
	public List<BookmarkDTO> bookmarkSelectByUserNo(int userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
