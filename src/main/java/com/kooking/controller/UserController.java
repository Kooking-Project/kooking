package com.kooking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// 여기까지 왔다는 이야기는 예외없이 정상이므로 session에 정보를 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", id);
		// session.setAttribute("loginName", );

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);

		return mv;
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
