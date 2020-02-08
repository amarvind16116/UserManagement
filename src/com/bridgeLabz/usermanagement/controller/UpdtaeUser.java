package com.bridgeLabz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgLabz.usermanagement.services.DBServiceInterface;
import com.bridgLabz.usermanagement.services.DBServiceImplementation;

@WebServlet("/UpdtaeUser")
public class UpdtaeUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		DBServiceInterface dbService = new DBServiceImplementation();

		RequestDispatcher rd;

		PreparedStatement psmt = dbService.updateData();

		HttpSession session = request.getSession();
		System.out.println("Check Email Session : " + (String) session.getAttribute("Email"));

		try {
			psmt.setString(1, request.getParameter("email"));
			psmt.setString(2, request.getParameter("mob"));
			psmt.setString(3, request.getParameter("fname"));
			psmt.setString(4, request.getParameter("lname"));
			psmt.setString(5, request.getParameter("age"));
			psmt.setString(6, (String) session.getAttribute("Email"));

			if (!Pattern.matches("[" + request.getParameter("email") + "]+", "@")
					|| !Pattern.matches("[" + request.getParameter("email") + "]+", ".")) {
				out.println(
						"<html><h3 style='color:white'>Please Enter valid email Example : <p style='color:RED'>@gmail.com,@bridgelabz.com etc.</p></h3></html>");
				rd = request.getRequestDispatcher("Header.jsp");
				rd.include(request, response);
			}

			else if (!Pattern.matches("[6789][0-9]{9}", request.getParameter("mob"))
					|| !Pattern.matches("(0/91)?[6-9][0-9]{9}", request.getParameter("mob"))) {
				out.println("<html><h3 style='color:white'>Please Enter valid Mobile Number</h3></html>");
				rd = request.getRequestDispatcher("Header.jsp");
				rd.include(request, response);
			} else {
				int data = psmt.executeUpdate();
				session.setAttribute("Email", request.getParameter("email"));
				System.out.println(data + " Data is successfully updated");
				response.sendRedirect("Header.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
