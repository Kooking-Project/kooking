package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.ImageDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;

public interface UserDAO {
	
	/**
	 * 회원 정보 수정 + 프로필 설정
	 * */
	int userUpdate(UserDTO user) throws SQLException;
	
	/**
	 * 작성한 게시글 목록 보기
	 * */
	Entry<PostDTO, RecipeDTO> postSelectByUserNo(int userNo) throws SQLException;

	/**
	 * 작성한 댓글 목록 보기
	 * */
	List<CommentDTO> commentSelectByUserNo(int userNo) throws SQLException;

	/**
	 * 작성한 즐겨찾기 목록 보기
	 * */
	List<BookmarkDTO> bookmarkSelectByUserNo(int userNo) throws SQLException;
	
   /**
    * 로그인 기능
    * */
	UserDTO loginCheck(String id, String pwd) throws SQLException;
	
	/**
	 * User 가입하기
	 * */
	int insert(UserDTO userDTO) throws SQLException;
	
	/**
	 * 아이디 중복체크
	 * */
	boolean idCheck(String id) throws SQLException;
	
	/**
	 * 즐겨찾기 추가
	 * */
	int bookmarkInsert(int userNo, int postNo) throws SQLException;

	/**
	 * 즐겨찾기 추가
	 * */
	int bookmarkDelete(int userNo, int postNo) throws SQLException;
	
}
