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
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");

		UserDTO userDTO = new UserDTO(Integer.parseInt(no), pwd, nickName, Integer.parseInt(gender));

		userSerivce.userUpdate(userDTO);

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
	 * 프로필 설정(프로필 사진 업로드)
	 */
	public ModelAndView profileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("profileUpload 시작");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String path = request.getServletContext().getRealPath("/save"); //a.jpg , a1.jpg , a2.jpg
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";

		MultipartRequest m = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());

		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String filesystemName = m.getFilesystemName("file");//실제 a1.jpg
		String originalName = m.getOriginalFileName("file"); //a.jpg
		long fileSize = m.getFile("file").length();

		
		System.out.println("name : " + name);
		System.out.println("subject : " + subject);
		System.out.println("filesystemName : " + filesystemName);
		System.out.println("originalName : " + originalName);
		System.out.println("fileSize : " + fileSize);

		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("subject", subject);
		map.put("filesystemName", filesystemName);
		map.put("originalName", originalName);
		map.put("fileSize", fileSize);
		map.put("path", path);

		// map을 json의 형태로 변환해서 보낸다.
		JSONArray jsonArr = JSONArray.fromObject(map);

		PrintWriter out = response.getWriter();
		out.println(jsonArr);

		return new ModelAndView("adminTest.jsp", true);
	}
}
