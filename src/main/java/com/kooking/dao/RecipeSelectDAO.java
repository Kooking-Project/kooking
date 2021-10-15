package com.kooking.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.ProcessDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.paging.PageCnt;

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
	 */
	RecipeWrapper search(int recipeNo);
	
	
	/**
	 * 여러 조건에 따라 레시피를 검색하는 메소드
	 * @param
	 * @return
	 */
	List<RecipeWrapper> searchQueryAll(PostDTO postDTO, RecipeDTO recipe, PageCnt cnt);
	List<RecipeWrapper> searchQueryAll(PostDTO postDTO, RecipeDTO recipe);
	
	
	List<IngredientDTO> getIngredients(int recipeNo);
	List<Entry<ProcessDTO, ImageDTO>> getProcess(int recipeNo);
	
	/**
	 * 게시글의 평점 추가
	 * @param postNo
	 * @param score
	 * @return
	 */
	int addRecipeScore(int postNo, int userNo, int score);
	
	

}