<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tengo colita :D</title>
</head>
<body>

	<table>
		<tr>
			<th>Atacante</th>
			<th>Defensor</th>
			<th>TropasEnviadas</th>
			<th>TropasPerdidasAtacante</th>
			<th>TropasDefendiendo</th>
			<th>TropasPerdidasDefensor</th>
			<th>Botin</th>
			<th>Fecha Ataque</th>
			<th>isLeido</th>
		</tr>
		
		<c:forEach items ="${listaLogAtaques}" var="log">
			<tr>
				<td>${log.getAtacante()} from ${log.getnCiudadAtacante()}</td>
				<td>${log.getDefensor()} from ${log.getnCiudadDefensor()}</td>
				
				<td>${log.getnTropasEnviadas()}</td>
				<td>${log.getnTropasPerdidasAtacante()}</td>
				<td>${log.getnTropasDefensor()}</td>
				<td>${log.getnTropasPerdidasDefensor()}</td>
				
				<td>${log.getRecurso('Sobres')}:${log.getRecurso('Antena')}:${log.getRecurso('Jueces')}</td>
				
				<td>${log.getFechaAtaque()}</td>
				
				<c:if test="${log.isLeido() == true}">
			            <td>Ya lo has leido :D</td> 	
			    </c:if>
				<c:if test="${log.isLeido() == false}">
			            <td>Puto afk leelo</td> 	
			    </c:if>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>