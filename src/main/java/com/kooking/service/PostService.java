package com.kooking.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.paging.Pagenation;

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
	public int deletePost(int postNo, int userNo, Connection con) throws Exception;
	
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
	public Entry<List<PostDTO>, Pagenation> selectPost(Pagenation page) throws Exception;
	
	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	public Entry<List<PostDTO>, Pagenation> selectPostDate(Pagenation page) throws Exception;
	
	/**
	 * 게시판 게시글 타입별 조회
	 */
	public Entry<List<PostDTO>, Pagenation> selectPostType(Pagenation page, int postTypeNo) throws Exception;
	
	/**
	 * 게시판 조회수별 조회
	 */
	public Entry<List<PostDTO>, Pagenation> selectPostCount(Pagenation page) throws Exception;
	
	/**
	 * 게시판 게시글 이름으로 검색
	 */
	public Entry<List<PostDTO>, Pagenation> searchPostName(Pagenation page, String postName) throws Exception;
	
	/**
	 * 게시판 타입으로 검색 - 굳이?
	 */
	//public List<PostDTO> searchPostType(String postType) throws SQLException;
	
	/**
	 * 댓글 추가
	 */
	public int insertComment(CommentDTO dto) throws Exception;
	
	/**
	 * 댓글 수정
	 */
	public int updateComment(CommentDTO dto) throws Exception;
	
	/**
	 * 댓글 삭제 - 상태만 바꾸는거
	 */
	public int deleteComment(int userNo, int postNo) throws Exception;
	
	/**
	 * 댓글 하나만 찾아오기 - commentNo로
	 */
	public CommentDTO stateComment(int commentNo) throws Exception;

	
}
