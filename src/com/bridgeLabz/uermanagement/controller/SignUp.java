package com.bridgeLabz.uermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeLabz.usermanagement.dao.MySQLConnection;
import com.bridgeLabz.usermanagement.model.RegistrationBean;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

	static Statement stmt = null;
	PreparedStatement psmt = null;
	static ResultSet rs = null;
	static boolean check = false;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MySQLConnection mySQl = new MySQLConnection();
		RegistrationBean rb = new RegistrationBean(request);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd ;
		
		try {
			psmt = mySQl.connectionProvider().prepareStatement("insert into login values(?,?,?,?,?,?,?,?,?)");
			
			stmt = mySQl.connectionProvider().createStatement();
			rs = stmt.executeQuery("select * from login");
			System.out.println(rb.getDate() );
			psmt.setString(1, rb.getEmail());
			psmt.setString(2, rb.getPwd());
			psmt.setString(3, rb.getRepwd());
			psmt.setString(4, rb.getMob());
			psmt.setString(5, rb.getFname());
			psmt.setString(6, rb.getLname());
			psmt.setString(7, rb.getGender());
			psmt.setString(8, rb.getDate());
			psmt.setString(9, rb.getAge());
			
			while(rs.next())
			{
				if((rs.getString(1).equals(rb.getEmail())) || rs.getString(4).equals(rb.getMob()))
				{
					check = true;
					break;
				}
				else
				{
					check = false;
				}
			}
			
			if(rb.getPwd().equals(rb.getRepwd()))
			{
				if(!Pattern.matches("["+rb.getEmail()+"]+", "@") || !Pattern.matches("["+rb.getEmail()+"]+", "."))
				{
					out.println("<html><h3 style='color:white'>Please Enter valid email Example : <p style='color:RED'>@gmail.com,@bridgelabz.com etc.</p></h3></html>");
					rd = request.getRequestDispatcher("signup.jsp");
					rd.include(request, response);
				}
				
				if(!Pattern.matches("[6789][0-9]{9}", rb.getMob()) || !Pattern.matches("(0/91)?[6-9][0-9]{9}", rb.getMob()))
				{
					out.println("<html><h3 style='color:white'>Please Enter valid Mobile Number</h3></html>");
					rd = request.getRequestDispatcher("signup.jsp");
					rd.include(request, response);
				}
				
				else if(rb.getEmail() == "" || rb.getPwd() == "" || rb.getMob() == "" || rb.getFname() == "" || rb.getGender() == "")
				{
					rd = request.getRequestDispatcher("signup.jsp");
					rd.include(request, response);
				}
				else if(check == true)
				{
					out.print("<html><div align='center'><h3 style='color:white'>email & Mobile Number is already exist</h3></div></html>");
					rd = request.getRequestDispatcher("signup.jsp");
					rd.include(request, response);
				}
				else
				{	if(check==false)
					{
						int execute = psmt.executeUpdate();
							
						System.out.println(execute + " data is inserted in DataBase");
						rd = request.getRequestDispatcher("index.jsp");
						rd.include(request, response);
					}	
				}
			}
			else
			{
				out.print("<html><h3  style='color:white'>both pswd should be same</h3></html>");
				rd = request.getRequestDispatcher("signup.jsp");
				rd.include(request, response);
			}
			
			mySQl.connectionProvider().close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}
}
