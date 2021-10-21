package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.kooking.util.DbUtil;

public class RecipeDAOImpl extends BoardDAO implements RecipeDAO  {
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
	 * 레시피 등록하기 
	 *  - 1. Post 삽입
	 *  - 2. Recipe 삽입
	 *  - 3. 재료 삽입
	 *  - 4. 조리순서 삽입
	 *  - 5. 이미지 삽입
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
	@Override
	public boolean insert(RecipeWrapper wrapper) throws Exception {
		Connection con = null;
		boolean result = false;

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);

			if(insertPost(wrapper.getPost(), con) <=0 ) {
				throw new KookingException("게시글 작성에 실패했습니다. : " + wrapper.getPost().getNo());
			}

			if(insertRecipe(wrapper.getRecipe(), con) <= 0) {
				throw new KookingException("레시피 작성에 실패했습니다. : " + wrapper.getRecipe().getNo());
			}

			for(int i : insertIngredient(wrapper.getIngredient(), con)) {
				if(i<=0) {
					throw new KookingException("재료 등록에 실패했습니다.");
				}
			}

			for(int i : insertProcess(wrapper.getProcess(), con)) {
				if(i<=0) {
					throw new KookingException("조리과정 등록에 실패했습니다.");
				}
			}

//			for(int i : insertImage(wrapper.getImages(), con)){
//				if(i<=0) {
//					throw new KookingException("이미지 등록에 실패했습니다.");
//				}
//			}

			result = true;
			con.commit();

		}finally {
			con.rollback();
			DbUtil.dbClose(con);
		}
		return result;
	}

	/**
	 * 레시피 등록하기
	 * @author 박효승
	 * @date 2021-10-17	
	 */
	public int insertRecipe(RecipeDTO recipe, Connection con) throws Exception {
		PreparedStatement ps = null;
		int result = 0;
		if(recipe == null) {
			throw new KookingException("레시피 정보가 없습니다.");
		}
		//INSERT INTO RECIPES(RECIPES_NO,RECIPES_NAME,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL,RECIPE_THUMBNAIL) VALUES(RECIPE_NO_SEQ.NEXTVAL,?,POST_NO_SEQ.CURRVAL,?,?,?,?,?,?)
		String sql = proFile.getProperty("query.insertRecipe");		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, recipe.getName());//레시피이름
			ps.setInt(2, recipe.getCalorie());//칼로리
			ps.setInt(3, recipe.getCookingTime());//조리시간
			ps.setString(4, recipe.getNation());//레시피국가
			ps.setString(5, recipe.getType());//레시피분류
			ps.setString(6, recipe.getLevel());//난이도
			ps.setString(7, recipe.getThumbnail());//레시피 대표 이미지

			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps);
		}
		return result;
	}

	/**
	 * 레시피 재료 등록하기
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
	public int[] insertIngredient(List<IngredientDTO> ingredients, Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.insertIngredient");	
		int result [] = null;

		try {
			ps = con.prepareStatement(sql);
			for(IngredientDTO ingredient : ingredients) {
				ps.setString(1, ingredient.getName());//재료이름
				ps.setInt(2, ingredient.getSeq());//재료순서
				ps.setString(3, ingredient.getCacty());//재료용량

				ps.addBatch();//일괄처리할 작업에 추가
				ps.clearParameters();
			}
			result = ps.executeBatch();//일괄처리
		} finally {
			DbUtil.dbClose(ps);
		}
		return result;
	}

	/**
	 * 이미지 등록하기
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
//	public int[] insertImage(List<ImageDTO> images, Connection con) throws Exception{
//		PreparedStatement ps = null;
//		String sql = proFile.getProperty("query.insertImage");		
//		//TODO : 이미지 테이블 변경 후 SQL문 수정
//		int result [] = null;
//
//		try {
//			ps = con.prepareStatement(sql); 
//			for(ImageDTO image : images) {
//				ps.setString(1, image.getUrl());//이미지 URL
//				ps.setInt(2, image.getSize());//이미지용량
//
//				ps.addBatch();
//				ps.clearParameters();
//			}
//			result = ps.executeBatch();
//		} finally {
//			DBTestUtil.dbClose(ps);
//		}
//		return result;
//	} 

	/**
	 * 레시피 조리과정 등록하기
	 * @author 박은솔
	 * @date 2021-10-17	
	 */
	public int[] insertProcess(List<ProcessDTO> processes,Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.insertProcess");		
		//TODO : IMAGE_URL 컬럼명 변경
		int result [] = null;

		try {
			ps = con.prepareStatement(sql);
			for(ProcessDTO process : processes) {
				ps.setString(1, process.getImageUrl());//조리과정이미지URL
				ps.setInt(2, process.getSeq());//조리과정순서
				ps.setString(3, process.getDesc());//조리과정설명
				ps.setString(4, process.getTip());//과정팁

				ps.addBatch();
				ps.clearParameters();
			}
			result = ps.executeBatch();
		} finally {
			DbUtil.dbClose(ps);
		}
		return result;
	} 

	/**
	 * 레시피 수정하기 
	 *  - 1. Post 수정
	 *  - 2. Recipe 수정
	 *  - 3. 재료 수정
	 *  - 4. 조리순서 수정
	 *  - 5. 이미지 수정
	 * @author 박은솔
	 * @date 2021-10-18	
	 */
	@Override
	public boolean update(RecipeWrapper wrapper) throws Exception {
		Connection con = null;
		boolean result = false;

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);

			if(updatePost(wrapper.getPost(), con) <=0 ) {
				throw new KookingException("게시글 수정에 실패했습니다. : " + wrapper.getPost().getNo()); // TODO: 게시글 수정 테스트 
			}

			if(updateRecipe(wrapper.getRecipe(), con) <= 0) {
				throw new KookingException("레시피 수정에 실패했습니다. : " + wrapper.getRecipe().getNo());
			}

			for(int i : updateIngredient(wrapper.getIngredient(), con)) {
				if(i<=0) {
					throw new KookingException("재료 수정에 실패했습니다.");
				}
			}

			for(int i : updateProcess(wrapper.getProcess(), con)) {
				if(i<=0) {
					throw new KookingException("조리과정 수정에 실패했습니다.");
				}
			}

