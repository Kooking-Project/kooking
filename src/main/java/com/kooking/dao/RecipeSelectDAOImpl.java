package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.ProcessDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.exception.KookingException;
import com.kooking.paging.PageCnt;
import com.kooking.util.DBTestUtil;
import com.kooking.util.DbUtil;

public class RecipeSelectDAOImpl implements RecipeSelectDAO {

	@Override
	public RecipeWrapper search(int postNo) throws Exception {
		Connection con = null;
		RecipeWrapper rw = new RecipeWrapper();
		try {
			con = DBTestUtil.getConnection();

			Entry<PostDTO, RecipeDTO> entry = getRecipe(postNo, con);

			if (entry == null || entry.getKey() == null || entry.getValue() == null) {
				throw new KookingException("레시피 정보를 불러오지 못했습니다.");
			}
			rw.setPost(entry.getKey());
			rw.setRecipe(entry.getValue());

			int recipeNo = rw.getRecipe().getNo();

			rw.setIgredients(getIngredients(recipeNo, con));
			rw.setProcess(getProcesses(recipeNo, con));

		} finally {
			DbUtil.dbClose(con);
		}

		return null;
	}

	/**
	 * 레시피 번호로 레시피 게시글을 가져오는 메소드 레시피 DTO와 POST DTO를 조인하여 모두 가져옴.
	 * 
	 * @param con    - 유지할 Connection 정보, null이라면 Connection을 새로 생성함.
	 * @param postNo - 검색할 레시피 번호
	 * @return PostDTO와 RecipeDTO를 합친 Entry
	 * @throws Exception
	 */
	private Entry<PostDTO, RecipeDTO> getRecipe(int postNo, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		Entry<PostDTO, RecipeDTO> result = null;
		try {
			ps = con.prepareStatement(
					"SELECT POST_NO, POST_TYPE_NO, POST_TITLE, POST_CONTENTS, POST_VIEW_COUNTS, POST_DATE, RECIPES_NO, RECIPES_NAME, RECIPES_CALORIE, RECIPES_COOKING_TIME, RECIPES_NATION, RECIPES_TYPE, RECIPES_LEVEL FROM POSTS INNER JOIN RECIPES USING(POST_NO) WHERE POST_NO=?");
			ps.setInt(1, postNo);
			rs = ps.executeQuery();
			PostDTO post = new PostDTO();
			RecipeDTO recipe = new RecipeDTO();
			if (rs.next()) {
				post.setNo(rs.getInt(1));
				recipe.setPostNo(rs.getInt(1));
				post.setPostTypeNo(rs.getInt(2));
				post.setTitle(rs.getString(3));
				post.setContents(rs.getString(4));
				post.setCounts(rs.getInt(5));
				post.setDate(rs.getString(6));

				recipe.setNo(rs.getInt(7));
				recipe.setName(rs.getString(8));
				recipe.setCalorie(rs.getInt(9));
				recipe.setCookingTime(rs.getInt(10));
				recipe.setNation(rs.getString(10));
				recipe.setType(rs.getString(11));
				recipe.setLevel(rs.getString(12));

				result = new SimpleEntry<PostDTO, RecipeDTO>(post, recipe);
			}
		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}

	/**
	 * 레시피 번호를 이용하여 해당하는 재료리스트를 가져온다. 재료는 재료순서로 정렬된다.
	 * 
	 * @param con      - 유지할 Connection 정보, null이라면 Connection을 새로 생성함.
	 * @param recipeNo - 검색할 레시피 번호
	 * @return 재료 순서에 따라 정렬된 재료 List
	 * @throws Exception
	 */
	private List<IngredientDTO> getIngredients(int recipeNo, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<IngredientDTO> result = new ArrayList<IngredientDTO>();
		try {
			ps = con.prepareStatement(
					"SELECT INGREDIENT_NO, RECIPES_NO, INGREDIENT_NAME, INGREDIENT_SEQ, INGREDIENT_CACTY  FROM INGREDIENTS WHERE RECIPES_NO = ? ORDER BY INGREDIENT_SEQ");
			ps.setInt(1, recipeNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				IngredientDTO dto = new IngredientDTO();
				dto.setNo(rs.getInt(1));
				dto.setRecipesNo(rs.getInt(2));
				dto.setName(rs.getString(3));
				dto.setSeq(rs.getInt(4));
				dto.setCacty(rs.getString(5));
				result.add(dto);
			}

		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}

		return result;
	}

	/**
	 * 레시피 번호를 이용하여 해당하는 조리과정 리스트를 가져온다. 조리과정은 조리순서(PROCESS_SEQ)로 정렬된다.
	 * 
	 * @param con      - 유지할 Connection 정보, null이라면 Connection을 새로 생성함.
	 * @param recipeNo - 검색할 레시피 번호
	 * @return 조리순서에 따라 정렬된 조리과정 List
	 * @throws Exception
	 */
	private List<ProcessDTO> getProcesses(int recipeNo, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProcessDTO> result = new ArrayList<ProcessDTO>();
		try {
			ps = con.prepareStatement(
					"SELECT PROCESS_NO, RECIPES_NO, IMAGE_URL, PROCESS_SEQ, PROCESS_DESC, PROCESS_TIP FROM PROCESS WHERE RECIPES_NO=? ORDER BY PROCESS_SEQ");
			ps.setInt(1, recipeNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProcessDTO process = new ProcessDTO();
				process.setNo(rs.getInt(1));
				process.setRecipesNo(rs.getInt(2));
				process.setImageUrl(rs.getString(3));
				process.setSeq(rs.getInt(4));
				process.setDesc(rs.getString(5));
				process.setTip(rs.getString(6));
				result.add(process);
			}

		} finally {
			if (isConnected) {
				DBTestUtil.dbClose(ps, rs);
			} else {
				DBTestUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}

	private List<ImageDTO> getPostImages(Connection con, int postNo) throws Exception{
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT IMAGE_NO, IMAGE_URL, POST_NO, IMAGE_SIZE FROM IMAGES WHERE POST_NO = ?";
		List<ImageDTO> images = new ArrayList<ImageDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, postNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ImageDTO img = new ImageDTO();
				img.setNo(rs.getInt(1));
				img.setUrl(sql);
			}
			
		}finally {
			
		}
		
		
		
		return null;
	}

	@Override
	public List<RecipeWrapper> searchQueryAll(PostDTO postDTO, RecipeDTO recipe, PageCnt cnt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecipeWrapper> searchQueryAll(PostDTO postDTO, RecipeDTO recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addRecipeScore(int postNo, int userNo, int score) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) throws Exception {
		RecipeSelectDAOImpl dao = new RecipeSelectDAOImpl();
		Connection con = DBTestUtil.getConnection();
	}

}
