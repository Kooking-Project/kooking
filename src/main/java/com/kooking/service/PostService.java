package com.kooking.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;

public interface PostService {

	/**
	 * 게시판 게시글 추가 - 제목, 내용, 작성자(사용자 번호), 날짜
	 */
	public int insertPost(PostDTO postDTO) throws Exception;
	
	/**
	 * 게시판 게시글 수정 - 게시글 번호, 사용자 번호, 조회수, 게시글 타입, 조회수, 작성일 변경 불가
	 */
	public int updatePost(PostDTO dto) throws Exception;
	
	/**
	 * 게시판 게시글 삭제 - 관리자도 하나씩 삭제- dto로 바꾸고 싶당
	 */
	public int deletePost(int postNo, Connection con) throws Exception;
	
	/**
	 * 게시판 클릭했을 때 해당 게시물 하나보여주기 - 비회원, 회원 공통 여기서 조회수 체크
	 */
	public PostDTO selectPostDetail(int postNo) throws Exception;
	
	/**
	 * 게시글에 해당하는 전체 댓글 조회
	 */
	public List<CommentDTO> selectComments(int postNo) throws Exception;
	
	/**
	 * 게시판 전체 게시글 조회
	 */
	public List<PostDTO> selectPost() throws Exception;
	
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
	public List<PostDTO> selectPostCount() throws Exception;
	
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
	
	
	
	/**
	 * 댓글 추가
	 */
	//public int insertComment(int UserNo);
	
	/**
	 * 댓글 수정
	 */
	//public int updateComment(int UserNo, CommentDTO dto);
	
	/**
	 * 댓글 삭제 (댓글번호만 가져올까?)
	 */
	//public int deleteComment(int UserNo, CommentDTO dto);
	
	/**
	 * 댓글 상태 확인 (댓글번호만 가져올까?)
	 */
	//public int stateComment(CommentDTO dto);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	List<PostDTO> boardList(String userNo) throws Exception;
	
}
