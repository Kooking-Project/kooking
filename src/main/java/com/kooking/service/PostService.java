package com.kooking.service;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dao.PostDAOImpl;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;

public class PostService {
	PostDAOImpl postDaoImpl = new PostDAOImpl();
	
	/**
	 * 게시판 게시글 추가 - 제목, 내용, 작성자, 날짜
	 */
	public void insertPost(int userNo ,PostDTO dto) {
		try {
			postDaoImpl.insertPost(userNo, dto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 게시판 게시글 수정
	 */
	//public int updatePost(int userNo, PostDTO dto) { }
	
	/**
	 * 게시판 게시글 삭제 - 관리자도 하나씩 삭제
	 */
	//public int deletePost(int userNo, int postNo) { }
	
	/**
	 * 게시판 전체 게시글 조회
	 */
	//public List<PostDTO> selectPost() { }
	
	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	//public List<PostDTO> selectPostDate() { }
	
	/**
	 * 게시판 게시글 타입별 조회
	 */
	//public List<PostDTO> selectPostType(int postTypeNo) { }
	
	/**
	 * 게시판 조회수별 조회
	 */
	//public List<PostDTO> selectPostCount() { }
	
	/**
	 * 게시판 게시글 이름으로 검색
	 */
	//public List<PostDTO> selectPostName(String postTitle) { }
	
	/**
	 * 게시판 타입으로 검색 
	 */
	//public List<PostDTO> selectPost(String postType) { }
	
	/**
	 * 게시판 상위 공간 오늘의 신규 레시피
	 */
	//public List<RecipeDTO> selectNewRecipe() { }
	
	/**
	 * 게시판 상위 레시피 랭킹
	 */
	//public List<RecipeDTO> selectRankingRecipe() { }
	
	/**
	 * 게시판 오늘의 추천 레시피
	 */
	//public List<RecipeDTO> selectTodayRecipe() { }
}
