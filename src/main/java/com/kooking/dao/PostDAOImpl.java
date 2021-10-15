package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.exception.KookingException;
import com.kooking.util.DbUtil;

public class PostDAOImpl implements PostDAO {

	//private Properties proFile = DBUtil.getProFile();
	
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	/**
	 * 게시판 게시글 추가
	 */
	@Override
	public void insertPost(int userNo, PostDTO postDTO) throws SQLException{
		int result = 0;
		
		try {
			
			//String sql = proFile.getProperty("post.insertPost");
			//게시글 번호빼고 저장
			con = DbUtil.getConnection();
			st = con.prepareStatement("INSERT INTO POSTS(POST_TYPE_NO, USER_NO, POST_TITLE, POST_CONTENTS, POST_VIEW_COUNTS,"
					+ " POST_DATE) VALUES(?,?,?,?,?,?,SYSDATE)");
			
			st.setInt(1, postDTO.getPostTypeNo());
			st.setInt(2, postDTO.getUserNo());
			st.setString(3, postDTO.getTitle());
			st.setString(4, postDTO.getContents());
			st.setInt(5, postDTO.getCounts());
			
			result = st.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, st);
		}
	
	}

	/**
	 * 게시판 게시글 수정
	 */
	@Override
	public int updatePost(int userNo, PostDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 게시판 게시글 삭제 - 관리자도 하나씩 삭제
	 */
	@Override
	public int deletePost(int userNo, int postNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 게시판 전체 게시글 조회
	 */
	@Override
	public List<PostDTO> selectPost() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	@Override
	public List<PostDTO> selectPostDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 게시글 타입별 조회
	 */
	@Override
	public List<PostDTO> selectPostType(int postTypeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 조회수별 조회
	 */
	@Override
	public List<PostDTO> selectPostCount() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 게시글 이름으로 검색
	 */
	@Override
	public List<PostDTO> selectPostName(String postTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 타입으로 검색 
	 */
	@Override
	public List<PostDTO> selectPost(String postType) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 상위 공간 오늘의 신규 레시피
	 */
	@Override
	public List<RecipeDTO> selectNewRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 상위 레시피 랭킹
	 */
	@Override
	public List<RecipeDTO> selectRankingRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 게시판 오늘의 추천 레시피
	 */
	@Override
	public List<RecipeDTO> selectTodayRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

}
