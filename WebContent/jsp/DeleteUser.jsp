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
		<div class="container" style="width:455px; margin-top:20px; background-color:lightgrey;">
			<h2 style="text-align:center;">Enter Password To Delete</h2>
			<form action="DeleteUser" method="post">
			
				<div class="form-group">
					<label for="email">Email:</label>
					<input type="email" class="form-control" id="email" name="email" value="<%= (String)session.getAttribute("Email") %>" placeholder="Enter email" required="required" disabled="disabled">
				</div>
				
				<div class="form-group">
					<label for="Password">Password:</label>
					<input type="password" class="form-control" id="email" name="pwd" placeholder="Enter Password" required="required">
				</div>
				
				<div class="text-right">
					<button type="submit" class="btn btn-primary">Delete</button>
				</div>
					
			</form>
		</div>
	</body>
</html>