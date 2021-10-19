package com.kooking.service;

import java.sql.SQLException;

import com.kooking.dao.RecipeDAO;
import com.kooking.dao.RecipeDAOImpl;

import com.kooking.dto.wrapper.RecipeWrapper;
/**
 * @author 박은솔
 * @date 2021-10-19
 */
public class RecipeServiceImpl implements RecipeService {
	private RecipeDAO recipeDao = new RecipeDAOImpl();
	
	/**
	 * 레시피 등록
	 */
	@Override
	public boolean insert(RecipeWrapper wrapper) throws Exception {
		if(recipeDao.insert(wrapper)==false)
			throw new SQLException("등록되지 않았습니다.");
		return true;
	}

	/**
	 * 레시피 수정
	 */
	@Override
	public boolean update(RecipeWrapper recipe) throws Exception {
		if(recipeDao.update(recipe)==false)
			throw new SQLException("수정되지 않았습니다.");
		return true;
	}
	
	//레시피 삭제  : 게시글번호에 해당하는 레코드 삭제시 레시피 삭제됨.

}