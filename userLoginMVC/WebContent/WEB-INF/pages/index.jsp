<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller">
		User ID: <input type="text" name="id"><br>
		Name: <input type="text" name="name"><br>
		<input type="hidden" name="handler" value="userRegistration">
		<input type="submit">
		<%
		if(request.getSession().getAttribute("updated")==null){}
		else if((Boolean)request.getSession().getAttribute("updated")==false){
		%>
		<span style="color:red;">User ID already Exists</span>
		<%} 
		else{%>
		<span style="color:green;">User added.</span>
		<%} %>
	</form>
</body>
</html>