package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.paging.Pagenation;
import com.kooking.util.DBTestUtil;
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
		String sql="SELECT * FROM USERS WHERE USER_ID=? AND USER_PWD=?";
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
			ps = con.prepareStatement("insert into users(user_no,user_id,user_pwd,user_nicName,user_gender,"
					+ "user_enroll_Date,user_profile_Img,user_status) values(USER_NO_SEQ.nextval,?,?,?,?,sysdate,?,?)");
			
			ps.setString(1, userDTO.getId());
			ps.setString(2, userDTO.getPwd());
			ps.setString(3, userDTO.getNickName());
			ps.setInt(4, userDTO.getGender());
			ps.setString(5, userDTO.getProfileImg());
			ps.setInt(6, userDTO.getStatus());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
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
			ps.setString(4, user.getProfileImg());
			ps.setInt(5, user.getNo());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	public int getTotalPostNum(Connection con, int userNo) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM POSTS where USER_NO=? and POST_TYPE_NO=1");
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getInt(1)==0)
					return 1;
				result = rs.getInt(1);
			}
		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}
	
	@Override
	public Entry<List<RecipeWrapper>, Pagenation> postSelectByUserNo(int userNo, Pagenation page) throws Exception {
		Connection con = null; // 커넥션이 없다면 새로운 커넥션을 생성
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT * FROM (SELECT A.*,ROWNUM RNUM  FROM VIEW_RECIPES A WHERE USER_NO=?) WHERE RNUM BETWEEN ? AND ? ORDER BY POST_DATE DESC";
		List<RecipeWrapper> postList = new ArrayList<RecipeWrapper>();
		Entry<List<RecipeWrapper>, Pagenation> result = null;
		
		int count = getTotalPostNum(con, userNo);
		int totalPage = (int) Math.ceil(page.getPageSize() / count);
		page.setPageCnt(totalPage);
		page.setTotal(count);
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, (page.getPageNo() - 1) * page.getPageSize() + 1);
			ps.setInt(3, page.getPageNo() * page.getPageSize());
			RecipeWrapper postWrap = new RecipeWrapper();

			rs = ps.executeQuery();
			while(rs.next()) {
				postWrap.setPost(new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
				postWrap.setRecipe(new RecipeDTO(rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
				
				postList.add(postWrap);
			}
			result = new SimpleEntry<List<RecipeWrapper>, Pagenation>(postList, page);
		}finally {
			DBTestUtil.dbClose(con, ps, rs);
		}	
		return result;
	}

	public int getTotalCommentNum(Connection con, int userNo) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM COMMENTS where USER_NO=?");
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getInt(1)==0)
					return 1;
				result = rs.getInt(1);
			}
		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}
	@Override
	public Entry<List<CommentDTO>, Pagenation> commentSelectByUserNo(int userNo, Pagenation page) throws Exception {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql="SELECT * FROM (select A.*, ROWNUM RNUM from COMMENTS A where USER_NO=?) WHERE RNUM BETWEEN ? AND ? ORDER BY COMMENT_DATE DESC";
		CommentDTO comment=null;
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		Entry<List<CommentDTO>, Pagenation> result = null;
		
		int count = getTotalCommentNum(con, userNo);
		int totalPage = (int) Math.ceil(page.getPageSize() / count);
		page.setPageCnt(totalPage);
		page.setTotal(count);
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, (page.getPageNo() - 1) * page.getPageSize() + 1);
			ps.setInt(3, page.getPageNo() * page.getPageSize());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				comment = new CommentDTO(rs.getInt(1), rs.getInt(3), rs.getInt(2), rs.getInt(6), rs.getString(4), rs.getString(5), (rs.getInt(7)==0?false:true) );
				commentList.add(comment);
			}
			result = new SimpleEntry<List<CommentDTO>, Pagenation>(commentList, page);
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	
	public int getTotalBookmarkNum(Connection con, int userNo) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM BOOKMARKS where USER_NO=?");
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getInt(1)==0)
					return 1;
				result = rs.getInt(1);
			}
		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}
	@Override
	public Entry<List<BookmarkDTO>, Pagenation> bookmarkSelectByUserNo(int userNo, Pagenation page) throws Exception {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql="select * from BOOKMARKS where USER_NO=?";
		
		BookmarkDTO bookmark=null;
		List<BookmarkDTO> bookmarkList = new ArrayList<BookmarkDTO>();
		Entry<List<BookmarkDTO>, Pagenation> result = null;
		
		int count = getTotalBookmarkNum(con, userNo);
		int totalPage = (int) Math.ceil(page.getPageSize() / count);
		page.setPageCnt(totalPage);
		page.setTotal(count);
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				bookmark = new BookmarkDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				bookmarkList.add(bookmark);
			}
			result = new SimpleEntry<List<BookmarkDTO>, Pagenation>(bookmarkList, page);
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public boolean idCheck(String id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		boolean result = false; //중복 X 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select USER_ID from users where USER_ID=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true; //중복 O
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public int bookmarkInsert(int userNo, int postNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql=proFile.getProperty("query.bookmarkInsert");
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, userNo);
			ps.setInt(2, postNo);
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int bookmarkDelete(int userNo, int postNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql=proFile.getProperty("query.bookmarkDelete");
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, userNo);
			ps.setInt(2, postNo);
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public boolean pwdCheck(String pwd) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		boolean result = false; //중복 X 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select USER_PWD from users where USER_PWD=?");
			ps.setString(1, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true; //중복 O
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public boolean nicknameCheck(String nickName) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		boolean result = false; //중복 X 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select USER_NICNAME from users where USER_NICNAME=?");
			ps.setString(1, nickName);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true; //중복 O
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	public int getTotalcommunityNum(Connection con, int userNo) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM POSTS where USER_NO=? and POST_TYPE_NO in (3,4,5)");
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getInt(1)==0)
					return 1;
				result = rs.getInt(1);
			}
		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}
	
	@Override
	public Entry<List<PostDTO>, Pagenation> communitySelectByUserNo(int userNo, Pagenation page) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT * FROM (SELECT A.*,ROWNUM RNUM  FROM POSTS A WHERE USER_NO=? and POST_TYPE_NO in (3,4,5) ) WHERE RNUM BETWEEN ? AND ? ORDER BY POST_DATE DESC";
		PostDTO community = null;
		List<PostDTO> communityList = new ArrayList<PostDTO>();
		Entry<List<PostDTO>, Pagenation> result = null;
		
		int count = getTotalcommunityNum(con, userNo);
		int totalPage = (int) Math.ceil(page.getPageSize() / count);
		page.setPageCnt(totalPage);
		page.setTotal(count);
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, (page.getPageNo() - 1) * page.getPageSize() + 1);
			ps.setInt(3, page.getPageNo() * page.getPageSize());

			rs = ps.executeQuery();
			while(rs.next()) {
				community = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				communityList.add(community);
			}
			result = new SimpleEntry<List<PostDTO>, Pagenation>(communityList, page);
		}finally {
			DBTestUtil.dbClose(con, ps, rs);
		}	
		return result;
	}

}
