package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.exception.KookingException;
import com.kooking.paging.Pagenation;

public interface PostDAO{

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
	 * 게시판 타입으로 검색 - 미완
	 */
	public List<PostDTO> searchPostType(String postType) throws SQLException;

}
