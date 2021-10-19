package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.IngredientDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;

public interface AdminDAO {
	
	/**
	 * 회원의 모든정보 출력
	 * */
	List<UserDTO> userSelectAll() throws SQLException;
	
	/**
	 * 유저 상태 확인
	 * */
	int checkUserStatues(int userNo) throws SQLException;
	
	/**
	 * 유저 활동정지
	 * */
	int changeUserStatus(UserDTO user) throws SQLException;
	
}
