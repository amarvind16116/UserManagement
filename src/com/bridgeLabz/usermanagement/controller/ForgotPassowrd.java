package com.bridgeLabz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeLabz.usermanagement.dao.MySQLConnection;

/**
 * Servlet implementation class ForgotPassowrd
 */
@WebServlet("/ForgotPassowrd")
public class ForgotPassowrd extends HttpServlet {

	PreparedStatement psmt = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MySQLConnection mySQL = new MySQLConnection();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RequestDispatcher rd;

		try {
			psmt = mySQL.connectionProvider().prepareStatement("update login set pswd=? , repwd=? where email=?");
			psmt.setString(1, request.getParameter("pwd"));
			psmt.setString(2, request.getParameter("repwd"));
			psmt.setString(3, (String) session.getAttribute("email"));

			if (request.getParameter("pwd").equals(request.getParameter("repwd"))) {
				psmt.executeUpdate();
				out.println("<html><div align='center'><h3 style='color:white'>Password is changed</h3></div></html>");
				session.invalidate();
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
