package com.bridgeLabz.usermanagement.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class RegistrationBean {
	
	private String email;
	private String pwd;
	private String repwd;
	private String mob;
	private String fname;
	private String lname;
	private String gender;
	private String date;
	private String age;
	
	
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
	
	
	public String getEmail() {
		return email;
	}
	public String getPwd() {
		return pwd;
	}
	public String getRepwd() {
		return repwd;
	}
	public String getMob() {
		return mob;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getGender() {
		return gender;
	}
	public String getDate() {
		java.util.Date dateTime = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
		date = df.format(dateTime);
		return date;
	}
	public String getAge() {
		return age;
	}
	
}
