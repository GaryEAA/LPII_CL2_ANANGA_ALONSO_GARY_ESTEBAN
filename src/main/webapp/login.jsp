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
<form action="ControladorUsuario" method="post">
	<label for="username">Usuario: </label>
	<input type="text" id="username" name="username" required><br><br>
	
	<label for="password">Contraseña: </label>
	<input type="password" id="password" name="password" required><br><br>
	
	<input type="submit" value="Iniciar Sesión">
</form>
<% String mensajeError = (String) request.getAttribute("mensaje"); %>
<% if(mensajeError != null && !mensajeError.isEmpty()) { %>
<p style="color: red;"><%= mensajeError %></p>
<% } %>
</body>
</html>