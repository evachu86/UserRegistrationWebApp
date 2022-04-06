<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="BIG5">
		<title>Home</title>
	</head>
	<body>
		<h1>${result}</h1>
		<p>${errMsg}</p>
		<form action="RegsiterServlet" method="POST">
			Name: <input type="text" name="Name" /> <br/>
			Email: <input type="text" name="Email" /> <br/>
			UserID: <input type="text" name="UserID" /> <br/>		
			Password: <input type="password" name="Password" /> <br/>
			
			<input type="submit" value="Submit" />
		</form>
	</body>
</html>