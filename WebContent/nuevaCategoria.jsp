<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir categoria</title>
</head>
<body>	
	<form action="añadir-categoria" method="post" name="añadirCategoria_form_name">
		<center><h1>Introduzca datos</h1></center>
 		<hr><br>
 		
 		<table align="center">
		<tr>
			<td align="right">Nombre:</td>
			<td><input type="text" id="name" name="name"/></td>
		</tr> 
		
		<tr>
			<td><input type="submit" value="Enviar"/></td>
		</tr>
		</table>
	</form>
</body>
</html>