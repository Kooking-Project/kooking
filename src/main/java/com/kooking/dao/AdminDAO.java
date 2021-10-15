package com.kooking.dao;

import com.kooking.dto.IngredientsDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;

public interface AdminDAO {
	/**
	 * 게시글 삭제
	 * */
	int postDelete(int postNo);

	/**
	 * 댓글 삭제
	 * */
	int commentDelete(int postNo);
	
	/**
	 * 유저 활동정지
	 * */
	int changeUserStatus(UserDTO user);
	
	/**
	 * 레시피 추가
	 * */
	int recipeInsert(RecipeDTO recipe);

	/**
	 * 레시피 수정
	 * */
	int recipeUpdate(RecipeDTO recipe);

	/**
	 * 레시피 삭제
	 * */
	int recipeDelete(int recipeNo);

	/**
	 * 재료 추가
	 * */
	int ingredientInsert(IngredientsDTO ingredient);
	
	/**
	 * 재료 수정
	 * */
	int ingredientUpdate(IngredientsDTO ingredient);
	
	/**
	 * 재료 삭제
	 * */
	int ingredientDelete(int ingredientNo);
}
