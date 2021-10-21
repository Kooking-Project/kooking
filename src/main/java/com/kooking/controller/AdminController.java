package com.kooking.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.dto.UserDTO;
import com.kooking.paging.Pagenation;
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
	
	/**
	 * 전체회원 정보 조회(관리자)
	 * */
	public ModelAndView userSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pageNum");
		Pagenation page = new Pagenation();
		
		if(order!=null)
		page.setOrder(Integer.parseInt(order));
		if(pageNum!=null)
		page.setPageNo(Integer.parseInt(pageNum));
		
		Entry<List<UserDTO>, Pagenation> userList = service.userSelectAll(adminNo, page);
		request.setAttribute("userList", userList.getKey());
		request.setAttribute("page", userList.getValue());
		
		return new ModelAndView("adminTest.jsp");
	}
	
	/**
	 * 회원 상세정보 조회(관리자)
	 * */
	public ModelAndView userSelectByNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		UserDTO user = service.userSelectByNo(adminNo, userNo);
		request.setAttribute("user", user);
		
		return new ModelAndView("admin.jsp");
	}

	/**
	 * 회원 상태 변경 조회(관리자)
	 * */
	public ModelAndView changeUserStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));	//접속자가 관리자 no 받기
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));	//변경할 유저의 활동상태와 유저 no 받기
		int userStatus = Integer.parseInt(request.getParameter("userStatus"));
		UserDTO userDTO = new UserDTO(userNo,userStatus);
		
		service.changeUserStatus(adminNo, userDTO);
		
		return new ModelAndView("adminTest.jsp", true);
	}

	/**
	 * 댓글 삭제(관리자)
	 * */
	public ModelAndView commentDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		service.commentDelete(adminNo, userNo, commentNo);
		
		return new ModelAndView("adminTest.jsp", true);
	}

	/**
	 * 게시글 삭제(관리자)
	 * */
	public ModelAndView postDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		service.postDelete(adminNo, userNo, postNo);
		
		return new ModelAndView("adminTest.jsp", true);
	}

}
