package com.kooking.service;

import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.UserDTO;
import com.kooking.paging.Pagenation;

public interface AdminService {
	/**
	 * 회원 상태 변경
	 * */
	void changeUserStatus(int adminStatus, UserDTO user) throws Exception;
	
	/**
	 * 댓글 삭제
	 * */
	void commentDelete(int adminNo, int userNo, int commentNo) throws Exception;

	/**
	 * 게시글 삭제
	 * */
	void postDelete(int adminNo, int userNo, int postNo) throws Exception;
	
	/**
	 * 유저정보 전체 검색
	 * */
	Entry<List<UserDTO>, Pagenation> userSelectAll(int adminNo, Pagenation page) throws Exception;

	/**
	 * 유저정보 상세정보 검색
	 * */
	UserDTO userSelectByNo(int adminNo, int userNo) throws Exception;
}
