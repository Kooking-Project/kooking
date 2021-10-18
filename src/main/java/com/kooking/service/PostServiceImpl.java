package com.kooking.service;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dao.PostDAO;
import com.kooking.dao.PostDAOImpl;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;

public class PostServiceImpl implements PostService {
	private PostDAO dao = new PostDAOImpl();
	
	/**
	 * 게시판 게시글 추가 - 제목, 내용, 작성자(사용자 번호), 날짜
	 */
	public int insertPost(PostDTO postDTO) throws Exception {
		int result = 0;
	
		result = dao.insertPost(postDTO);

		return result;
	}
	
	/**
	 * 게시판 게시글 수정 - 게시글 번호, 사용자 번호, 조회수, 게시글 타입, 조회수, 작성일 변경 불가
	 */
	@Override
	public int updatePost(PostDTO dto) throws Exception {
		int result = 0;
		
		result = dao.updatePost(dto);
		
		return result;
	}



	@Override
	public int deletePost(int userNo, int postNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int deleteCommentCheck(int userNo, int postNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<PostDTO> selectUserPost(int userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDTO> selectPost(String userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDTO> selectPostDate() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDTO> selectPostType(int postTypeNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDTO> selectPostCount() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDTO> searchPostName(String postTitle) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDTO> searchPostType(String postType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RecipeDTO> selectNewRecipe(String todayDate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RecipeDTO> selectRankingRecipe() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<RecipeDTO> selectTodayRecipe() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<PostDTO> boardList(String userNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	/*
	 * @Override public List<PostDTO> postList(String userNo) throws Exception {
	 * return dao.selectPost(userNo); }
	 */
	
	

	/*
	 * @Override public List<PostDTO> boardList(String userNo) throws Exception { //
	 * TODO Auto-generated method stub return null; }
	 */
	
}
