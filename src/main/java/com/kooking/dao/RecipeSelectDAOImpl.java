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
import com.kooking.paging.Pagenation;
import com.kooking.util.DBTestUtil;
import com.kooking.util.DbUtil;

public class RecipeSelectDAOImpl extends BoardDAO implements RecipeSelectDAO {
	private BoardDAO boardDao = new BoardDAO();

	/**
	 * 단일 레시피글의 조회 Post, Recipe를 객체로 댓글, 재료, 이미지, 조리순서의 List가 담겨있는 Wrapper를 리턴한다.
	 * 
	 * @param postno - 조회할 게시물번호
	 * @return 각각의 자료가 담겨있는 Wrapper DTO
	 * @throws Exception
	 */
	@Override
	public RecipeWrapper search(int postNo) throws Exception {
		Connection con = null;
		RecipeWrapper rw = new RecipeWrapper();
		try {
			con = DbUtil.getConnection();

			Entry<PostDTO, RecipeDTO> entry = getRecipe(postNo, con);

			if (entry == null || entry.getKey() == null || entry.getValue() == null) {
				throw new KookingException("레시피 정보를 불러오지 못했습니다.");
			}
			rw.setPost(entry.getKey());
			rw.setRecipe(entry.getValue());
			rw.getRecipe().setPost(rw.getPost());
			int recipeNo = rw.getRecipe().getNo();

			rw.getRecipe().setScore(getScore(postNo, con));
			rw.setIngredient(getIngredients(recipeNo, con));
			rw.setProcess(getProcesses(recipeNo, con));
			rw.setImages(getPostImages(postNo, con));
			rw.setComments(boardDao.getComments(postNo, con));
			

		} finally {
			DbUtil.dbClose(con);
		}

		return rw;
	}

	/**
	 * 레시피 번호로 레시피 게시글을 가져오는 메소드. 레시피 DTO와 POST DTO를 조인하여 Entry 형태로 가져옴.
	 * 
	 * @param con    - 유지할 Connection 정보, null이라면 Connection을 새로 생성함.
	 * @param postNo - 검색할 레시피 번호
	 * @return PostDTO와 RecipeDTO를 합친 Entry
	 * @throws Exception
	 */
	private Entry<PostDTO, RecipeDTO> getRecipe(int postNo, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DbUtil.getConnection();
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
				DbUtil.dbClose(ps, rs);
			} else {
				DbUtil.dbClose(con, ps, rs);
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
			con = DbUtil.getConnection();
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
				DbUtil.dbClose(ps, rs);
			} else {
				DbUtil.dbClose(con, ps, rs);
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
			con = DbUtil.getConnection();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProcessDTO> result = new ArrayList<ProcessDTO>();
		try {
			ps = con.prepareStatement(
					"SELECT PROCESS_NO, RECIPES_NO, PROCESS_URL, PROCESS_SEQ, PROCESS_DESC, PROCESS_TIP FROM PROCESS WHERE RECIPES_NO=? ORDER BY PROCESS_SEQ");
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
				DbUtil.dbClose(ps, rs);
			} else {
				DbUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}

	/**
	 * 게시판에 등록된 이미지 목록 리스트를 가져온다.
	 * 
	 * @param con      - 유지할 Connection 정보, null이라면 Connection을 새로 생성함.
	 * @param recipeNo - 검색할 게시판 번호
	 * @return 이미지 리스트
	 * @throws Exception
	 */
	private List<ImageDTO> getPostImages(int postNo, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DbUtil.getConnection();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT IMAGE_NO, IMAGE_URL, POST_NO, IMAGE_SIZE FROM IMAGES WHERE POST_NO = ? ORDER BY IMAGE_NO";
		List<ImageDTO> images = new ArrayList<ImageDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, postNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				ImageDTO img = new ImageDTO();
				img.setNo(rs.getInt(1));
				img.setUrl(rs.getString(2));
				img.setPostNo(rs.getInt(3));
				img.setSize(rs.getInt(4));

				images.add(img);
			}

		} finally {
			if (isConnected) {
				DbUtil.dbClose(ps, rs);
			} else {
				DbUtil.dbClose(con, ps, rs);
			}
		}

