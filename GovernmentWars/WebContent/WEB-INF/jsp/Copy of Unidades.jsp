<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>Listado de unidades</p>
	
	<table>
		<th>Nombre</th>
		<th>Ataque</th>
		<th>Defensa</th>
		<th>Velocidad</th>
		<th>Capacidad</th>
		<th>Antena</th>
		<th>Sobres</th>
		<th>Jueces</th>
		<th>Militantes</th>
		<th>Tiempo de construcción</th>
		<th>Crear/Requisitos</th>
	
		<c:forEach items ="${unidades}" var="unidad">
			<tr id="${unidad.getNombre()}">
				<td>${unidad.getNombre()}</td>
				<td>${unidad.getAtaque()}</td>
				<td>${unidad.getDefensa()}</td>
				<td>${unidad.getSpeed()}</td>
				<td>${unidad.getCapacidad()}</td>
				
				<c:forEach items="${unidad.getRecursos()}" var="recurso">
					<td>${recurso.value}</td>
				</c:forEach>
				
				<td>${unidad.formatearTiempo(unidad.getTiempoConstruccion())}</td>
				<td>
					<c:if test="${unidad.getCumpleRequisitos() == false}">
						${unidad.getRequisitos()}
					</c:if>
					<c:if test="${unidad.getCumpleRequisitos() == true}">
						<a href="">Crear Unidad</a>
					</c:if>
             	</td>
             </tr>
        </c:forEach>  
    </table>
    
</body>
</html>