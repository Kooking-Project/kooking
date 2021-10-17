package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.ProcessDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.exception.KookingException;
import com.kooking.util.DBTestUtil;

public class RecipeDAOImpl implements RecipeDAO {
	Properties proFile = new Properties();
	
	public RecipeDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			System.out.println("proFile 로드됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * POST_NO_SEQ, RECIPE_NO_SEQ 를 얻어오는 메소드  
	 * @author 박효승
	 * @date 2021-10-17
	 */
	private	boolean getSqNumbers(Connection con, RecipeWrapper wrapper) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		if (wrapper==null || wrapper.getPost() == null || wrapper.getRecipe()==null) {
			return false;
		}
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement("SELECT POST_NO_SEQ.NEXTVAL, RECIPE_NO_SEQ.NEXTVAL FROM DUAL");
			rs = ps.executeQuery();
			
			if((result = rs.next())) {
				wrapper.getPost().setNo(rs.getInt(1));
				wrapper.getRecipe().setNo(rs.getInt(2));
			}
		}finally {
			DBTestUtil.dbClose(ps, rs);
		}
		return result;
	}
	
	/**
	 * 게시물 등록하기--> 은솔: 성하님과 겹칠 수 있음으로 지금은 레시피 등록으로 생각중  
	 * @author 박효승
	 * @date 2021-10-17	
	 */
	private int insertPost(PostDTO post, Connection con) throws Exception{
		PreparedStatement ps = null;
		int result = 0;
		if(post == null || con == null) {
			throw new KookingException("게시물 정보가 없습니다.");
		}
		
		String sql = "INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(?, ?, ?, ?, ?, 0, SYSDATE)";
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, post.getNo());
			ps.setInt(2, 1); // TODO : 나중에 카테고리를 받아와서 수정
			ps.setInt(3, post.getUserNo());
			ps.setString(4, post.getTitle());
			ps.setString(5, post.getContents());
			result = ps.executeUpdate();
		}finally {
			DBTestUtil.dbClose(ps);
		}
		
		return result;
	}
	
	/**
	 * 레시피 등록하기
	 * @author 박효승
	 * @date 2021-10-17	
	 */
	public int insertRecipe(RecipeDTO recipe, int postSq, Connection con) throws SQLException, KookingException {
		PreparedStatement ps = null;
		int result = 0;
		if(recipe == null) {
			throw new KookingException("레시피 정보가 없습니다.");
		}
		
		String sql = "INSERT INTO RECIPES(RECIPES_NO,RECIPES_NANE,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, recipe.getNo());
			ps.setString(2, recipe.getName());
			ps.setInt(3, postSq);
			ps.setInt(4, recipe.getCalorie());
			ps.setInt(5, recipe.getCookingTime());
			ps.setString(6, recipe.getNation()); 	// TODO : 나중에 카테고리를 받아와서 수정
			ps.setString(7, recipe.getType()); 		// TODO : 나중에 카테고리를 받아와서 수정
			ps.setString(8, recipe.getLevel()); 	// TODO : 나중에 카테고리를 받아와서 수정
			
			result = ps.executeUpdate();
			
		}finally {
			DBTestUtil.dbClose(ps);
		}
		
		return result;
	}
	
	/**
	 * 레시피 재료 등록하기
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
	public int[] insertIngredient(Connection con, RecipeWrapper wrapper) throws SQLException, KookingException{
		PreparedStatement ps = null;
		String sql = "INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) "
				+ "VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,?,?,?)";
		int result [] = null;
		if(wrapper.getRecipe() == null) {
			throw new KookingException("레시피번호 정보가 없습니다");
		}
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			for(IngredientDTO ingredient : wrapper.getIngredient()) {
				
				ps.setString(1, ingredient.getName());//재료이름
				ps.setInt(2, ingredient.getSeq());//재료순서
				ps.setString(3, ingredient.getCacty());//재료용량
				
				ps.addBatch();//일괄처리할 작업에 추가
				ps.clearParameters();
			}
			result = ps.executeBatch();//일괄처리
			
		} finally {
			DBTestUtil.dbClose(ps);
		}
		return result;
	}
	
	/**
	 * 이미지 등록하기
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
	public int[] insertImage(Connection con, RecipeWrapper wrapper, int postSq) throws SQLException, KookingException{
		PreparedStatement ps = null;
		String sql = "INSERT INTO IMAGES(IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(?, ?, ?)";
		int result [] = null;
		if(wrapper.getPost() == null) {
			throw new KookingException("게시글번호 정보가 없습니다");
		}
		
		try {
			ps = con.prepareStatement(sql);
			for(ImageDTO image : wrapper.getImages()) {
				
				ps.setString(1, image.getUrl());//이미지 URL
				ps.setInt(2, postSq);//POST_NO_SEQ 가져와서 넣고
				ps.setInt(3, image.getSize());//이미지용량
				
				ps.addBatch();
				ps.clearParameters();
			}
			result = ps.executeBatch();
			
		} finally {
			DBTestUtil.dbClose(ps);
		}
		return result;
	} 
	
	/**
	 * 레시피 조리과정 등록하기
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
	public int[] insertProcess(Connection con, RecipeWrapper wrapper, int recipeSq) throws SQLException, KookingException{
		PreparedStatement ps = null;
		String sql = "INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,IMAGE_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL, RECIPES_NO_SEQ.CURRVAL, ?, ?, ?, ?)";
		int result [] = null;
		if(wrapper.getRecipe() == null) {
			throw new KookingException("레시피번호 정보가 없습니다");
		}
		
		try {
			ps = con.prepareStatement(sql);
			for(ProcessDTO process : wrapper.getProcess()) {
				
				ps.setString(1,process.getImageUrl());//이미지URL
				ps.setInt(3, process.getCookingSeq());//조리과정순서
				ps.setString(4, process.getCookingDesc());//조리과정설명
				ps.setString(5, process.getTip());//과정팁
				
				ps.addBatch();
				ps.clearParameters();
			}
			result = ps.executeBatch();
			
		} finally {
			DBTestUtil.dbClose(ps);
		}
		return result;
	} 
	
	/**
	 * @author 박은솔
	 * @date 2021-10-17	
	 * 레시피 등록하기 
	 * 		0) POSTS 게시글 등록시, 카테고리타입이 레시피라면 레시피등록 메소드 호출
	 * 		1) RECIPES 테이블에 insert
	 * 		2) INGREDIENTS 테이블에 insert
	 * 		3) IMAGES 테이블에 insert
	 * 		4) PROCESS 테이블에 insert
	 */
	@Override
	public int insert(RecipeWrapper wrapper) throws SQLException, KookingException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO RECIPES(RECIPES_NO,RECIPES_NANE,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL)"
				+ "VALUES(RECIPES_NO_SEQ.NEXTVAL,?,?,?,?,?,?,?)";

		try {
			con = DBTestUtil.getConnection();
			con.setAutoCommit(false);//자동커밋해지

			ps = con.prepareStatement(sql);
			ps.setInt(1, wrapper.getRecipe().getNo());//레시피번호
			ps.setString(2, wrapper.getRecipe().getName());//레시피이름
			ps.setInt(3, wrapper.getRecipe().getPostNo());//게시글번호를 받아와서 POST_NO_SEQ.CURRVAL???? postSq???
			ps.setInt(4, wrapper.getRecipe().getCalorie());//칼로리(Kcal)
			ps.setInt(5, wrapper.getRecipe().getCookingTime());//조리시간(분)
			ps.setString(6, wrapper.getRecipe().getNation()); //레시피국가 	TODO : 나중에 카테고리를 받아와서 수정
			ps.setString(7, wrapper.getRecipe().getType()); //레시피분류 	TODO : 나중에 카테고리를 받아와서 수정
			ps.setString(8, wrapper.getRecipe().getLevel()); //난이도 		TODO : 나중에 카테고리를 받아와서 수정

			if(result==0) {
				con.rollback();
				throw new SQLException("레시피등록 실패...");

			}else {
				int ingredient [] = insertIngredient(con, wrapper);//2)레시피 재료 등록하기
				for(int i : ingredient) {
					System.out.println(i);
				}

				for(int i : ingredient) {
					if(i != 1)//1은 성공, 0은 실패
						con.rollback();
					throw new SQLException("레시피 재료 입력 오류. 레시피등록 실패");
				}

				//3)이미지URL 등록하기 
				int image [] = insertImage(con, wrapper, result);
				for(int i : image) {
					if(i != 1)
						con.rollback();
					throw new SQLException("이미지 입력 오류. 레시피등록 실패");
				}

				//4)레시피조리과정 등록하기 
				int process [] = insertProcess(con, wrapper, result);
				for(int i : process) {
					if(i != 1)
						con.rollback();
					throw new SQLException("조리과정 입력 오류. 레시피등록 실패");
				}

				con.commit();
			}

			System.out.println("insert() 결과 : " + result);//잘 되는지 테스트 하고 싶은데 어떻게? 

		} finally {
			con.commit();
			DBTestUtil.dbClose(con, ps);
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
