package com.kooking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.UserDTO;
import com.kooking.service.UserService;
import com.kooking.service.UserServiceImpl;

public class UserController implements Controller {
	 private UserService userSerivce = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 로그인
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		UserDTO userDTO = userSerivce.loginCheck(id, pwd);
		
		//여기까지 왔다는 이야기는 예외없이 정상이므로 session에 정보를 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", id);
		//session.setAttribute("loginName", );
		
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("index.jsp");
	   mv.setRedirect(true);
	   
		return mv;
	}

}
