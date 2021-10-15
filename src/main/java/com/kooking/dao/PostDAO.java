package com.kooking.dao;

import java.util.List;

import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;

public interface PostDAO {

	/**
	 * 게시판 게시글 추가
	 */
	public void insertPost(int userNo ,PostDTO dto);
	
	/**
	 * 게시판 게시글 수정
	 */
	public int updatePost(int userNo, int postNo);
	
	/**
	 * 게시판 게시글 삭제 - 관리자는 여러개 삭제 가능?
	 */
	public int deletePost(int userNo, int postNo);
	
	/**
	 * 게시판 전체 게시글 조회
	 */
	public List<PostDTO> selectPost();
	
	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	public int selectPostDate();
	
	/**
	 * 게시판 게시글 타입별 조회 ....애매....
	 */
	public int selectPostType();
	
	/**
	 * 게시판 조회수별 조회
	 */
	public int selectPostCount();
	
	/**
	 * 게시판 게시글 이름으로 검색
	 */
	public int selectPostName(String postTitle);
	
	/**
	 * 게시판 타입으로 검색 ....애매... 이름검색에 넣어야 할까
	 */
	public int selectPost(String postType);
	
	/**
	 * 게시판 상위 공간 오늘의 신규 레시피
	 */
	public List<RecipeDTO> selectNewRecipe();
	
	/**
	 * 게시판 상위 레시피 랭킹
	 */
	public List<RecipeDTO> selectRankingRecipe();
	
	/**
	 * 게시판 오늘의 추천 레시피
	 */
	public List<RecipeDTO> selectTodayRecipe();
}
