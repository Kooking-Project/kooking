package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.RecipeDTO;

public class RecipeDAOImpl implements RecipeDAO {
	Properties proFile = new Properties();
	
	public RecipeDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));

			System.out.println("query : " + proFile.getProperty("recipe.selectAll"));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RecipeDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		return null;
	}

	@Override
	public List<RecipeDTO> getRecipeList(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeDTO selectByNo(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(RecipeDTO recipe) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RecipeDTO recipe) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommentDTO> selectCommentsByRecipeNo(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
