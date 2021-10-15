package com.kooking.dao;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.RecipeDTO;

/**
 * @author 박은솔
 * @date 2021-10-15
 */
public interface RecipeDAO {
	/**
	 * 레코드 전체 검색
	 */
	List<RecipeDTO> selectAll() throws SQLException;
	
	/**
	 * 레코드 전체 검색(페이지처리)
	 */
	List<RecipeDTO> getRecipeList(int pageNo) throws SQLException;
	
	/**
	 * 레시피번호에 해당하는 레코드 검색
	 */
	RecipeDTO selectByNo(int no) throws SQLException;
	
	/**
	 * 레시피 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 */
	int insert(RecipeDTO recipe) throws SQLException;
	
	/**
	 * 레시피번호에 해당하는 레코드 수정
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	int update(RecipeDTO recipe) throws SQLException;
	
	/**
	 * 레시피번호에 해당하는 레코드 삭제
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 */
	int delete(int no, String pwd) throws SQLException;
	
	/**
	 * 레시피번호에 해당하는 댓글정보 가져오기 
	 */
	List<CommentDTO> selectCommentsByRecipeNo(int no) throws SQLException;
}
