<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logueo de Usuario</title>
</head>
<body bgcolor="#c5dec9">
<h2 align="center">Login Usuario</h2>
<div style="text-align: center;">
<img src="usuario.png"  width="100px" height="100px">
</div>
<form action="ControladorUsuario" method="post">
<table border="2" align="center">
<tr>
	<td><label for="username">Usuario: </label></td>
	<td><input type="text" id="username" name="username" required></td>
</tr>
<tr>	
	<td><label for="password">Contraseña: </label></td>
	<td><input type="password" id="password" name="password" required></td>
</tr>
<tr>	
	<td colspan="2" align="center">
	<input type="submit" value="Iniciar Sesión">
	</td>
</tr>
</table>
</form>
<% String mensajeError = (String) request.getAttribute("mensaje"); %>
<% if(mensajeError != null && !mensajeError.isEmpty()) { %>
<p align="center" style="color: red;"><%= mensajeError %></p>
<% } %>
</body>
</html>