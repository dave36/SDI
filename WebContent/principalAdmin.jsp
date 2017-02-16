<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>TaskManager - Página principal del Administrador</title>
</head>
<body>

	<ul>
		<li>
			<a href="listarUsuarios">Usuarios</a>
		</li>
	</ul>
	
<i>Iniciaste sesión el <fmt:formatDate pattern="dd-MM-yyyy' a las 'HH:mm" 
								value="${sessionScope.fechaInicioSesion}"/>
								(usuario número ${contador})</i>
	<br/><br/>
	<jsp:useBean id="user" class="uo.sdi.dto.User" scope="session" />
	<table>
		<tr>
			<td>Id:</td><td id="id"><jsp:getProperty property="id" name="user" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td id="email"><form action="modificarDatos" method="POST">
					<input type="text" name="email" size="15"
						value="<jsp:getProperty property="email" name="user"/>"> 
					<input type="submit" value="Modificar">
				</form>
			</td>
		</tr>
		<tr>
			<td>Es administrador:</td><td id="isAdmin"><jsp:getProperty property="isAdmin" name="user" /></td>
		</tr>
		<tr>
			<td>Login:</td><td id="login"><jsp:getProperty property="login" name="user" /></td>
		</tr>
		<tr>
			<td>Estado:</td><td id="status"><jsp:getProperty property="status" name="user" /></td>
		</tr>
		
		<tr>
			<td>Contraseña actual:</td>
			<td id="password"><form action="modificarDatos" method="POST">
				<input type="password" name="oldPass" size="15">
				</form>
			</td>
			
			<td>Contraseña nueva:</td>
			<td id="password"><form action="modificarDatos" method="POST">
				<input type="password" name="newPass" size="15">
				</form>
			</td>
			
			<td>Contraseña nueva:</td>
			<td id="password"><form action="modificarDatos" method="POST">
				<input type="password" name="newPass2" size="15">
				
				<input type="submit" value="Modificar">
				</form>
			</td>
		</tr>
	</table>
	<br/>	
	<a id="cerrarSesion_link_id" href="cerrarSesion">Cerrar sesión</a>
	
	<%@ include file="pieDePagina.jsp" %>
</body>
</html>