package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.exception.KookingException;
import com.kooking.util.DbUtil;

public class PostDAOImpl extends BoardDAO implements PostDAO {

	// private Properties proFile = DBUtil.getProFile();

	private static final String SPACE = " ";

	String sql;

	/**
	 * 사용자가 쓴 게시물 조회 - user에서 할 예정
	 */
	/*
	 * @Override public List<PostDTO> selectUserPost(int userNo) throws SQLException
	 * { List<PostDTO> PostList = new ArrayList<PostDTO>();
	 * 
	 * if (userNo == 0 && "".equals(userNo)) { //사용자 있으면 sql구문 추가 & int로 받을지
	 * String으로 받을지
	 * 
	 * } sql =
	 * "SELECT POST_NO, POST_TYPE_NO, USER_NO, POST_TITLE, POST_CONTENTS, POST_VIEW_COUNTS, POST_DATE "
	 * + "FROM POSTS WHERE USER_NO=?";
	 * 
	 * con = DbUtil.getConnection(); st = con.prepareStatement(sql);
	 * 
	 * st.setInt(1, userNo);
	 * 
	 * rs = st.executeQuery();
	 * 
	 * while(rs.next()) { PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2),
	 * rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
	 * rs.getString(7)); // 컬럼의 첫번째 값을 int형 가져옴 PostList.add(postDTO); }
	 * 
	 * DbUtil.dbClose(con, st, rs);
	 * 
	 * return PostList; }
	 */

	/**
	 * 게시판 클릭했을 때 해당 게시물 하나보여주기 - 비회원, 회원 공통
	 */

	public PostDTO selectPostDetail(int postNo) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		PostDTO postDTO = null;

		sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U" + " ON P.USER_NO = U.USER_NO AND POST_NO=?";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);
		st.setInt(1, postNo);

		rs = st.executeQuery();

		// int no, int postTypeNo, int userNo, String title, String contents, int
		// counts, String date, String userNicname

		if(rs.next()) {
			postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
				rs.getInt(6), rs.getString(7), rs.getString(8));
		}
		DbUtil.dbClose(con, st, rs);

		return postDTO;
	}

	/**
	 * 조회수 증가
	 */
	public int postViewCount(int postNo) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		sql = "UPDATE POSTS SET POST_VIEW_COUNTS = POST_VIEW_COUNTS+1 WHERE POST_NO=?";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		st.setInt(1, postNo);

		int result = st.executeUpdate();
		
		DbUtil.dbClose(con, st, rs);

		return result;

	}

	/**
	 * 게시판 전체 게시글 조회
	 */
	@Override
	public List<PostDTO> selectPost() throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> postList = new ArrayList<PostDTO>();

		sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		// int no, int postTypeNo, int userNo, String title, String contents, int
		// counts, String date, String userNicname

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
			System.out.println(postDTO.getNo());
			postList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);

		return postList;
		
	}

	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	@Override
	public List<PostDTO> selectPostDate() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> PostList = new ArrayList<PostDTO>();

		sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U" + " ON P.USER_NO = U.USER_NO ORDER BY POST_DATE DESC";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			PostList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);

		return PostList;
	}

	/**
	 * 게시판 게시글 타입별 조회
	 */
	@Override
	public List<PostDTO> selectPostType(int postTypeNo) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> PostList = new ArrayList<PostDTO>();

		sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO AND POST_TYPE_NO=?";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		st.setInt(1, postTypeNo);

		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			PostList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);

		return PostList;
	}

	/**
	 * 게시판 조회수별 조회
	 */
	@Override
	public List<PostDTO> selectPostCount() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> PostList = new ArrayList<PostDTO>();

		sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U" + " ON P.USER_NO = U.USER_NO ORDER BY POST_VIEW_COUNTS DESC";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			PostList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);

		return PostList;
	}

//--------------------------------------------------------------------------------------------------------

	/**
	 * 게시판 게시글 이름으로 검색 - 띄어쓰기 허용 불가
	 */
	@Override
	public List<PostDTO> searchPostName(String postTitle) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> PostList = new ArrayList<PostDTO>();

		sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO AND POST_TITLE LIKE '%?%'";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		st.setString(1, postTitle);

		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			PostList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);

		return PostList;
	}

	/**
	 * 게시판 타입으로 단어로 검색 - 굳이?
	 */
	@Override
	public List<PostDTO> searchPostType(String postType) throws SQLException {
		/*
		 * Connection con = null; PreparedStatement st = null; ResultSet rs = null;
		 * 
		 * List<PostDTO> PostList = new ArrayList<PostDTO>();
		 * 
		 * sql =
		 * "SELECT POSTS.POST_NO, POSTS.POST_TYPE_NO, POSTS.USER_NO, POSTS.POST_TITLE, POSTS.POST_CONTENTS, POSTS.POST_VIEW_COUNTS, POSTS.POST_DATE"
		 * +
		 * " FROM POSTS INNER JOIN POST_TYPE ON(POSTS.POST_TYPE_NO=POST_TYPE.POST_TYPE_NO)\r\n"
		 * + " WHERE POST_TYPE.POST_TYPE_NAME LIKE ?";
		 * 
		 * con = DbUtil.getConnection(); st = con.prepareStatement(sql);
		 * 
		 * st.setString(1, postType);
		 * 
		 * rs = st.executeQuery();
		 * 
		 * 
		 * while(rs.next()) { PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2),
		 * rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
		 * rs.getString(7)); PostList.add(postDTO); }
		 * 
		 * 
		 * DbUtil.dbClose(con, st, rs);
		 * 
		 * return PostList;
		 */
		return null;
	}

}
