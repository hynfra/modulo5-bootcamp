<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	String num = request.getParameter("num");
String numeros = "";

%>
<h2>evento cuenta regresiva</h2>
					<ul>
					<%
					for(int i = Integer.parseInt(num); i >= 1 ; i--) {
					%>
					<li> <%= i %> </li>
					
					<%} %>
					
				</ul>
				<h3>Feliz año!</h3>

</body>
</html>