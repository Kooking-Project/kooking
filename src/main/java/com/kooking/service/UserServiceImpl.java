package com.kooking.service;

import java.sql.SQLException;

import com.kooking.dao.UserDAO;
import com.kooking.dao.UserDAOImpl;
import com.kooking.dto.UserDTO;
import com.kooking.exception.KookingException;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserDAOImpl();

	@Override
	public UserDTO loginCheck(String id, String pwd) throws SQLException, KookingException {
	    UserDTO userDTO = userDao.loginCheck(id,pwd);
        if(userDTO==null)
        	throw new KookingException("정보를 다시 확인해주세요.");
        
		return userDTO;
	}

	@Override
	public void insert(UserDTO userDTO) throws SQLException, KookingException {
		if( userDao.idCheck(userDTO.getId())) {
			throw new SQLException("아이디가 중복입니다.");
		}
		 if( userDao.insert(userDTO) == 0 )
			  throw new SQLException("등록되지 않았습니다.");
		
	}

	



}
