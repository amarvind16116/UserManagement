<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Delete Account</title>
<link rel="stylesheet" href="css/loginstyle.css">
</head>
<body>
	<div class="login-box">
			<form action="DeleteUser" method="post">
				<h1>Delete Account</h1>
					<div class="textbox">
					<i class="fa fa-user" aria-hidden="true"></i>
						<input type="email" placeholder="Username" name="email" required="required">
					</div>
					<div class="textbox">
					<i class="fa fa-lock" aria-hidden="true"></i>
				<input type="password" placeholder="Password" name="pwd" required="required">
					</div>

					<input class="btn" type="submit" value="Delete Account">
			</form>		
		</div>	
</body>
</html>