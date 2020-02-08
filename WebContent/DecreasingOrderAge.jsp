<%@page import="com.bridgLabz.usermanagement.services.DBServiceImplementation"%>
<%@page import="com.bridgLabz.usermanagement.services.DBServiceInterface"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>DashBoard</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<body>
	<%
		DBServiceInterface dbService = new DBServiceImplementation();
	
		ResultSet rs=null;
		PreparedStatement psmt= dbService.fetchDecreasingOrderAge();
		rs = psmt.executeQuery();	
	%>
	<div class="container table-responsive" style="background-color:lightgrey;">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Sr. No.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
				<th>Mobile No.</th>
				<th>Gender</th>
				<th>Age</th>
			</tr>
			<% while(rs.next()) {%>
			<%! int n=1; %>
		</thead>
		
		<tbody>
				<tr>
					<td><%= n %></td>
					<td><%= rs.getString(5) %></td>
					<td><%= rs.getString(6) %></td>
					<td><%= rs.getString(1) %></td>
					<td><%= rs.getString(4) %></td>
					<td><%= rs.getString(7) %></td>
					<td><%= rs.getString(9) %></td>
				</tr>
			</tbody>
		<%	n++;
		} %>
		<%n=1; %>
	</table>
		
	</div>
</body>
</html>