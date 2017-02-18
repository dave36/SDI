<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Tarea</title>
</head>
<body>
	
	<form action="añadirTarea" method="post" name="añadirTarea_form_name">
		<input type="hidden" value="${usuario.id}" name="id">
	
		<center><h1>Introduzca los datos de la tarea</h1></center>
 		<hr><br>
 		
 		<table align="center">
		<tr>
			<td align="right">Title:</td>
			<td><input type="text" id="title" name="title"/></td>
		</tr> 
		
		<tr>
			<td align="right">Comments:</td>
			<td><input type="text" id="comments" name="comments"/></td>
		</tr>
		
		<tr>
			<td align="right">Planned:</td>
			<td><input type="text" id="planned" name="planned" value="DD/MM/YYYY"/></td>
		</tr> 
		
		<tr>
			<td><input type="submit" value="Enviar"/></td>
		</tr>
		</table>
   </form>
	
</body>
</html>