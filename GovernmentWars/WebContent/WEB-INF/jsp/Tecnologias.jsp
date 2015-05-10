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

	<p>Listado de tecnologias</p>
	
	<table>
		<th>Nombre</th>
		<th>Antena</th>
		<th>Sobres</th>
		<th>Jueces</th>
		<th>Tiempo de construcción</th>
		<th>Investigar/Requisitos</th>
	
		<c:forEach items ="${tecnologias}" var="tecnologia">
	          <tr id="${tecnologia.getNombre()}">
	             <td>${tecnologia.getNombre()}</td>
	             
	             <c:forEach items="${tecnologia.getRecursos()}" var="recurso">
    					<td>${recurso.value}</td>
				 </c:forEach>
	             
	             <td>${tecnologia.formatearTiempo(tecnologia.getTiempoConstruccion())}</td>
	             
	             <td>
	             	<c:if test="${tecnologia.isInvestigada() == true}">
             			Ya se ha investigado
             		</c:if>
             		<c:if test="${tecnologia.isInvestigada() == false}">
             			<c:if test="${tecnologia.getCumpleRequisitos() == false}">
             				${tecnologia.getRequisitos()}
             			</c:if>
             			<c:if test="${tecnologia.getCumpleRequisitos() == true}">
             				<a href="">Investigar</a>
             			</c:if>
             		</c:if>
	             </td>
	          </tr>
	    </c:forEach>
	    
    </table>
	
</body>
</html>
