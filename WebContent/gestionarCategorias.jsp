<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de categorias</title>
</head>
<body>
	<h1>Sus categorias</h1>
	
	<ul>
		<li>
			<a href="nuevaCategoria">Añadir categoria</a>
		</li>
	</ul>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${requestScope.categorias}" var="categorias">
			<tr>
				<td>
					${pageScope.categorias.name}
				</td>			
			
				<td>
					<a href="modificacionCategoria?idCategoria=${pageScope.categorias.id}">Modificar</a>
				</td>
			
				<td>
					<a href="eliminarCategoria?idCategoria=${pageScope.categorias.id}">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>