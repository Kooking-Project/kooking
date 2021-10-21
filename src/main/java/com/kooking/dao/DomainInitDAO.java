package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kooking.dto.PostTypeDTO;
import com.kooking.dto.RecipeDetailDTO;
import com.kooking.util.DbUtil;

public class DomainInitDAO {
	
	/**
	 * 레시피의 카테고리를 가져오는 메소드. 
	 * @return 레시피 카테고리 이름을 Key로 하는 레시피 분류 리스트가 담긴 Map
	 * @throws Exception
	 */
	public Map<String, List<RecipeDetailDTO>> getRecipeDomains() throws Exception{
		Map<String, List<RecipeDetailDTO>> category = new HashMap<String, List<RecipeDetailDTO>>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("SELECT * FROM RECIPE_DETAIL NATURAL JOIN RECIPE_CATEGORY");
			rs = ps.executeQuery();
			List<RecipeDetailDTO> details = null;
			while(rs.next()) {
				RecipeDetailDTO detail = new RecipeDetailDTO();
				detail.setName(rs.getString(2));
				detail.setRecipeCategoryNo(rs.getInt(1));
				detail.setRecipeCategoryName(rs.getString(3));
				
				if(category.containsKey(detail.getRecipeCategoryName())) {
					details.add(detail);
				}else {
					details = new ArrayList<RecipeDetailDTO>();
					category.put(detail.getRecipeCategoryName(), details);
					details.add(detail);
				}
				
				
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return category;
	}
	
	//TODO : 게시판 분류 가져오기
	List<PostTypeDTO> getPostTypes() {
		
		return null;
	}
	
}
