package com.kooking.service;

import java.util.List;

import com.kooking.dto.UserDTO;

public interface AdminService {
	/**
	 * 회원 상태 변경
	 * */
	void changeUserStatus(int adminStatus, UserDTO user) throws Exception;
	
	/**
	 * 댓글 삭제
	 * */
	void commentDelete(int adminNo, int commentNo) throws Exception;

	/**
	 * 게시글 삭제
	 * */
	void postDelete(int adminNo, int postNo) throws Exception;
	
	/**
	 * 유저정보 전체 검색
	 * */
	List<UserDTO> userSelectAll(int adminNo) throws Exception;
}
