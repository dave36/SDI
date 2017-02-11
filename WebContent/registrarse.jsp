<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
	
	<form action="realizar-registro" method="post" name="validarse_form_name">
	
		<center><h1>Introduzca sus datos</h1></center>
 		<hr><br>
 		
		<div>
			<label for="login">Login:</label>
			<input type="text" id="login" name="login"/>
		</div> 
		
		<div>
			<label for="email">Email:</label>
			<input type="text" id="email" name="email"/>
		</div> 
		
		<div>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password"/>
		</div> 
		
		<div>
			<label for="password-confirmacion">Password (Confirmación):</label>
			<input type="password" id="password-confirmacion" name="password-confirmacion"/>
		</div> 
	
		<input type="submit" value="Enviar"/>
   </form>
	
</body>
</html>