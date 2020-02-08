package com.bridgeLabz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgLabz.usermanagement.services.DBServiceInterface;
import com.bridgLabz.usermanagement.services.DBServiceImplementation;


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		DBServiceInterface dbService = new DBServiceImplementation();
		
		ResultSet rs = null;
		PreparedStatement psmt = dbService.deleteData();
		PreparedStatement psmt2 = dbService.checkEmailPswd(); 
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Email");
		System.out.println("Check before Delete "+email);
		try {
			rs = psmt2.executeQuery();
			
			while(rs.next())
			{
				if(email.equals(rs.getString(1)) && request.getParameter("pwd").equals(rs.getString(2)))
				{
					psmt.setString(1, email);
					System.out.println(email);
					
					psmt.setString(2, request.getParameter("pwd"));
					System.out.println(request.getParameter("pwd"));
					
					int delete = psmt.executeUpdate();
					System.out.println(delete+" data is deleted");
					response.sendRedirect("index.jsp");
				}
			}
				out.print("<HTML><h2>Invalid email & Password</h2></HTML>");
				RequestDispatcher rd = request.getRequestDispatcher("Header.jsp");
				rd.include(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
