package com.kooking.dao;

import com.kooking.dto.ImageDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.UserDTO;

public interface UserDAO {
	
	/**
	 * 회원의 모든정보 출력
	 * */
	UserDTO selectAll();
	
	/**
	 * 프로필 설정
	 * */
	int imageUpdate(int userNo, ImageDTO img);
	
	/**
	 * 회원 정보 수정
	 * */
	int userUpdate(UserDTO user);
	
	/**
	 * 작성한 게시글 목록 보기
	 * */
	PostDTO postSelectByUserNo(int userNo);

	/**
	 * 작성한 댓글 목록 보기
	 * */
	PostDTO commentSelectByUserNo(int userNo);

	/**
	 * 작성한 즐겨찾기 목록 보기
	 * */
	PostDTO bookmarkSelectByUserNo(int userNo);
	
   /**
    * 로그인 기능
    * */
	UserDTO loginCheck(String id, String pwd);
	
	/**
	 * User 가입하기
	 * */
	int insert(UserDTO userDTO);
		
}
