package com.kooking.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kooking.dto.RecipeDetailDTO;


/**
 * 레시피 카테고리를 가져오는 유틸리티 클래스
 * 작성중
 * @author 박효승
 *
 */
public final class CategoryUtil {
	private static final Map<String, RecipeDetailDTO> rdMap;
	private CategoryUtil() {}
	
	public static RecipeDetailDTO getRecipeDetail(String name) {
		return rdMap.get(name);
	}
	
	public static Set<String> getCategories() {
		return rdMap.keySet();
	}
	
	public static Map<String, RecipeDetailDTO> getMap() {
		return rdMap;
	}
	
	public static List<RecipeDetailDTO> getDetails(String name){
		List<RecipeDetailDTO> list = new ArrayList<RecipeDetailDTO>();
		for(String key : rdMap.keySet()) {
			RecipeDetailDTO rd = rdMap.get(key);
			if(key.equals(rd.getRecipeCategoryName())) {
				list.add(rd);
			}
		}
		return list;
	}
	
	static {
		rdMap = new HashMap<String, RecipeDetailDTO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBTestUtil.getConnection();
			ps = con.prepareStatement("SELECT RECIPE_DETAIL_NAME, RECIPE_CATEGORY_NO, RECIPE_CATEGORY_NAME FROM RECIPE_DETAIL  INNER JOIN RECIPE_CATEGORY USING(RECIPE_CATEGORY_NO)");
			rs = ps.executeQuery();
			while(rs.next()) {
				RecipeDetailDTO rd = new RecipeDetailDTO();
				rd.setName(rs.getString(1));
				rd.setRecipeCategoryNo(rs.getInt(2));
				rd.setRecipeCategoryName(rs.getString(3));
				rdMap.put(rd.getName(), rd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTestUtil.dbClose(con, ps, rs);
		}
		
	}
}
