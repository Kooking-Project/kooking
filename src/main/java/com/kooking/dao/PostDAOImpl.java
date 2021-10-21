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

import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.paging.Pagenation;
import com.kooking.util.DbUtil;

public class PostDAOImpl extends BoardDAO implements PostDAO {

	Properties proFile = new Properties();

	public PostDAOImpl() {
		try {
			// proFile에 외부 ~.properites 파일을 로딩한다.
			// proFile.load(new FileInputStream("src/dbQuery.properties"));

			// 현 프로젝트 런타임될때 즉 서버에서 실행될때 classes폴더를 동적으로 가져와서 경로를 설정해야한다.
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));

			System.out.println("query : " + proFile.getProperty("query.select"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// private Properties proFile = DBUtil.getProFile();

	String sql;

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

		if (rs.next()) {
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

	/*
	 * @Override public List<PostDTO> selectPost() throws Exception { Connection con
	 * = null; PreparedStatement st = null; ResultSet rs = null;
	 * 
	 * List<PostDTO> postList = new ArrayList<PostDTO>();
	 * 
	 * sql =
	 * "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO ORDER BY P.POST_NO DESC"
	 * ;
	 * 
	 * con = DbUtil.getConnection(); st = con.prepareStatement(sql);
	 * 
	 * rs = st.executeQuery();
	 * 
	 * // int no, int postTypeNo, int userNo, String title, String contents, int //
	 * counts, String date, String userNicname
	 * 
	 * while (rs.next()) { PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2),
	 * rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
	 * rs.getString(7), rs.getString(8)); System.out.println(postDTO.getNo());
	 * postList.add(postDTO); }
	 * 
	 * DbUtil.dbClose(con, st, rs);
	 * 
	 * return postList;
	 * 
	 * }
	 */

	/**
	 * 게시판 전체 게시글 조회 (페이징) by 김찬원
	 */
	@Override
	public Entry<List<PostDTO>, Pagenation> selectPost(Pagenation page) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> postList = new ArrayList<PostDTO>();
		int count = getSelectTotalCount(); // 전체 게시글 수
		int totalPage = (int) Math.ceil(count / page.getPageCnt());

		page.setTotal(totalPage);

		// String sql = proFile.getProperty("query.pagingSelect");
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO ORDER BY P.POST_NO DESC)"
				+ " WHERE RNUM BETWEEN ? AND ?";

		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);
		st.setInt(1, (page.getPageNo() - 1) * page.getPageSize() + 1);
		st.setInt(2, page.getPageNo() * page.getPageSize());
		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			System.out.println(postDTO.getNo());
			postList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);
		
