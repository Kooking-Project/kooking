package com.kooking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.dto.UserDTO;
import com.kooking.service.UserService;
import com.kooking.service.UserServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String path = request.getServletContext().getRealPath("/save");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";

		MultipartRequest m = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());

		String userNo = m.getParameter("userNo");
		String name = m.getParameter("name");
		String filesystemName = m.getFilesystemName("file");
		long fileSize = m.getFile("file").length();
		
		UserDTO user = new UserDTO(Integer.parseInt(userNo), ("${path}/save/"+m.getFilesystemName("file")) );
		
		try {
			userService.profileImageUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("name : " + name);
		System.out.println("filesystemName : " + filesystemName);
		System.out.println("fileSize : " + fileSize);

		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("filesystemName", filesystemName);
		map.put("fileSize", fileSize);
		map.put("path", path);

		JSONArray jsonArr = JSONArray.fromObject(map);

		PrintWriter out = response.getWriter();
		out.println(jsonArr);

	}

}
