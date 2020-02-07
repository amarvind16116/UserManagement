package com.bridgeLabz.usermanagement.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class RegistrationBean {
	
	private static String email;
	private static String pwd;
	private static String repwd;
	private static String mob;
	private static String fname;
	private static String lname;
	private static String gender;
	private static String date;
	private static String age;
	
	
	public RegistrationBean(HttpServletRequest request) {
		
		email = request.getParameter("email");
		pwd = request.getParameter("pwd");
		repwd = request.getParameter("repwd");
		mob = request.getParameter("mob");
		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		gender = request.getParameter("gender");
		age = request.getParameter("age");
	}
	
	
	public static String getEmail() {
		return email;
	}
	public static String getPwd() {
		return pwd;
	}
	public static String getRepwd() {
		return repwd;
	}
	public static String getMob() {
		return mob;
	}
	public static String getFname() {
		return fname;
	}
	public static String getLname() {
		return lname;
	}
	public static String getGender() {
		return gender;
	}
	public static String getDate() {
		java.util.Date dateTime = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
		date = df.format(dateTime);
		return date;
	}
	public static String getAge() {
		return age;
	}
	
}
