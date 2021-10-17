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
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		UserDTO userDTO = userSerivce.loginCheck(id, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", id);
		// session.setAttribute("loginName", );
		
		return new ModelAndView("index.jsp", true);
		
		
	}
	
	/**
	 * 로그아웃
	 * */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * 회원가입
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		String enrollDate = request.getParameter("enrollDate");
		String profileImg = request.getParameter("profileImg");
		String status = request.getParameter("status");
		
		UserDTO userDTO = 
				  new UserDTO(Integer.parseInt(no), id, pwd, nickName, Integer.parseInt(gender),
						  enrollDate,profileImg,Integer.parseInt(status));
		
		userSerivce.insert(userDTO);
		
		return new ModelAndView("index.jsp", true);
	}

	/* 프로필 설정 (작업중 - 원재)
	public ModelAndView profileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("profileUpload 시작");
		response.setContentType("text/html;charset=UTF-8");

		request.setCharacterEncoding("UTF-8");
		String path = request.getServletContext().getRealPath("/save");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";

		MultipartRequest m = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());

		// servier -> dao -> insert 완료~~
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String filesystemName = m.getFilesystemName("file");
		String originalName = m.getOriginalFileName("file");
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
	*/

}
