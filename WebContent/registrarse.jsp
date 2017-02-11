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
 		
 		<table align="center">
		<tr>
			<td align="right">Login:</td>
			<td><input type="text" id="login" name="login"/></td>
		</tr> 
		
		<tr>
			<td align="right">Email:</td>
			<td><input type="text" id="email" name="email"/></td>
		</tr>
		
		<tr>
			<td align="right">Password:</td>
			<td><input type="password" id="password" name="password"/></td>
		</tr> 
		
		<tr>
			<td align="right">Password (Confirmación):</td>
			<td><input type="password" id="password-confirmacion" name="password-confirmacion"/></td>
		</tr> 
		
		<tr>
			<td><input type="submit" value="Enviar"/></td>
		</tr>
		</table>
   </form>
	
</body>
</html>