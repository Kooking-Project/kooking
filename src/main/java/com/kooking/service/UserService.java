package com.kooking.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.exception.KookingException;
import com.kooking.paging.Pagenation;

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
	 * 회원 정보 수정 + 회원 프로필 설정
	 * 	method가 두개인 이유는 비밀번호를 바꾸거나 안바꾸거나 때문
	 */
	void userUpdate(UserDTO userDTO) throws Exception;
	void userUpdate(UserDTO userDTO, String pwd) throws Exception;

	/**
	 * 본인이 작성한 게시글 확인
	 */
	Entry<List<RecipeWrapper>, Pagenation> postSelectByUserNo(int userNo, Pagenation page) throws Exception;

	/**
	 * 본인이 작성한 게시글 확인
	 */
	Entry<List<PostDTO>, Pagenation> communitySelectByUserNo(int userNo, Pagenation page) throws Exception;

	/**
	 * 본인이 작성한 댓글 확인
	 */
	Entry<List<CommentDTO>, Pagenation> commentSelectByUserNo(int userNo, Pagenation page) throws Exception;

	/**
	 * 본인이 작성한 즐겨찾기 확인
	 */
	Entry<List<BookmarkDTO>, Pagenation> bookmarkSelectByUserNo(int userNo, Pagenation page) throws Exception;
	
	/**
	 * 즐겨찾기 추가
	 * */
	void bookmarkInsert(int userNo, int postNo) throws Exception;

	/**
	 * 즐겨찾기 삭제
	 * */
	void bookmarkDelete(int userNo, int postNo) throws Exception;
	
	/**
	 * 회원 탈퇴(상태변경 탈퇴=2)
	 * */
	void changeUserStatus(UserDTO user) throws Exception;

	/**
	 * 게시글 삭제
	 * */
	void postDelete(int userNo, int postNo) throws Exception;
	
	/**
	 * 댓글 삭제
	 * */
	void commentDelete(int userNo, int commentNo) throws Exception;
	
	/**
	 * 유저정보 전체 검색
	 * */
	Entry<List<UserDTO>, Pagenation> userSelectAll(Pagenation page) throws Exception;

	/**
	 * 유저정보 상세정보 검색
	 * */
	UserDTO userSelectByNo(int userNo) throws Exception;
}