//			for(int i : updateImage(wrapper.getImages(), con)){
//				if(i<=0) {
//					throw new KookingException("이미지 수정에 실패했습니다.");
//				}
//			}
			result = true;
			con.commit();
		}finally {
			con.rollback();
			DbUtil.dbClose(con);
		}
		return result;
	}


	/**
	 * 레시피 수정하기
	 * @author 박은솔
	 * @date 2021-10-18	
	 */
	public int updateRecipe(RecipeDTO recipe, Connection con) throws Exception {
		PreparedStatement ps = null;
		int result = 0;
		if(recipe == null) {
			throw new KookingException("레시피 정보가 없습니다.");
		}
		String sql = proFile.getProperty("query.updateRecipe");		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, recipe.getName());//레시피이름
			ps.setInt(2, recipe.getCalorie());//칼로리
			ps.setInt(3, recipe.getCookingTime());//조리시간
			ps.setString(4, recipe.getNation());//레시피국가
			ps.setString(5, recipe.getType());//레시피분류
			ps.setString(6, recipe.getLevel());//난이도
			ps.setString(7, recipe.getThumbnail());//레시피 대표 이미지
			ps.setInt(8, recipe.getPostNo());//게시글번호
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps);
		}
		return result;
	}

	/**
	 * 레시피 재료 수정하기 : 재료이름과 재료용량만 수정가능
	 * @author 박은솔
	 * @date 2021-10-18
	 */
	public int[] updateIngredient(List<IngredientDTO> ingredients, Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.updateIngredient");
		int result [] = null;
		try {
			ps = con.prepareStatement(sql);
			for(IngredientDTO ingredient : ingredients) {
				ps.setString(1, ingredient.getName());//재료이름
				ps.setString(2, ingredient.getCacty());//재료용량
				ps.setInt(3, ingredient.getRecipesNo());//레시피번호
				ps.setInt(4, ingredient.getSeq());//재료순서

				ps.addBatch();//일괄처리할 작업에 추가
				ps.clearParameters();
			}
			result = ps.executeBatch();//일괄처리
		} finally {
			DbUtil.dbClose(ps);
		}
		return result;
	}

	/**
	 * 레시피 조리과정 수정하기
	 * @author 박은솔
	 * @date 2021-10-18
	 */
	public int[] updateProcess(List<ProcessDTO> processes,Connection con) throws Exception{
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.updateProcess");
		//TODO : IMAGE_URL 컬럼명 변경

		int result [] = null;
		try {
			ps = con.prepareStatement(sql);
			for(ProcessDTO process : processes) {
				ps.setString(1, process.getImageUrl());//조리과정이미지URL
				ps.setString(2, process.getDesc());//조리과정설명
				ps.setString(3, process.getTip());//과정팁
				ps.setInt(4, process.getRecipesNo());//RECIPES_NO
				ps.setInt(5, process.getSeq());//PROCESS_SEQ

				ps.addBatch();
				ps.clearParameters();
			}
			result = ps.executeBatch();
		} finally {
			DbUtil.dbClose(ps);
		}
		return result;
	} 

	/**
	 * 이미지 수정하기
	 * @author 박은솔
	 * @date 2021-10-18
	 */
