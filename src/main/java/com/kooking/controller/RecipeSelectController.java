package com.kooking.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
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
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pageNum");
		Pagenation page = new Pagenation();
		
		if(order!=null)
		page.setOrder(Integer.parseInt(order));
		if(pageNum!=null)
		page.setPageNo(Integer.parseInt(pageNum));
		
		page.setPageSize(12);
		Entry<List<RecipeDTO>, Pagenation> entry = service.getRecipeList(page);
		request.setAttribute("recipeList", entry.getKey());
		request.setAttribute("page", entry.getValue());
		return new ModelAndView("recipe/recipeList.jsp");
		
	}
	
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int recipeNo = Integer.parseInt(request.getParameter("no"));
		RecipeWrapper wrapper = service.search(recipeNo);
		request.setAttribute("wrapper", wrapper);
		
		return new ModelAndView("recipe/recipeRead.jsp");
	}
}
