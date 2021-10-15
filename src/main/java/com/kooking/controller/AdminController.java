package com.kooking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.kooking.dto.UserDTO;
import com.kooking.service.AdminService;
import com.kooking.service.AdminServiceImpl;

public class AdminController implements Controller {
	private AdminService service = new AdminServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView changeUserStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");

		//접속자가 관리자 no 받기
		int adminNo = 0;
		//변경할 유저의 활동상태와 유저 no 받기
		UserDTO userDTO = new UserDTO();
		
		service.changeUserStatus(adminNo, userDTO);
		
	/*
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", userDTO.getUserId());
		session.setAttribute("loginName", userDTO.getName());
	*/
		return new ModelAndView("index.jsp", true);
	}

}