//	public int[] updateImage(List<ImageDTO> images, Connection con) throws Exception{
//		PreparedStatement ps = null;
//		String sql = proFile.getProperty("query.updateImage");		
//		int result [] = null;
//
//		try {
//			ps = con.prepareStatement(sql); 
//			for(ImageDTO image : images) {
//				ps.setString(1, image.getUrl());//이미지 URL
//				ps.setInt(2, image.getPostNo());//게시글번호
//				ps.setString(3, image.getUrl());//바꿀 이미지 URL
//
//				ps.addBatch();
//				ps.clearParameters();
//			}
//			result = ps.executeBatch();
//		} finally {
//			DbUtil.dbClose(ps);
//		}
//		return result;
//	} 

	//테스트
	public static void main(String[] args) throws Exception{
		RecipeDAO recipeDAO = new RecipeDAOImpl();
		RecipeWrapper rw = new RecipeWrapper();
		PostDTO post = new PostDTO();
		post.setNo(55);
		post.setTitle("치킨은 금요일에 먹는게 제일 맛있어");
		post.setContents("지코바 맛");
		post.setUserNo(1);
		post.setPostTypeNo(1);
		rw.setPost(post);
		System.out.println(post);

		RecipeDTO recipe = new RecipeDTO();
		recipe.setNo(37);
		recipe.setPostNo(55); 
		recipe.setName("치킨");
		recipe.setCalorie(800);
		recipe.setCookingTime(15);
		recipe.setNation("한식");
		recipe.setType("튀김/커틀릿");
		recipe.setLevel("쉬움");
		recipe.setThumbnail("RECIPE_DEFAULT.PNG");
		rw.setRecipe(recipe);
		System.out.println(recipe);

		List<IngredientDTO> ingredients = new ArrayList<IngredientDTO>();
		IngredientDTO i1 = new IngredientDTO();
		IngredientDTO i2 = new IngredientDTO();
		IngredientDTO i3 = new IngredientDTO();
		i1.setName("손질된 닭");
		i1.setCacty("한마리");
		i1.setRecipesNo(37);
		i1.setSeq(1);

		i2.setName("치킨 무");
		i2.setCacty("1개");
		i2.setRecipesNo(37);
		i2.setSeq(2);

		i3.setName("비법 양념소스");
		i3.setCacty("1통");
		i3.setRecipesNo(37);
		i3.setSeq(3);

		ingredients.add(i1);
		ingredients.add(i2);
		ingredients.add(i3);
		rw.setIngredient(ingredients);
		System.out.println(ingredients);

		List<ImageDTO> images = new ArrayList<ImageDTO>();
		ImageDTO img1 = new ImageDTO();
		ImageDTO img2 = new ImageDTO();
		ImageDTO img3 = new ImageDTO();

		img1.setUrl("https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png");
		img1.setPostNo(55);
		img1.setUrl("지코바조리사진1.jpg");

		img2.setUrl("https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/72d6a27278d2eb32b960ceafd49ea2741.png");
		img2.setPostNo(55);
		img2.setUrl("지코바조리사진2.jpg");

		img3.setUrl("https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/f527619b4905735ab8215944771c0e081.jpg");
		img3.setPostNo(55);
		img3.setUrl("지코바조리사진3.jpg");

		images.add(img1);
		images.add(img2);
		images.add(img3);
		rw.setImages(images);
		System.out.println(images);

		List<ProcessDTO> process = new ArrayList<ProcessDTO>();
		ProcessDTO p1 = new ProcessDTO();
		ProcessDTO p2 = new ProcessDTO();
		ProcessDTO p3 = new ProcessDTO();

		p1.setImageUrl("https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png");
		p1.setRecipesNo(37);
		p1.setSeq(1);
		p1.setDesc("손질한 닭을 준비해서 에어프라이어 180℃에서 12분간 구워주세요.");
		p1.setTip(null);

		p2.setImageUrl("지코바2.jpg");
		p2.setRecipesNo(37);
		p2.setSeq(2);
		p2.setDesc("치킨무를 먹기 위해 포크를 준비");
		p2.setTip("치킨무는 차가울 수록 더 맛있어요.");

		p3.setImageUrl("지코바3.jpg");
		p3.setRecipesNo(37);
		p3.setSeq(3);
		p3.setDesc("비법소스를 맛있게 부어줍니다.");
		p3.setTip("위가 살짝 노릇할정도만 구워야 속이 쫀득합니다.");

		process.add(p1);
		process.add(p2);
		process.add(p3);
		rw.setProcess(process);
		System.out.println(process);

		recipeDAO.update(rw);

	}

}
