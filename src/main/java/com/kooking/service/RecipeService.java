package com.kooking.service;

import com.kooking.dto.wrapper.RecipeWrapper;

/**
 * @author 박은솔
 * @date 2021-10-18
 */
public interface RecipeService {

	/**
	 * RecipeDAOImpl의 레시피 레코드 삽입하는 메소드 호출
	 */
	boolean insert(RecipeWrapper wrapper) throws Exception;

	/**
	 * RecipeDAOImpl의 레시피번호 해당하는 레코드 수정 메소드 호출
	 */
	boolean update(RecipeWrapper recipe) throws Exception;


	//레시피 삭제  : 게시글번호에 해당하는 레코드 삭제시 레시피 삭제됨.
}
