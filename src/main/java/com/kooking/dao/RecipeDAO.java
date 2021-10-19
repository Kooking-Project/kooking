package com.kooking.dao;

import com.kooking.dto.wrapper.RecipeWrapper;

/**
 * @author 박은솔
 * @date 2021-10-15
 */
public interface RecipeDAO {
	
	/**
	 * 레시피 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * @throws Exception 
	 */
	boolean insert(RecipeWrapper recipe) throws Exception;
	
	/**
	 * 레시피번호에 해당하는 레코드 수정
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	boolean update(RecipeWrapper recipe) throws Exception;
	
	
	//레시피 삭제  : 게시글번호에 해당하는 레코드 삭제시 레시피 삭제됨.


}