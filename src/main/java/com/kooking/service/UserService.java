package com.kooking.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.exception.KookingException;

public interface UserService {
	/**
	 * 로그인 체크
	 */
	UserDTO loginCheck(String id, String pwd) throws SQLException, KookingException;

	/**
	 * 회원가입
	 */
	void insert(UserDTO userDTO) throws SQLException, KookingException;

	/**
	 * 회원 프로필 설정
	 */
	void profileImageUpdate(UserDTO userDTO) throws Exception;

	/**
	 * 회원 정보 수정
	 */
	void userUpdate(UserDTO userDTO) throws Exception;

	/**
	 * 본인이 작성한 게시글 확인
	 */
	Entry<PostDTO, RecipeDTO> postSelectByUserNo(int userNo) throws Exception;

	/**
	 * 본인이 작성한 댓글 확인
	 */
	List<CommentDTO> commentSelectByUserNo(int userNo) throws Exception;

	/**
	 * 본인이 작성한 즐겨찾기 확인
	 */
	List<BookmarkDTO> bookmarkSelectByUserNo(int userNo) throws Exception;
	
	/**
	 * 즐겨찾기 추가
	 * */
	void bookmarkInsert(int userNo, int postNo) throws Exception;

	/**
	 * 즐겨찾기 삭제
	 * */
	void bookmarkDelete(int userNo, int postNo) throws Exception;

}
