<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Se comenta que esto es un mapa</title>
</head>
<body>

	<jsp:include page="base.jsp" />
	
	<table class="itm">
		<tr>
			<th>Ciudad</th>
			<th>Usuario</th>
			<th>Raza</th>
			<th>Coordenadas</th>
			<th>¡Al ataque! FOR THE HORDE</th>
		</tr>
		<c:forEach items ="${listaUsuarios}" var="usuario">

			<tr>
				<td>${usuario.getnCiudad()}</td>
				<td>${usuario.getUsuario()}</td>
				<td>${usuario.getFaccion()}</td>
				<td>${usuario.getCoordenadas()}</td>EAD
				<!-- AJAX???? -->
				<td><a href="/GovernmentWars/Juego/Atacar?usuario=${usuario.getUsuario()}&ciudad=${usuario.getnCiudad()}">Atacar</a></td>
			</tr>
	    	
		</c:forEach>
	</table>
	
	
	<c:if test="${atacar == true}">
		<p>Se ha enviado el ataque</p>
	</c:if>
	<c:if test="${atacar == false}">
		<p>Fallo al atacar</p>
	</c:if>
</body>
</html>
