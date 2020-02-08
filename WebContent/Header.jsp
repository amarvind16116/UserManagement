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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
</head>

<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
				
				<%
					System.out.println("Email : "+session.getAttribute("Email"));
					if(session.getAttribute("Email") == null)
					{
						response.sendRedirect("index.jsp");
					}
				%>
				<form class="text-left" action="LogOut" method="post">
				    <button class="btn btn-success" type="submit">Logout</button>
			 	</form>
			 	
			 	<script>
				 	function loadDoc(url, cFunction) {
				 		  var xhttp;
				 		  xhttp=new XMLHttpRequest();
				 		  xhttp.onreadystatechange = function() {
				 		    if (this.readyState == 4 && this.status == 200) {
				 		      cFunction(this);
				 		    }
				 		  };
				 		  xhttp.open("GET", url, true);
				 		  xhttp.send();
				 		}
				 		function myFunction(xhttp) {
				 		  document.getElementById("div").innerHTML =
				 		  xhttp.responseText;
				 		}
				 		
				</script>
		
		<button class="navbar-toggler" type= "button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="nav navbar-nav navbar-right">
			
				<li class="nav-item">
					<button type="button" class="btn btn-dark" id="but" onclick="loadDoc('Graph.jsp',myFunction)" >DashBoard Graph</button>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-dark" onclick="loadDoc('History.jsp',myFunction)">History</button>
				</li>
		
				<li class="nav-item dropdown">
					<button type="button" class="btn btn-dark dropdown-toggle" id="navbardrop" data-toggle="dropdown">Gender</button>
					<div class="dropdown-menu">
						<button type="button" class="btn btn-dark" onclick="loadDoc('MaleData.jsp',myFunction)">Male</button>
					<button type="button" class="btn btn-dark" onclick="loadDoc('FemaleData.jsp',myFunction)">Female</button>
					</div>
				</li>
				<li class="nav-item dropdown">
					<button type="button" class="btn btn-dark dropdown-toggle" id="navbardrop" data-toggle="dropdown">Age</button>
					<div class="dropdown-menu">
						<button type="button" class="btn btn-dark" onclick="loadDoc('IncreasingOrderAge.jsp',myFunction)">Increasing Order</button>
						<button type="button" class="btn btn-dark" onclick="loadDoc('DecreasingOrderAge.jsp',myFunction)">Decreasing Order</button>
						
					</div>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-dark" onclick="loadDoc('LatestRegistration.jsp',myFunction)">Last 5 Registered</button>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-dark" onclick="loadDoc('UpdateData.jsp',myFunction)">Update</button>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-dark" onclick="loadDoc('DeleteUser.jsp',myFunction)">Delete</button>
				</li>
				
			</ul>
		</div>
	</nav>	
	
	<div class="container" id="div">
		<%@include file="Graph.jsp" %>
	</div>
	
</body>

</html>
