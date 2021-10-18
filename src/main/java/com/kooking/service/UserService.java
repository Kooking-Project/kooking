package com.kooking.service;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
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
	 * 회원 정보 수정
	 */
	void userUpdate(UserDTO userDTO) throws Exception;

	/**
	 * 본인이 작성한 게시글 확인
	 */
	List<PostDTO> postSelectByUserNo(int userNo) throws Exception;

	/**
	 * 본인이 작성한 댓글 확인
	 */
	List<CommentDTO> commentSelectByUserNo(int userNo) throws Exception;

}