		return images;
	}

	/**
	 * 레시피의 평가(recommend)의 평균을 구해오는 메소드
	 * 
	 * @param postNo - 평균을 구할 레시피의 postNo
	 * @param con    - 유지할 커넥션
	 * @return 해당 레시피의 평가 점수의 평균
	 * @throws Exception
	 */
	public double getScore(int postNo, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DbUtil.getConnection();
		}
		double result = 0.0;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("SELECT AVG(RECOMMEND_SCORE) FROM RECOMMENDS WHERE POST_NO = ?");
			ps.setInt(1, postNo);
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getDouble(1);
			}

		} finally {
			if (isConnected) {
				DbUtil.dbClose(ps, rs);
			} else {
				DbUtil.dbClose(con, ps, rs);
			}
		}

		return result;
	}

	@Override
	public Entry<List<RecipeDTO>, Pagenation> getRecipeList(Pagenation page) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<RecipeDTO> recipes = new ArrayList<RecipeDTO>();
		int count = getTotalRecipesNum(con);
		int totalPage = (int) Math.ceil(page.getPageSize() / count);
		page.setPageCnt(totalPage);
		page.setTotal(count);
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM RNUM FROM VIEW_RECIPE_LIST A) WHERE RNUM BETWEEN ? AND ? ORDER BY POST_DATE DESC";

		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (page.getPageNo() - 1) * page.getPageSize() + 1);
			ps.setInt(2, page.getPageNo() * page.getPageSize());
			rs = ps.executeQuery();
			/*
			 * POST_NO NOT NULL NUMBER(20) 1 POST_TYPE_NO NOT NULL NUMBER(5) 2 USER_NO NOT
			 * NULL NUMBER(10) 3 USER_NICNAME NOT NULL VARCHAR2(60) 4 POST_TITLE NOT NULL
			 * VARCHAR2(150) 5 POST_CONTENTS NOT NULL VARCHAR2(4000) 6 POST_VIEW_COUNTS NOT
			 * NULL NUMBER(10) 7 POST_DATE NOT NULL DATE 8 RECIPES_NO NOT NULL NUMBER(20) 9
			 * RECIPES_NAME NOT NULL VARCHAR2(100) 10 RECIPES_CALORIE NUMBER(10) 11
			 * RECIPES_COOKING_TIME NUMBER(8) 12 RECIPES_NATION VARCHAR2(30) 13 RECIPES_TYPE
			 * VARCHAR2(30) 14 RECIPES_LEVEL VARCHAR2(30) 15 SCORE NUMBER 16
			 * 
			 */
			while (rs.next()) {
				PostDTO post = new PostDTO();
				post.setNo(rs.getInt(1));
				post.setPostTypeNo(rs.getInt(2));
				post.setUserNo(rs.getInt(3));
				post.setUserNicname(rs.getString(4));
				post.setTitle(rs.getString(5));
				post.setContents(rs.getString(6));
				post.setCounts(rs.getInt(7));
				post.setDate(rs.getString(8));

				RecipeDTO recipe = new RecipeDTO();
				recipe.setNo(rs.getInt(9));
				recipe.setName(rs.getString(10));
				recipe.setCalorie(rs.getInt(11));
				recipe.setCookingTime(rs.getInt(12));
				recipe.setNation(rs.getString(13));
				recipe.setType(rs.getString(14));
				recipe.setLevel(rs.getString(15));
				recipe.setScore(rs.getDouble(16));
				recipe.setPost(post);
				recipe.setThumbnail(rs.getString(17));

				recipes.add(recipe);
			}

		} finally {
			DBTestUtil.dbClose(ps, rs, con);
		}
		
		return new SimpleEntry<List<RecipeDTO>, Pagenation>(recipes, page);
	}

	/**
	 * 레시피의 전체 개수를 가져오는 메소드
	 * 
	 * @param con - 유지할 커넥션
	 * @return 등록된 레시피의 총 개수
	 * @throws Exception
	 */
	public int getTotalRecipesNum(Connection con) throws Exception {
		boolean isConnected = (con != null);
		if (!isConnected) {
			con = DBTestUtil.getConnection();
		}
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM VIEW_RECIPE_LIST");
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
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

	@Override
	public List<RecipeDTO> searchQuery(RecipeDTO recipe, Pagenation page) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecipeDTO> recipes = new ArrayList<RecipeDTO>();
		try {
			con = DbUtil.getConnection();
			ps = parseSearchQuery(recipe, con);
			rs = ps.executeQuery();
			while (rs.next()) {
				PostDTO post = new PostDTO();
				post.setNo(rs.getInt(1));
				post.setPostTypeNo(rs.getInt(2));
				post.setUserNo(rs.getInt(3));
				post.setUserNicname(rs.getString(4));
				post.setTitle(rs.getString(5));
				post.setContents(rs.getString(6));
				post.setCounts(rs.getInt(7));
				post.setDate(rs.getString(8));

				RecipeDTO recipeDTO = new RecipeDTO();
				recipeDTO.setNo(rs.getInt(9));
				recipeDTO.setName(rs.getString(10));
				recipeDTO.setCalorie(rs.getInt(11));
				recipeDTO.setCookingTime(rs.getInt(12));
				recipeDTO.setNation(rs.getString(13));
				recipeDTO.setType(rs.getString(14));
				recipeDTO.setLevel(rs.getString(15));
				recipeDTO.setScore(rs.getDouble(16));
				recipeDTO.setPost(post);

				recipes.add(recipeDTO);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return recipes;
	}

	/**
	 * 
	 */
	private PreparedStatement parseSearchQuery(RecipeDTO recipe, Connection con) throws Exception {
		StringBuilder sql = new StringBuilder("SELECT * FROM VIEW_RECIPE_LIST");
		List<String> list = new ArrayList<String>();
		List<Integer> types = new ArrayList<Integer>(); // 0=String, 1=Int, 2=Double
		List<Object> values = new ArrayList<Object>();
		if (recipe == null) {
			return con.prepareStatement(sql.toString());
		}
		if (recipe.getPost() != null && recipe.getPost().getUserNicname() != null) {
			list.add("USER_NICNAME LIKE '%'||?||'%'");
			types.add(0);
			values.add(recipe.getPost().getUserNicname());
		}
		if (recipe.getCalorie() > 0) {
			list.add("RECIPES_CALORIE <= ?");
			types.add(1);
			values.add(recipe.getCalorie());
		}
		if (recipe.getCookingTime() > 0) {
			list.add("RECIPES_COOKING_TIME <= ?");
			types.add(1);
			values.add(recipe.getCookingTime());
		}
		if (recipe.getNation() != null) {
			list.add("RECIPES_NATION = ?");
			types.add(0);
			values.add(recipe.getNation());
		}
		if (recipe.getType() != null) {
			list.add("RECIPES_TYPE = ?");
			types.add(0);
			values.add(recipe.getType());
		}
		if (recipe.getLevel() != null) {
			list.add("RECIPES_Level = ?");
			types.add(0);
			values.add(recipe.getLevel());
		}
		if (recipe.getScore() > 0.0) {
			list.add("SCORE <= ?");
			types.add(3);
			values.add(recipe.getScore());

		}
		if (recipe.getName() != null) {
			list.add("RECIPES_NAME LIKE '%'||?||'%'");
			types.add(0);
			values.add(recipe.getName());
		}

		if (list.isEmpty()) {
			return con.prepareStatement(sql.toString());
		}

		sql.append(" WHERE ");
		sql.append(String.join(" AND ", list));
		PreparedStatement ps = con.prepareStatement(sql.toString());
		System.out.println(sql.toString());
		for (int i = 0; i < list.size(); i++) {
			switch (types.get(i)) {
			case 0:
				ps.setString(i + 1, (String) values.get(i));
				break;
			case 1:
				ps.setInt(i + 1, (Integer) values.get(i));
				break;
			case 3:
				ps.setDouble(i + 1, (Double) values.get(i));
				break;
			}
		}
		return ps;
	}

	@Override
	public int addRecipeScore(int postNo, int userNo, int score) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO RECOMMENDS(RECOMMEND_NO, USER_NO, POST_NO, RECOMMEND_SCORE, RECOMMEND_DATE) VALUES(RECOMMEND_NO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, postNo);
			ps.setInt(2, userNo);
			ps.setInt(3, score);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		RecipeSelectDAOImpl dao = new RecipeSelectDAOImpl();


		System.out.println(dao.getRecipeList(new Pagenation()));

	}

}
