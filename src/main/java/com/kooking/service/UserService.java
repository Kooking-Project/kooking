package com.kooking.service;

import java.sql.SQLException;

import com.kooking.dto.UserDTO;
import com.kooking.exception.KookingException;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(String id, String pwd)throws SQLException , KookingException;
   
   void insert(UserDTO userDTO)throws SQLException , KookingException;
   
}
