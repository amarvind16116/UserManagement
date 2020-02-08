package com.bridgeLabz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeLabz.usermanagement.dao.MySQLConnection;

@WebServlet("/FirstServlet")
public class LogInServlet extends HttpServlet
{
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		MySQLConnection mySQL = new MySQLConnection();
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		
		String getEmail = request.getParameter("email");
		
		String getPswd = request.getParameter("pwd");
		
		try {
				
			pstmt = mySQL.connectionProvider().prepareStatement("select email,pswd from login where email=?"); 
			pstmt.setString(1, getEmail);
			rs = pstmt.executeQuery();
			boolean check = false;
			
			while(rs.next())
			{
				System.out.println("Inside the resultSet");
				if(rs.getString(1).equals(getEmail) && rs.getString(2).equals(getPswd))
				{
					check = true;
					break;
				}
				else
				{
					check = false;
				}
			}
			if(check == true)
			{
				out.print("Welcome"+getEmail);
				HttpSession session = request.getSession();
				session.setAttribute("Email", getEmail);
				response.sendRedirect("Header.jsp");
			}
			else
			{
				out.print("<html><h1 style='color:white'>Enter valid email & password... </h1></html>");
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			
			mySQL.connectionProvider().close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
