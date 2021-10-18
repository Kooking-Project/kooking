package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	private	boolean getSqNumbers(Connection con, RecipeWrapper wrapper) throws Exception {
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
				System.out.printf("%d %d\n",wrapper.getPost().getNo(), wrapper.getRecipe().getNo());
				
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
	public int insertRecipe(RecipeDTO recipe, int postSq, Connection con) throws Exception {
		PreparedStatement ps = null;
		int result = 0;
		if(recipe == null) {
			throw new KookingException("레시피 정보가 없습니다.");
		}
		
		String sql = "INSERT INTO RECIPES(RECIPES_NO,RECIPES_NAME,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
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
	public int[] insertIngredient(RecipeWrapper wrapper, Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = "INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) "
				+ "VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,?,?,?,?)";
		int result [] = null;
		if(wrapper.getRecipe() == null) {
			throw new KookingException("레시피번호 정보가 없습니다");
		}
		
		int recipeNo = wrapper.getRecipe().getNo();
		try {
			ps = con.prepareStatement(sql);
			for(IngredientDTO ingredient : wrapper.getIngredient()) {
				ps.setInt(1, recipeNo);	//레시피 번호
				ps.setString(2, ingredient.getName());//재료이름
				ps.setInt(3, ingredient.getSeq());//재료순서
				ps.setString(4, ingredient.getCacty());//재료용량
				
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
	public int[] insertImage(RecipeWrapper wrapper, Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = "INSERT INTO IMAGES(IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(?, ?, ?)";
		int result [] = null;
		if(wrapper.getPost() == null) {
			throw new KookingException("게시글번호 정보가 없습니다");
		}
		
		int postNo = wrapper.getPost().getNo();
		try {
			ps = con.prepareStatement(sql);
			for(ImageDTO image : wrapper.getImages()) {
				
				ps.setString(1, image.getUrl());//이미지 URL
				ps.setInt(2, postNo);//POST_NO_SEQ 가져와서 넣고
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
	public int[] insertProcess(RecipeWrapper wrapper,Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = "INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,IMAGE_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		int result [] = null;
		if(wrapper.getRecipe() == null) {
			throw new KookingException("레시피번호 정보가 없습니다");
		}
		
		int recipeNo = wrapper.getRecipe().getNo();
		try {
			ps = con.prepareStatement(sql);
			for(ProcessDTO process : wrapper.getProcess()) {
				ps.setInt(1, recipeNo); // 레시피 번호
				ps.setString(2,process.getImageUrl());//이미지URL
				ps.setInt(3, process.getSeq());//조리과정순서
				ps.setString(4, process.getDesc());//조리과정설명
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
	public boolean insert(RecipeWrapper wrapper) throws Exception {
		Connection con = null;
		boolean result = false;
		
		try {
			con = DBTestUtil.getConnection();
			con.setAutoCommit(false);
			
			getSqNumbers(con, wrapper);	//시퀀스 값을 받아서 wrapper에 넣어줌.
			
			if(insertPost(wrapper.getPost(), con) <=0 ) {
				con.rollback();
				throw new KookingException("게시글 작성에 실패했습니다. : " + wrapper.getPost().getNo());
			}
			
			if(insertRecipe(wrapper.getRecipe(), wrapper.getPost().getNo(), con) <= 0) {
				con.rollback();
				throw new KookingException("레시피 작성에 실패했습니다. : " + wrapper.getRecipe().getNo());
			}
			
			for(int i : insertIngredient(wrapper, con)) {
				if(i<=0) {
					con.rollback();
					throw new KookingException("재료 등록에 실패했습니다.");
				}
			}
			
			for(int i : insertImage(wrapper, con)){
				if(i<=0) {
					con.rollback();
					throw new KookingException("이미지 등록에 실패했습니다.");
				}
			}
			
			for(int i : insertProcess(wrapper, con)) {
				if(i<=0) {
					con.rollback();
					throw new KookingException("조리과정 등록에 실패했습니다.");
				}
			}
			
			result = true;
			con.commit();
			
			
		}finally {
			//con.commit();
			DBTestUtil.dbClose(con);
		}

		return result;
	}

	@Override
	public int update(RecipeWrapper recipe) throws Exception {
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
	public int delete(int no, int userNo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement("DELETE FROM POSTS WHERE POST_NO = 17 AND USER_NO = 1");
			ps.setInt(1, no);
			ps.setInt(2, userNo);
			
			result = ps.executeUpdate();
			System.out.println("결과 : " + result);
		}finally {
			DBTestUtil.dbClose(ps, con);
		}
		return result;
		
	}
	

	public static void main(String[] args) throws Exception{
		RecipeDAO recipeDAO = new RecipeDAOImpl();
		RecipeWrapper rw = new RecipeWrapper();
		PostDTO post = new PostDTO();
		post.setNo(15);
		post.setUserNo(1);
		post.setPostTypeNo(1);
		post.setTitle("커넥션 테스트");
		post.setContents("치킨 조리방법 설명");
		rw.setPost(post);
		
		RecipeDTO recipe = new RecipeDTO();
		recipe.setName("치킨");
		recipe.setCalorie(1200);
		recipe.setCookingTime(20);
		recipe.setNation("한식");
		recipe.setType("튀김/커틀릿");
		recipe.setLevel("어려움");
		rw.setRecipe(recipe);
		
		List<IngredientDTO> ingredients = new ArrayList<IngredientDTO>();
		IngredientDTO i1 = new IngredientDTO();
		IngredientDTO i2 = new IngredientDTO();
		IngredientDTO i3 = new IngredientDTO();
		i1.setName("닭고기");
		i1.setSeq(1);
		i1.setCacty("한마리");
		
		i2.setName("튀김가루");
		i2.setSeq(2);
		i2.setCacty("한봉지");
		
		i3.setName("양념장");
		i3.setSeq(3);
		i3.setCacty("한통");
		
		ingredients.add(i1);
		ingredients.add(i2);
		ingredients.add(i3);
		rw.setIgredients(ingredients);
		
		
		List<ImageDTO> images = new ArrayList<ImageDTO>();
		ImageDTO img1 = new ImageDTO();
		ImageDTO img2 = new ImageDTO();
		ImageDTO img3 = new ImageDTO();
		
		img1.setUrl("https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png");
		img1.setSize(1000);
		
		img2.setUrl("https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/72d6a27278d2eb32b960ceafd49ea2741.png");
		img2.setSize(1000);
		
		img3.setUrl("https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/f527619b4905735ab8215944771c0e081.jpg");
		img3.setSize(1000);
		
		images.add(img1);
		images.add(img2);
		images.add(img3);
		rw.setImages(images);
		
		List<ProcessDTO> process = new ArrayList<ProcessDTO>();
		ProcessDTO p1 = new ProcessDTO();
		ProcessDTO p2 = new ProcessDTO();
		ProcessDTO p3 = new ProcessDTO();
		
		p1.setImageUrl("https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png");
		p1.setSeq(1);
		p1.setDesc("그릇에 마요네즈, 설탕, 소금, 다진마늘을 넣고 골고루 섞어주세요.");
		p1.setTip(null);
		
		p2.setImageUrl(null);
		p2.setSeq(2);
		p2.setDesc("소스를 2등분하여 빵에 골고루 펴발라주세요.");
		p2.setTip("소스가 도톰하게 발려야 겉은 바삭하고 속은 쫀득해요. 식빵도 좋고 바게트빵도 좋아요");
		
		p3.setImageUrl("https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/f527619b4905735ab8215944771c0e081.jpg");
		p3.setSeq(3);
		p3.setDesc("에어프라이어에 넣고 180℃에서 8분간 구워주세요.");
		p3.setTip("위가 살짝 노릇할정도만 구워야 속이 쫀득합니다.");
		
		process.add(p1);
		process.add(p2);
		process.add(p3);
		rw.setProcess(process);
		
		recipeDAO.insert(rw);

	}



}
