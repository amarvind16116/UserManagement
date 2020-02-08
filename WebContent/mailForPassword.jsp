<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Change Passowrd</title>
		<link rel="stylesheet" href="css/loginstyle.css">
	</head>
	<body>
		<div class="login-box">
			<form action="ServletMailer" method="post">
				<h1>Send Email</h1>
					<div class="textbox">
					<i class="fa fa-user" aria-hidden="true"></i>
						<input type="text" placeholder="Username" name="email" required="required">
					</div>
					<input class="btn" type="submit" value="Send Email">
			</form>		
		</div>	
	</body>
</html>