package com.kooking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.dao.UserDAO;
import com.kooking.dao.UserDAOImpl;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("id");
		UserDAO dao = new UserDAOImpl();

		PrintWriter out = response.getWriter();

		try {
			if (dao.idCheck(id)) {
				out.print("중복 되는 아이디입니다.");
			}		
			else {
				out.print("사용 가능 합니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
