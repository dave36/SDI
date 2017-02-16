<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today Tasks</title>
</head>
<body>
	<h1>Listado de tareas</h1>
	
	<table>
		<tr>
			<th>T�tulo</th>
			<th>Creada</th>
			<th>Planificada</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${requestScope.tasks}" var="task">
			<tr>
				<td>${pageScope.task.title}</td>
			
				<td>
					<fmt:formatDate value="${pageScope.task.created}" type="date" dateStyle="short"/>
				</td>
				
				<td>
					<fmt:formatDate value="${pageScope.task.planned}" type="date" dateStyle="short"/>
				</td>
				
				<td>
					<a href="finalizarTarea?idTarea=${pageScope.task.id}">Finalizar</a>
				</td>
				
				<td>
					<a href="modificarTarea?idTarea=${pageScope.task.id}">Modificar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>