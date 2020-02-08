package com.bridgeLabz.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConnection {
	
	static String uname = "root";
	static String upass = "16116";
	static String url = "jdbc:mysql:///registration?useSSL=false";

	static Connection con = null;

	public Connection connectionProvider()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,upass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
}
