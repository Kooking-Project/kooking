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

		return new ModelAndView("index2.jsp", true);

	}

	/**
	 * 로그아웃
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();

		return new ModelAndView("index2.jsp", true);
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

		return new ModelAndView("index2.jsp", true);
	}

	/**
	 * 유저 정보 변경
	 */
	public ModelAndView userUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		String filesystemName = request.getParameter("file");

		UserDTO userDTO = null;
		if(newPwd==null) {
			userDTO = new UserDTO(Integer.parseInt(no), pwd, nickName, Integer.parseInt(gender), filesystemName);
			userSerivce.userUpdate(userDTO);
		}else {
			userDTO = new UserDTO(Integer.parseInt(no), newPwd, nickName, Integer.parseInt(gender), filesystemName);
			userSerivce.userUpdate(userDTO,pwd);
		}

		return new ModelAndView("user.jsp", true);
	}

	/**
	 * 게시글 조회
	 */
	public ModelAndView postSelectByUserNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");

		Entry<PostDTO, RecipeDTO> postList = userSerivce.postSelectByUserNo(Integer.parseInt(no));
		request.setAttribute("postList", postList);

		return new ModelAndView("adminTest.jsp");
	}

	/**
	 * 댓글 검색
	 */
	public ModelAndView commentSelectByUserNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String no = request.getParameter("no");

		List<CommentDTO> commentList = userSerivce.commentSelectByUserNo(Integer.parseInt(no));
		request.setAttribute("commentList", commentList);

		return new ModelAndView("adminTest.jsp");
	}

	/**
	 * 즐겨찾기 검색
	 */
	public ModelAndView bookmarkSelectByUserNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String no = request.getParameter("no");

		List<BookmarkDTO> bookmarkList = userSerivce.bookmarkSelectByUserNo(Integer.parseInt(no));
		request.setAttribute("bookmarkList", bookmarkList);

		return new ModelAndView("adminTest.jsp");
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
		List<UserDTO> userList = userSerivce.userSelectAll();
		request.setAttribute("userList", userList);
		
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
	
}
