package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.IngredientDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.paging.Pagenation;

public interface AdminDAO {
	
	/**
	 * 회원의 모든정보 출력
	 * */
	Entry<List<UserDTO>, Pagenation> userSelectAll(Pagenation page) throws Exception;
	/**
	 * 회원의 상세정보 출력
	 * */
	UserDTO userSelectByNo(int userNo) throws SQLException;
	
	/**
	 * 유저 상태 확인
	 * */
	int checkUserStatus(int userNo) throws SQLException;
	
	/**
	 * 유저 활동정지
	 * */
	int changeUserStatus(UserDTO user) throws SQLException;
	
}
