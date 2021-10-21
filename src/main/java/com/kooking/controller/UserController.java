package com.kooking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.paging.Pagenation;
import com.kooking.service.UserService;
import com.kooking.service.UserServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.sf.json.JSONArray;

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
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		UserDTO userDTO = userSerivce.loginCheck(id, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("userDTO", userDTO);
		// session.setAttribute("loginName", );

		System.out.println(id);

		return new ModelAndView("index.jsp", true);

	}

	/**
	 * 로그아웃
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();

		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 회원가입
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		
		String profileImg = request.getParameter("profileImg");
		

		//UserDTO userDTO = new UserDTO(Integer.parseInt(no), id, pwd, nickName, Integer.parseInt(gender), enrollDate,
		//		profileImg, Integer.parseInt(status));

		UserDTO userDTO = new UserDTO( id, nickName, pwd, Integer.parseInt(gender));
	
		userSerivce.insert(userDTO);

		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 유저 정보 변경
	 */
	public ModelAndView userUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		String filesystemName = request.getParameter("file");

		UserDTO userDTO = null;
		if(newPwd.equals("")) {
			userDTO = new UserDTO(Integer.parseInt(no), id, pwd, nickName, Integer.parseInt(gender), filesystemName);
			userSerivce.userUpdate(userDTO);
		}else {
			userDTO = new UserDTO(Integer.parseInt(no), id, newPwd, nickName, Integer.parseInt(gender), filesystemName);
			userSerivce.userUpdate(userDTO,pwd);
		}

		return new ModelAndView("user/user.jsp", true);

	}

	/**
	 * 게시글 조회
	 */
	public ModelAndView postSelectByUserNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pageNum");
		Pagenation page = new Pagenation();
		
		if(order!=null)
		page.setOrder(Integer.parseInt(order));
		if(pageNum!=null)
		page.setPageNo(Integer.parseInt(pageNum));

		Entry<List<RecipeWrapper>, Pagenation> postList = userSerivce.postSelectByUserNo(Integer.parseInt(no), page);
		request.setAttribute("postList", postList.getKey());
		request.setAttribute("page", postList.getValue());

		return new ModelAndView("user/user.jsp");
	}

	/**
	 * 댓글 검색
	 */
	public ModelAndView commentSelectByUserNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String no = request.getParameter("no");

		List<CommentDTO> commentList = userSerivce.commentSelectByUserNo(Integer.parseInt(no));
		request.setAttribute("commentList", commentList);

		return new ModelAndView("user/user.jsp");
	}

	/**
	 * 즐겨찾기 검색
	 */
	public ModelAndView bookmarkSelectByUserNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String no = request.getParameter("no");

		List<BookmarkDTO> bookmarkList = userSerivce.bookmarkSelectByUserNo(Integer.parseInt(no));
		request.setAttribute("bookmarkList", bookmarkList);

		return new ModelAndView("user/user.jsp");
	}

	/**
	 * 즐겨찾기 추가
	 */
	public ModelAndView bookmarkInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userNo = request.getParameter("userNo");
		String postNo = request.getParameter("postNo");

		userSerivce.bookmarkInsert(Integer.parseInt(userNo), Integer.parseInt(postNo));

		return new ModelAndView("adminTest.jsp");
	}

	/**
	 * 즐겨찾기 삭제
	 */
	public ModelAndView bookmarkDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userNo = request.getParameter("userNo");
		String postNo = request.getParameter("postNo");

		userSerivce.bookmarkDelete(Integer.parseInt(userNo), Integer.parseInt(postNo));

		return new ModelAndView("adminTest.jsp");
	}
	
	/**
	 * 회원 탈퇴 (상태 2번으로 변경)
	 * */
	public ModelAndView changeUserStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userNo = Integer.parseInt(request.getParameter("userNo"));	//변경할 유저의 활동상태와 유저 no 받기
		int userStatus = Integer.parseInt(request.getParameter("userStatus"));
		UserDTO userDTO = new UserDTO(userNo,userStatus);
		
		userSerivce.changeUserStatus(userDTO);
		
		return new ModelAndView("adminTest.jsp", true);
	}

	/**
	 * 게시글 삭제
	 * */
	public ModelAndView postDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userNo = Integer.parseInt(request.getParameter("userNo"));	//변경할 유저의 활동상태와 유저 no 받기
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		userSerivce.postDelete(userNo, postNo);
		
		return new ModelAndView("adminTest.jsp", true);
	}

	/**
	 * 게시글 삭제
	 * */
	public ModelAndView commentDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userNo = Integer.parseInt(request.getParameter("userNo"));	//변경할 유저의 활동상태와 유저 no 받기
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		userSerivce.commentDelete(userNo, commentNo);
		
		return new ModelAndView("adminTest.jsp", true);
	}
	
	/**
	 * 전체회원 정보 조회
	 * */
	public ModelAndView userSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pageNum");
		Pagenation page = new Pagenation();
		
		if(order!=null)
		page.setOrder(Integer.parseInt(order));
		if(pageNum!=null)
		page.setPageNo(Integer.parseInt(pageNum));
		
		Entry<List<UserDTO>, Pagenation> userList = userSerivce.userSelectAll(page);
		request.setAttribute("userList", userList.getKey());
		request.setAttribute("page", userList.getValue());
		
		return new ModelAndView("adminTest.jsp");
	}
	
	/**
	 * 회원 상세정보 조회
	 * */
	public ModelAndView userSelectByNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		UserDTO user = userSerivce.userSelectByNo(userNo);
		request.setAttribute("user", user);
		
		return new ModelAndView("user/user.jsp");
	}
	
	/**
	 * 유저 페이지 통합 by 김찬원
	 */
	
	public ModelAndView userInfoByNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pageNum");
		Pagenation page = new Pagenation();
		
		if(order!=null)
		page.setOrder(Integer.parseInt(order));
		if(pageNum!=null)
		page.setPageNo(Integer.parseInt(pageNum));

		UserDTO user = userSerivce.userSelectByNo(userNo);
		request.setAttribute("user", user);
		
		List<BookmarkDTO> bookmarkList = userSerivce.bookmarkSelectByUserNo(userNo);
		request.setAttribute("bookmarkList", bookmarkList);
		
		List<CommentDTO> commentList = userSerivce.commentSelectByUserNo(userNo);
		request.setAttribute("commentList", commentList);

		
		return new ModelAndView("user/user.jsp");
	
	}
}
