<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios registrados</title>
</head>
<body>
	<h1>Listado de Usuarios</h1>
	
	<table>
		<tr>
			<th>Login</th>
			<th>Email</th>
			<th>IsAdmin</th>
			<th>Status</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${requestScope.listaUsuarios}" var="user">
			<tr>
				<td>${pageScope.user.login}</td>
			
				<td>${pageScope.user.email}</td>
				
				<td>${pageScope.user.isAdmin}</td>
				
				<td>${pageScope.user.status}</td>
				
				<td><a href="modificarStatus?idUsuario=${pageScope.user.id}">Modificar status</a></td>
				<td><a href="eliminarUsuario?idUsuario=${pageScope.user.id}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>