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

		//접속자가 관리자 no 받기
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		
		//변경할 유저의 활동상태와 유저 no 받기
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int userStatus = Integer.parseInt(request.getParameter("userStatus"));
		UserDTO userDTO = new UserDTO(userNo,userStatus);
		
		service.changeUserStatus(adminNo, userDTO);
		
		return new ModelAndView("adminTest.jsp", true);
	}

	public ModelAndView commentDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		service.commentDelete(adminNo, commentNo);
		
		return new ModelAndView("adminTest.jsp", true);
	}

	public ModelAndView postDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		service.postDelete(adminNo, postNo);
		
		return new ModelAndView("adminTest.jsp", true);
	}
	
	

}
