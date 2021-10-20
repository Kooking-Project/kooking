package com.kooking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.service.RecipeSelectService;
import com.kooking.service.RecipeSelectServiceImpl;

public class RecipeSelectController implements Controller{
	private RecipeSelectService service = new RecipeSelectServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	public ModelAndView recipeList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pageNum");
		
	
		request.setAttribute("recipeList", service.getRecipeList(null));
		
		
		return new ModelAndView("receipe/receipeList.jsp");
		
	}
}
