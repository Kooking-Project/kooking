package com.kooking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.service.RecipeService;
import com.kooking.service.RecipeServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipeController implements Controller {
	private RecipeService recipeService = new RecipeServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 레시피 등록하기
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String no = request.getParameter("recipe_no");//레시피 번호
		String postNo = request.getParameter("post_no");//게시글 번호
		String name = request.getParameter("recipe_Name");//레시피 이름
		String calorie = request.getParameter("calorie");//칼로리
		String cookingTime = request.getParameter("cookingTime");//조리시간
		String nation = request.getParameter("recipe_nation");//레시피 국가
		String type = request.getParameter("recipe_type");//레시피 분류
		String level = request.getParameter("recipe_level");//레시피 조리난이도
		
		
		

		
		
		return new ModelAndView("recipeTest.jsp", true);

	}
	
	/**
     * 레시피 수정하기 폼
     * */
    public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	
    	
    	return new ModelAndView("recipe/update.jsp");
    }
    
    /**
     * 수정완료
     * */
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
    	return new ModelAndView("recipe/read.jsp");
    }
	
}
