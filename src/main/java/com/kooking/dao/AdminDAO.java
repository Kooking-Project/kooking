package com.kooking.dao;

import java.sql.SQLException;

import com.kooking.dto.IngredientDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;

public interface AdminDAO {
	
	/**
	 * 유저 상태 확인
	 * */
	int checkUserStatues(int userNo) throws SQLException;
	
	/**
	 * 유저 활동정지
	 * */
	int changeUserStatus(UserDTO user) throws SQLException;
	
}
