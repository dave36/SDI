<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmaci�n</title>
</head>
<body>
	<center><h1>Confirmar eliminaci�n</h1></center>
	<hr><br>
	<center><p>Si elimina la categor�a se borrar�n todas las tareas<br>
					asociadas a la misma.<br>�Desea continuar?</p>
	</center>
	<form action="cancelar-eliminacion" method="post" name="cancelar_form_name"> 		
 		<table align="center">
		<tr>
			<td><input type="submit" value="cancelar"/></td>
		</tr>
		</table>
	</form>
	<form action="eliminar-categoria" method="post" name="eliminarCategoria_form_name"> 		
 		<table align="center">
 		<tr>
 			<td><input type="hidden" value="${categoria.id}" name="idCat"/><td>
 		</tr>
		<tr>
			<td><input type="submit" value="Aceptar"/></td>
		</tr>
		</table>
	</form>
</body>
</html>