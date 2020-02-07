<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Registration-Pannel</title>
<link rel="stylesheet" href="css/loginstyle.css">
</head>

<body>
	<div class="login-box">
		<form action="SignUp" method="post">
			<h1>User Details</h1>
			<div class="textbox">
				<i class="fa fa-user" aria-hidden="true"></i> <input type="text"
					placeholder="First Name" name="fname" required="required">
			</div>

			<div class="textbox">
				<i class="fa fa-user" aria-hidden="true"></i> <input type="text"
					placeholder="Last Name" name="lname" required="required">
			</div>

			<div class="textbox">
				<i class="fa fa-user" aria-hidden="true"></i> <input type="email"
					placeholder="Username" name="email" required="required">
			</div>

			<div class="textbox">
				<i class="fa fa-lock" aria-hidden="true"></i> <input type="password"
					placeholder="Password" name="pwd" required="required">
			</div>
			<div class="textbox">
				<i class="fa fa-lock" aria-hidden="true"></i> <input type="password"
					placeholder="Password" name="repwd" required="required">
			</div>
			<div class="textbox">
				<i class="fa fa-book" aria-hidden="true"></i> <input type="text"
					placeholder="Mobile No" name="mob" required="required">
			</div>
			<div class="textbox">
				<i class="fa fa-book" aria-hidden="true"></i> <input type="text"
					placeholder="Enter Age" name="age" required="required">
			</div>
			<p style="color: white">
				Male <input type="radio" name="gender" value="male"
					required="required"> FeMale <input type="radio"
					name="gender" value="female" required="required">
			</p>
			<input class="btn" type="submit" value="Sign Up">
		</form>
		<form action="index.jsp">
			<input class="btn" type="submit" value="Login">
		</form>
	</div>
</body>
</html>