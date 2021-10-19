package com.kooking.dao;

import java.util.List;

import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.paging.Pagenation;

/**
 * 레시피의 검색, 조건별 검색, 페이징 및 정렬방법을 담당하는 DAO
 * 
 * @author 박효승
 * @date 2021-10-15
 *
 */
public interface RecipeSelectDAO {
	
	/**
	 * 게시글 번호로 단일 레시피의 내용을 검색하는 메소드
	 * @param
	 * @return
	 * @throws Exception 
	 */
	RecipeWrapper search(int recipeNo) throws Exception;
	
	
	/**
	 * 여러 조건에 따라 레시피를 검색하는 메소드
	 * @param
	 * @return
	 * @throws Exception 
	 */
	List<RecipeDTO> searchQuery(RecipeDTO recipe, Pagenation page) throws Exception;

	
	/**
	 * 게시글의 평점 추가
	 * @param postNo
	 * @param score
	 * @return
	 * @throws Exception 
	 */
	int addRecipeScore(int postNo, int userNo, int score) throws Exception;
	
	

}
