package com.kooking.service;

import java.util.List;

import com.kooking.dao.RecipeSelectDAOImpl;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.paging.Pagenation;

public class RecipeSelectServiceImpl implements RecipeSelectService{
	private RecipeSelectDAOImpl dao = new RecipeSelectDAOImpl();
	@Override
	public RecipeWrapper search(int recipeNo) throws Exception {
		return dao.search(recipeNo);
	}

	@Override
	public List<RecipeDTO> searchQuery(RecipeDTO recipe, Pagenation page) throws Exception {
		
		return dao.searchQuery(recipe, page);
	}

	@Override
	public int addRecipeScore(int postNo, int userNo, int score) throws Exception {
		
		return dao.addRecipeScore(postNo, userNo, score);
	}

}
