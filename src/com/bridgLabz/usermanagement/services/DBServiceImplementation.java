package com.bridgLabz.usermanagement.services;

import java.sql.*;

import com.bridgeLabz.usermanagement.dao.MySQLConnection;

public class DBServiceImplementation implements DBServiceInterface{
	
	static MySQLConnection connection;
	static ResultSet rs=null;
	static PreparedStatement psmt;

	// Its return the data of male and female
	public PreparedStatement fetchGender()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select * from login where gender=?");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
		
	}
	
	// It gives all the details of users
	public PreparedStatement fetchAllDetails()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select * from login");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}
	
	// it give last top 5 registered user
	public PreparedStatement fetchTop5Data()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select * from login order by date desc limit 5");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}
	
	// It gives users details in decreasing order by age
	public PreparedStatement fetchDecreasingOrderAge()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select * from login order by age desc");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}
	
	// It gives users details in increasing order by age
	public PreparedStatement fetchIncreasingOrderAge()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select * from login order by age");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}
	
	// It gives male users details
	public PreparedStatement graphMaleData()
	{
		connection = new MySQLConnection();
		try
		{
			psmt = connection.connectionProvider().prepareStatement("select age from login where gender=?");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return psmt;
	}
	
	
	// this method for delete the data from the database
	public PreparedStatement deleteData()
	{
		connection = new MySQLConnection();
		try 
		{
			psmt = connection.connectionProvider().prepareStatement("delete from login where email=? AND pswd=?");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return psmt;
	}
	
	// it gives the login and password of users for login check
	public PreparedStatement checkEmailPswd()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select email , pswd from login");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}
	
	// This method for update the users details
	public PreparedStatement updateData()
	{
		connection = new MySQLConnection();
		try
		{
			psmt = connection.connectionProvider().prepareStatement("Update login set email=?,mob=?,fname=?,lname=?,age=? where email=?");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return psmt;
	}
	
	// its return the details of 1 user as per email-id
	public PreparedStatement fetchUserDetail()
	{
		connection = new MySQLConnection();
		try {
			
			psmt = connection.connectionProvider().prepareStatement("select * from login where email=?");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}
}
