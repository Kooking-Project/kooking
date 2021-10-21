package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.paging.Pagenation;

public interface UserDAO {
	
	/**
	 * 회원 정보 수정 + 프로필 설정
	 * */
	int userUpdate(UserDTO user) throws SQLException;
	
	/**
	 * 작성한 커뮤니티 게시글 목록 보기 (타입 3, 4, 5)
	 * */
	Entry<List<PostDTO>, Pagenation> communitySelectByUserNo(int userNo, Pagenation page) throws Exception;
	
	/**
	 * 작성한 게시글 목록 보기
	 * */
	Entry<List<RecipeWrapper>, Pagenation> postSelectByUserNo(int userNo, Pagenation page) throws Exception;

	/**
	 * 작성한 댓글 목록 보기
	 * */
	Entry<List<CommentDTO>, Pagenation> commentSelectByUserNo(int userNo, Pagenation page) throws Exception;

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
	 * 작성한 즐겨찾기 목록 보기
	 * */
	Entry<List<BookmarkDTO>, Pagenation> bookmarkSelectByUserNo(int userNo, Pagenation page) throws Exception;
	
	/**
	 * 즐겨찾기 추가
	 * */
	int bookmarkInsert(int userNo, int postNo) throws SQLException;

	/**
	 * 즐겨찾기 추가
	 * */
	int bookmarkDelete(int userNo, int postNo) throws SQLException;
	
	/**
	 * 비밀번호 중복체크
	 * */
	boolean pwdCheck(String pwd) throws SQLException;
	
	/**
	 * 닉네임 중복체크
	 * */
	boolean nicknameCheck(String nickName) throws SQLException;
	
}
