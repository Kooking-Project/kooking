package com.kooking.dao;

import java.sql.SQLException;

import com.kooking.dto.UserDTO;


public interface UserDAO {
	
	   /**
	    * 로그인 기능
	    * */
		UserDTO loginCheck(UserDTO userDTO);
		
		/**
		 * User 가입하기
		 * */
		int insert(UserDTO userDTO);
		

		
		
}
