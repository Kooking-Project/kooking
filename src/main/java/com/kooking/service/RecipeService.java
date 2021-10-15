package com.kooking.service;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dto.RecipeDTO;

public interface RecipeService {
	/**
	 * RecipeDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	List<RecipeDTO> selectAll() throws SQLException;
	
	/**
	 * paging처리
	 */
	//List<RecipeDTO> selectAll(int pageNo) throws SQLException;

	/**
	 * RecipeDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	void insert(RecipeDTO recipe) throws SQLException;

	/**
	 * RecipeDAOImpl의 레시피번호에 해당하는 레코드 검색하는 메소드 호출
	 * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	 * */
	RecipeDTO selectByModelnum(String no, boolean flag) throws SQLException;

	/**
	 * RecipeDAOImpl의 레시피번호에 해당하는 레코드 수정 메소드 호출
	 * */
	void update(RecipeDTO recipe) throws SQLException;
	
	/**
	 * RecipeDAOImpl의 레시피번호에 해당하는 레코드 삭제 메소드 호출
	 * */
	void delete(String no, String pwd , String path) throws SQLException;

	
}
