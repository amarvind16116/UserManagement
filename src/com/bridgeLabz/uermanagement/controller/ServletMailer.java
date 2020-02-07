package com.bridgeLabz.uermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeLabz.usermanagement.dao.MySQLConnection;

/**
 * Servlet implementation class ServletMailer
 */
@WebServlet("/ServletMailer")
public class ServletMailer extends HttpServlet {
	
		static Statement stmt = null;
		static ResultSet rs = null;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			final String email = "forne12041995@gmail.com";
			final String password = "asd@123#";
			
			PrintWriter out = response.getWriter();
			RequestDispatcher rd;
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			Session session = Session.getInstance(props, new Authenticator()
			{
				protected javax.mail.PasswordAuthentication getPasswordAuthentication()
				{
					return new javax.mail.PasswordAuthentication(email, password);
				}
			});
			try
			{
				MySQLConnection mySQL = new MySQLConnection();
				stmt = mySQL.connectionProvider().createStatement(); 
				
				rs = stmt.executeQuery("select email from login");
				boolean check = false;
				
				while(rs.next())
				{
					System.out.println("Inside the resultSet");
					if(rs.getString(1).equals(request.getParameter("email")))
					{
						check = true;
						break;
					}
					else
					{
						check = false;
					}
				}
				if(check==true)
				{
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("forne12041995@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getParameter("email")));
					message.setSubject("Message Sent");
					message.setText("Click on the below link to change the Password \n\nhttp://localhost:8080/LogInLogOut/forgetPassword.jsp");
					Transport.send(message);
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("email", request.getParameter("email"));
					response.sendRedirect("index.jsp");
					System.out.println("Done");
				}
				else
				{
					out.print("<html><center><h3 style='color:white'>Enter valid email .... </h3></center></html>");
					rd = request.getRequestDispatcher("mailForPassword.jsp");
					rd.include(request, response);
				}
			}
			catch(Exception e)
			{
				throw new RuntimeException(e);
			}
	}

}
