package com.kooking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.dto.RecipeDTO;
import com.kooking.paging.Pagenation;
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
		
		List<RecipeDTO> list = service.getRecipeList(new Pagenation());
		request.setAttribute("recipeList", list);
		

		return new ModelAndView("RecipeTest.jsp");
		
	}
	
	public static void main(String[] args) throws Exception {
		RecipeSelectController rc = new RecipeSelectController();
		System.out.println(rc.service.getRecipeList(null));
	}
}
