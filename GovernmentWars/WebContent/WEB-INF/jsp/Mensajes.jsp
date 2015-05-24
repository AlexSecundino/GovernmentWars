<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Mazo mensajes loco!!</p>
	
	<table>
	<thead>
		<th>Remitente</th>
		<th>Asunto</th>
		<th>Fecha</th>
		<th>Hora</th>
		<th>Leido</th>
		<th>ver</th>
	</thead>
	<c:forEach items ="${listaMensajes}" var="mensaje">
          <tr id="${mensaje.getId()}">
             <td>${mensaje.getRemitente()}</td>
             <td>${mensaje.getAsunto()}</td>
             
             <fmt:formatDate value="${mensaje.getFecha()}" var="dateString" pattern="dd/MM-hh:mm" />
			 
			 <td>${dateString}</td>
             
             <c:if test="${mensaje.isLeido() == true}">
             	<td>ya lo has leido</td>
             </c:if>
             <c:if test="${mensaje.isLeido() == false}">
             	<td>Mensaje nuevo!!!</td>
             </c:if>
             
             <td>
             	<a href="">ver</a>
             </td>
             <td>
             	<a href="">eliminar</a>
             </td>
          </tr>
    </c:forEach>
	
	</table>
	
	<a href="/GovernmentWars/Usuario/NuevoMensaje">Nuevo mensaje</a>
	
</body>
</html>