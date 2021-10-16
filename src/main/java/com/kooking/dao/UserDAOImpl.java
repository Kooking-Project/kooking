package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.ImageDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.UserDTO;
import com.kooking.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public UserDTO loginCheck(String id, String pwd)throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql="select * from users where user_id=? and pwd=?";
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
		
		return 0;
	}

	@Override
	public UserDTO selectAll() throws SQLException {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PostDTO> postSelectByUserNo(int userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentDTO> commentSelectByUserNo(int userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookmarkDTO> bookmarkSelectByUserNo(int userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
