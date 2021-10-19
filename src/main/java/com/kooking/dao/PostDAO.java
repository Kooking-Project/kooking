package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.exception.KookingException;

public interface PostDAO{

	/**
	 * 게시판 게시글 추가
	 */
	//public int insertPost(PostDTO dto) throws Exception;
	
	/**
	 * 게시판 게시글 수정 - 게시글 번호, 사용자 번호, 조회수, 게시글 타입, 조회수, 작성일 변경 불가
	 */
	//public int updatePost(PostDTO dto) throws Exception;
	
	/**
	 * 게시판 게시글 삭제 - 관리자도 하나씩 삭제
	 */
	//public int deletePost(PostDTO dto) throws Exception;
	
	/**
	 * 댓글 존재 여부 확인 - 댓글부터 지워야 게시글이 지워짐.. 삭제예정
	 */
	//public int deleteCommentCheck(int userNo, int postNo) throws SQLException;
	
	/**
	 * 사용자가 쓴 게시물 조회 - user에서 할 예정
	 */
	//public List<PostDTO> selectUserPost(int userNo) throws SQLException;
	
	/**
	 * 게시판 클릭했을 때 해당 게시물 하나보여주기 - 비회원, 회원 공통 여기서 조회수 체크
	 * boardNo로 해당 게시물 가져옴.
	 */
	public PostDTO selectPostDetail(int postNo) throws Exception;
	
	/**
	 * 조회수 증가
	 */
	public int postViewCount(int postNo) throws Exception;
	
	
	/**
	 * 게시판 전체 게시글 조회
	 */
	public List<PostDTO> selectPost(String userNo) throws SQLException;
	
	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	public List<PostDTO> selectPostDate() throws SQLException;
	
	/**
	 * 게시판 게시글 타입별 조회
	 */
	public List<PostDTO> selectPostType(int postTypeNo) throws SQLException;
	
	/**
	 * 게시판 조회수별 조회
	 */
	public List<PostDTO> selectPostCount();
	
	/**
	 * 게시판 게시글 이름으로 검색
	 */
	public List<PostDTO> searchPostName(String postTitle) throws SQLException;
	
	/**
	 * 게시판 타입으로 검색 
	 */
	public List<PostDTO> searchPostType(String postType) throws SQLException;
	
	/**
	 * 게시판 상위 공간 오늘의 신규 레시피
	 */
	//public List<RecipeDTO> selectNewRecipe(String todayDate) throws SQLException;
	
	/**
	 * 게시판 상위 공간 레시피 랭킹
	 */
	//public List<RecipeDTO> selectRankingRecipe();
	
	/**
	 * 게시판 상위 공간 오늘의 추천 레시피
	 */
	//public List<RecipeDTO> selectTodayRecipe();
}
