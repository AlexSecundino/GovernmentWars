<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/cast ban all</title>
</head>
<body>

	<c:if test="${bloqueado == true}">
		<p>Se ha bloqueado correctamente</p>
	</c:if>
	<c:if test="${desbloqueado == true}">
		<p>Se ha desbloqueado correctamente</p>
	</c:if>
	

	<p>Estadisticas del servidor</p>

	<ul>
			<c:forEach items="${estadisticas}" var="stat">	
				<td>${stat.key}: ${stat.value}%</td>
			</c:forEach>
	</ul>

	<p>Listado de usuarios</p>
	
	<table>
	
		<tr>
			<th>Usuario</th>
			<th>Faccion</th>
			<th>Bloquear</th>
		</tr>
		
		<c:forEach items ="${listaUsuarios}" var="usuario">

			<tr>
				<td>${usuario.getUsuario()}</td>
				<td>${usuario.getFaccion()}</td>
				<c:if test="${usuario.getBloqueado() == false}">
					<td><a href="/GovernmentWars/Admin/Bloquear?usuario=${usuario.getUsuario()}">Bloquear</a></td>
				</c:if>
				<c:if test="${usuario.getBloqueado() == true}">
					<td><a href="/GovernmentWars/Admin/Desbloquear?usuario=${usuario.getUsuario()}">Desbloquear</a></td>
				</c:if>
				
			</tr>
	    	
		</c:forEach>
	</table>

</body>
</html>