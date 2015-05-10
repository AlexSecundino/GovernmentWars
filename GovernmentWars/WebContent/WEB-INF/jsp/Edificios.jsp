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

	<p>Listado de edificios</p>
	<p>Hola que ase</p>
	
	<table>
		<th>Nombre</th>
		<th>Nivel</th>
		<th>Antena</th>
		<th>Sobres</th>
		<th>Jueces</th>
		<th>Tiempo de construcción</th>
		<th>Aumentar nivel</th>
	
		<c:forEach items ="${edificios}" var="edificio">
	          <tr id="${edificio.getNombre()}">
	             <td>${edificio.getNombre()}</td>
	             <td>${edificio.getNivel()}</td>
	             
	             <c:forEach items="${edificio.getRecursos()}" var="recurso">
    					<td>${recurso.value}</td>
				 </c:forEach>
	             
	             <td>${edificio.formatearTiempo(edificio.getTiempoConstruccion())}</td>
	             
	             <td>
		             <c:if test="${edificio.getNivel() >= 10}">
		             	Nivel al maximo
		             </c:if>
		             <c:if test="${edificio.getNivel() < 10}">
		             	<a href="">Aumentar nivel</a>
		             </c:if>
	             </td>
	          </tr>
	    </c:forEach>
	    
    </table>
	
</body>
</html>
