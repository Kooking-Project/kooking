package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.util.DBTestUtil;
import com.kooking.util.DbUtil;

import oracle.net.aso.r;

public class RecipeDAOImpl implements RecipeDAO {
	private Properties proFile = new Properties();

	public RecipeDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));

			System.out.println("query : " + proFile.getProperty("query.select"));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(RecipeWrapper recipe) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "";
				

//		INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, USER_NO_SEQ.CURRVAL, '콩국수가 싫다면 잣국수','시원한 여름국수요리!', 0, SYSDATE);
//		INSERT INTO RECIPES(RECIPES_NO,RECIPES_NANE,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(RECIPES_NO_SEQ.NEXTVAL,'잣국수',POST_NO_SEQ.CURRVAL, 513, 20, '한식', '만두/면류', '초보환영');

//		INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'잣',1,'150g');
//		INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'닭 육수',2,'2+1/2종이컵');
//		INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소면',3,'1인분');
//		INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'오이',4,'1/3개');
//		INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소금',5,'약간');

//		INSERT INTO IMAGES(IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES('https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png',POST_NO_SEQ.CURRVAL,3721); 
//		INSERT INTO IMAGES(IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES('https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/72d6a27278d2eb32b960ceafd49ea2741.png',POST_NO_SEQ.CURRVAL,3395); 
//		INSERT INTO IMAGES(IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES('https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/85cce2bddd66d150dc77adaf7e877ab41.png',POST_NO_SEQ.CURRVAL,2683); 
//		INSERT INTO IMAGES(IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES('https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/7603c22d0bb956f0bfbe3d74df6a66161.png',POST_NO_SEQ.CURRVAL,2573); 

//		INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,IMAGE_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png',1,'오이는 채 썬다.',NULL);
//		INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,IMAGE_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/72d6a27278d2eb32b960ceafd49ea2741.png',2,'믹서에 잣, 닭 육수, 소금을 넣고 곱게 간 후 체에 내린다.','잣 국물은 냉장고에 차게 보관해 주세요.');
//		INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,IMAGE_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/85cce2bddd66d150dc77adaf7e877ab41.png',3,'끓는 물에 소금을 넣고 소면을 넣어 삶는다.','찬물을 조금씩 넣어가며 삶으면 면이 더 쫄긴해져요');
//		INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,IMAGE_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png',4,'그릇에 삶은 소면을 담고 잣 국물을 넉넉히 부은 후 채 썬 오이를 올려 완성한다.',NULL);

		
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//게시판유형(1, 레시피)
			//게시글제목(콩국수가 싫다면 잣국수)
			//게시글내용(시원한 여름국수요리!)
			
			//레시피이름(잣국수) 
			//칼로리(513)
			//조리시간(20)
			//레시피국가(한식)
			//레시피분류(만두/면류)
			//레시피난이도(초보환영)
			
			//레시피재료이름
			//레시피재료순서
			//레시피재료용량
			
			//레시피이미지????
			
			//조리과정순서
			//조리과정설명
			//조리과정팁
			
			
			
			
			
			result = ps.executeUpdate();
			
			System.out.println(result);
			
		} finally {
			// TODO: handle finally clause
		}
		
		
		
		return result;
	}

	@Override
	public int update(RecipeWrapper recipe) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String SQL = "UPDATE POSTS SET POST_TITLE='테스트 ㅇㅇㅇㅇ' WHERE POST_NO=1;";

			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(SQL);
			result = ps.executeUpdate();
			System.out.println(result);

		return result;
	}

	@Override
	public int delete(int no, int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			System.out.println("커넥션 진입");
			con = DBTestUtil.getConnection();
			System.out.println("커넥션 완료");
			ps = con.prepareStatement("DELETE FROM POSTS WHERE POST_NO = ? AND USER_NO = ?");
			ps.setInt(1, no);
			ps.setInt(2, userNo);
			
			System.out.println("딜리트 진입");
			result = ps.executeUpdate();
			System.out.println("결과 : " + result);
		}finally {
			DBTestUtil.dbClose(ps, con);
		}
		return result;
		
	}
	

	public static void main(String[] args){
		RecipeDAO recipeDAO = new RecipeDAOImpl();
		System.out.println("112312");
		
		int r = 0;
		try {
			r = recipeDAO.delete(1, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r);
	}



}
