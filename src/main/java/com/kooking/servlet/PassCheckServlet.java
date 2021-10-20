package com.kooking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassCheckServlet
 */
@WebServlet("/passCheck")
public class PassCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String pwd = request.getParameter("pwd");
		String pwdConfirm = request.getParameter("pwdConfirm");

		PrintWriter out = response.getWriter();

		if (pwd.equals( pwdConfirm )) {
			out.print("암호가 일치합니다.");
		} else {
			out.print("암호가 일치하지 않습니다.");
		}

	}

}
