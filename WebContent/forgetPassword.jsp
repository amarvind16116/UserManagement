<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Change Passowrd</title>
		<link rel="stylesheet" href="css/loginstyle.css">
	</head>
		<%
			session.setMaxInactiveInterval(600);
		%>
	<body>
		<div class="login-box">
			<form action="ForgotPassowrd" method="post">
				<h1>Change Passowrd</h1>
					<div class="textbox">
					<i class="fa fa-user" aria-hidden="true"></i>
						<input type="text" placeholder="Username" name="email" required="required" value=<%= session.getAttribute("email") %> disabled="disabled">
					</div>
					<div class="textbox">
					<i class="fa fa-lock" aria-hidden="true"></i>
				<input type="password" placeholder="Password" name="pwd" required="required">
					</div>
					
					<div class="textbox">
						<i class="fa fa-lock" aria-hidden="true"></i>
						<input type="password" placeholder="Password" name="repwd" required="required">
					</div>
					<input class="btn" type="submit" value="Change Password">
			</form>		
		</div>	
	</body>
</html>