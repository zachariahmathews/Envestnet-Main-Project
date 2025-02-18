<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoIt! - Signup</title>
<link href="css/style.css" rel="stylesheet" />
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body class="login-body" style="background-image: url('img/bg.jpg');">
	<div id="login-container">
		<form class="form-signin" action="Controller">
			<h2 class="form-signin-heading">Signup</h2>
			<div class="login-wrap">
				<table>
					<tr>
						<td style="margin-right: 5px;">User ID &nbsp;</td>
						<td><input type="text" class="form-control" name="userid"
							autofocus></td>
					</tr>
					<tr>
						<td style="margin-right: 5px;">Password &nbsp;</td>
						<td><input type="password" class="form-control"
							name="password"></td>
					</tr>
					<tr>
						<td><input type="hidden" name="handler" value="signup-page">
						</td>
						<td></td>
					</tr>
				</table>
				<input type="submit" value="Signup"
					class="btn btn-lg btn-login btn-block">
				<%
					if (request.getAttribute("signup") == null) {
					} else if (!(Boolean) request.getAttribute("signup")) {
				%>
				<div class="alert alert-danger invalid " role="alert">Signup failed. UserID already exists.</div>
				<%
					}
				%>
			</div>
		</form>
	</div>
</body>
</html>