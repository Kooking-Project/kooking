package com.kooking.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.exception.KookingException;

/**
 * @author 박은솔
 * @date 2021-10-15
 */
public interface RecipeDAO {
	
	/**
	 * 레시피 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 */
	int insert(RecipeWrapper recipe) throws SQLException, KookingException;
	
	/**
	 * 레시피번호에 해당하는 레코드 수정
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	int update(RecipeWrapper recipe) throws SQLException;
	
	/**
	 * 레시피번호에 해당하는 레코드 삭제
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 */
	int delete(int postNo, int userNo) throws SQLException;

}