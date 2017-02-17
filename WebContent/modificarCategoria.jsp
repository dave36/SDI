<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Categoria</title>
</head>
<body>
	<form action="modificar-Categoria" method="post" name="modificar_form_categoria">
		<input type="hidden" value="${categoria.id}" name="id">
		<center><h1>Introduzca un nuevo nombre</h1></center>
 		<hr><br>
		
		<table align="center">
		<tr>
			<td align="right">Nombre:</td>
			<td><input type="text" id="name" name="name" value="${categoria.name}"/></td>
		</tr> 
		
		<tr>
			<td><input type="submit" value="Enviar"/></td>
		</tr>
		</table>
	</form>
</body>
</html>