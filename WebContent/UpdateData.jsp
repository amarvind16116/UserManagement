<%@page import="com.bridgLabz.usermanagement.services.DBServiceImplementation"%>
<%@page import="com.bridgLabz.usermanagement.services.DBServiceInterface"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Update User Information</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	</head>
	
	<body>
		<%
			DBServiceInterface dbService = new DBServiceImplementation();
			PreparedStatement psmt = dbService.fetchUserDetail();
			psmt.setString(1, (String)session.getAttribute("Email"));
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
		%>
		<div class="container" style="width:455px; margin-top:20px; background-color:lightgrey;">
			<h2 style="text-align:center;">User Details</h2>
			<form action="UpdtaeUser" method="post">
			
				<div class="form-group">
					<label for="fname">First Name:</label>
					<input type="text" class="form-control" id="fname" name="fname" value="<%= rs.getString(5) %>" placeholder="Enter First Name" required="required">
				</div>
				
				<div class="form-group">
					<label for="lname">Last Name:</label>
					<input type="text" class="form-control" id="lname" name="lname" value="<%= rs.getString(6) %>" placeholder="Enter Last Name" required="required">
				</div>
				
				<div class="form-group">
					<label for="email">Email:</label>
					<input type="email" class="form-control" id="email" name="email" value="<%= rs.getString(1) %>" placeholder="Enter email" required="required">
				</div>
				
				<div class="form-group">
					<label for="mobile">Mobile:</label>
					<input type="text" class="form-control" id="mob" name="mob" value="<%= rs.getString(4) %>" placeholder="Enter Mobile" required="required">
				</div>
				
				<div class="form-group">
					<label for="age">Age:</label>
					<input type="text" class="form-control" id="age" name="age" value="<%= rs.getString(9) %>" placeholder="Enter Age" required="required">
				</div>
				
				<% } %>
				<div class="text-right">
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
					
			</form>
		</div>
	</body>
</html>