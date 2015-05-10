<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perfil de usuario</title>
</head>
<body>

	<table>
		<tr>
			<th>Usuario</th>
			<th>Genero</th>
			<th>Pais</th>
			<th>Descripcion</th>
			<th>raza</th>
		</tr>
		<tr>
			<td>${datosUsuario.getUsuario()}</td>
			<td>${datosUsuario.getGenero()}</td>
			<td>${datosUsuario.getPais()}</td>
			<td>${datosUsuario.getDescripcion()}</td>
			<td>${datosUsuario.getFaccion()}</td>
		</tr>
	</table>

</body>
</html>