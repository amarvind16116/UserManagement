<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.bridgeLabz.dbConnection.DataBaseService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" %>

		<%
			Gson gsonObj = new Gson();
			Map<Object,Object> map = null;
			List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
			
			PreparedStatement psmt = DataBaseService.graphMaleData();
			psmt.setString(1, "male");
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				map = new HashMap<Object,Object>(); 
				map.put("male", rs.getString(1)); 
				map.put("y", Integer.parseInt(rs.getString(1))); 
				list.add(map);	
			}	 
			String dataPoints1 = gsonObj.toJson(list);
			 
			list = new ArrayList<Map<Object,Object>>();
			PreparedStatement psmt1 = DataBaseService.graphMaleData();
			psmt.setString(1, "female");
			ResultSet rs1 = psmt.executeQuery();
			while(rs1.next())
			{
				map = new HashMap<Object,Object>(); 
				map.put("female", rs1.getString(1)); 
				map.put("y", Integer.parseInt(rs1.getString(1))); 
				list.add(map);	
			}	
			 
			String dataPoints2 = gsonObj.toJson(list);
		%>
 
<!DOCTYPE HTML>
<html lang="en">
	<head>
		<title>Graph</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script type="text/javascript">
		
		window.onclick = function() { 
			 
			var chart = new CanvasJS.Chart("container", {  
				theme: "light2",
				title: {
					text: "Graph of Male and Female By Age"
				},
				subtitles: [{
					text: "Blue for Male and Green for Female"
				}],
				axisY: {
					includeZero: false
				},
				toolTip: {
					shared: true
				},
				legend:{
					cursor: "pointer",
					itemclick: toggleDataSeries
				},
				data: [{
					type: "spline",
					name: "Male",
					showInLegend: true,
					
					dataPoints: <% out.print(dataPoints1); %>
				},
				{
					type: "spline",
					name: "Female",
					showInLegend: true,
					
					dataPoints: <% out.print(dataPoints2); %>
				}]
			});
			 
			chart.render();
			 
			function toggleDataSeries(e){
				if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
					e.dataSeries.visible = false;
				}
				else{
					e.dataSeries.visible = true;
				}
				chart.render();
			}	 
		}
		</script>
	</head>
	
	<body>
		<div id="container" style="height: 400px; width: 50%; background-color:lightgrey;">
			<h3 style="text-align:center;">Click Me for Graph</h3>
		</div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	</body>
	
</html>