		return new SimpleEntry<List<PostDTO>, Pagenation>(postList, page);
	}

	/**
	 * 전체게시물 수 가져오기 by 김찬원 - 완성하기
	 * 
	 */

	private int getSelectTotalCount() throws SQLException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		int result = 0;
		String sql = proFile.getProperty("query.totalCount");
		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		if (rs.next()) {
			result = rs.getInt(1);
		}

		DbUtil.dbClose(con, st, rs);

		return result;
	}

	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	@Override
	public Entry<List<PostDTO>, Pagenation> selectPostDate(Pagenation page) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> postList = new ArrayList<PostDTO>();
		int count = getSelectTotalCount(); // 전체 게시글 수
		int totalPage = (int) Math.ceil(count / page.getPageCnt());

		page.setTotal(totalPage);

		/*
		 * sql =
		 * "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
		 * + " FROM POSTS P INNER JOIN USERS U" +
		 * " ON P.USER_NO = U.USER_NO ORDER BY POST_DATE DESC";
		 */

		String sql = "SELECT * FROM (SELECT  ROWNUM RNUM, P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME\r\n"
				+ "FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO ORDER BY P.POST_NO DESC) \r\n"
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);
		st.setInt(1, (page.getPageNo() - 1) * page.getPageSize() + 1);
		st.setInt(2, page.getPageNo() * page.getPageSize());
		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			System.out.println(postDTO.getNo());
			postList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);
		
		return new SimpleEntry<List<PostDTO>, Pagenation>(postList, page);
	}

	/**
	 * 게시판 게시글 타입별 조회
	 */
	@Override
	public Entry<List<PostDTO>, Pagenation> selectPostType(Pagenation page, int postTypeNo) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> postList = new ArrayList<PostDTO>();
		int count = getSelectTotalCount(); // 전체 게시글 수
		int totalPage = (int) Math.ceil(count / page.getPageCnt());

		page.setTotal(totalPage);

		/*
		 * sql =
		 * "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
		 * +
		 * " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO AND POST_TYPE_NO=?"
		 * ;
		 */

		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO AND POST_TYPE_NO=? ORDER BY P.POST_NO DESC)"
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);
		st.setInt(1, postTypeNo);
		st.setInt(2, (page.getPageNo() - 1) * page.getPageSize() + 1);
		st.setInt(3, page.getPageNo() * page.getPageSize());
		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			System.out.println(postDTO.getNo());
			postList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);
		
		return new SimpleEntry<List<PostDTO>, Pagenation>(postList, page);
	}

	/**
	 * 게시판 조회수별 조회
	 */
	@Override
	public Entry<List<PostDTO>, Pagenation> selectPostCount(Pagenation page) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> postList = new ArrayList<PostDTO>();
		int count = getSelectTotalCount(); // 전체 게시글 수
		int totalPage = (int) Math.ceil(count / page.getPageCnt());
		page.setTotal(totalPage);
		
		/*sql = "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U" + " ON P.USER_NO = U.USER_NO ORDER BY POST_VIEW_COUNTS DESC";*/

		sql = "SELECT * FROM (SELECT ROWNUM RNUM, P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO ORDER BY POST_VIEW_COUNTS DESC)"
				+ " WHERE RNUM BETWEEN ? AND ?";
		
		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);
		st.setInt(2, (page.getPageNo() - 1) * page.getPageSize() + 1);
		st.setInt(3, page.getPageNo() * page.getPageSize());
		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			System.out.println(postDTO.getNo());
			postList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);
		
		return new SimpleEntry<List<PostDTO>, Pagenation>(postList, page);
	}

//--------------------------------------------------------------------------------------------------------

	/**
	 * 게시판 게시글 이름으로 검색 - 띄어쓰기 허용 불가
	 */
	@Override
	public Entry<List<PostDTO>, Pagenation> searchPostName(Pagenation page, String postName) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<PostDTO> postList = new ArrayList<PostDTO>();
		int count = getSelectTotalCount(); // 전체 게시글 수
		int totalPage = (int) Math.ceil(count / page.getPageCnt());
		page.setTotal(totalPage);
		
		/*
		 * sql =
		 * "SELECT P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
		 * +
		 * " FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO AND POST_TITLE LIKE '%?%'"
		 * ;
		 */

		sql = "SELECT * FROM (SELECT ROWNUM RNUM, P.POST_NO, P.POST_TYPE_NO, P.USER_NO, P.POST_TITLE, P.POST_CONTENTS, P.POST_VIEW_COUNTS, TO_CHAR(P.POST_DATE, 'YYYYMMDD'), U.USER_NICNAME"
				+ "FROM POSTS P INNER JOIN USERS U ON P.USER_NO = U.USER_NO AND POST_TITLE LIKE '%?%' ORDER BY POST_NO DESC)"
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		con = DbUtil.getConnection();
		st = con.prepareStatement(sql);

		st.setString(1, postName);
		st.setInt(2, (page.getPageNo() - 1) * page.getPageSize() + 1);
		st.setInt(3, page.getPageNo() * page.getPageSize());
		rs = st.executeQuery();

		while (rs.next()) {
			PostDTO postDTO = new PostDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
			System.out.println(postDTO.getNo());
			postList.add(postDTO);
		}

		DbUtil.dbClose(con, st, rs);
		
		return new SimpleEntry<List<PostDTO>, Pagenation>(postList, page);
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
