<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="base.jsp" />
<c:forEach items ="${edificios}" var="edificio">
<div class="row">
	<div class="itm first-1">
		<div class="ccdd">
			<h1>${edificio.getNombre()} nivel ${edificio.getNivel()}</h1>
			<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
	    </div> 
	    <div class="ccdd2">
	    	<table>
	    	<tr>
	    		<td>Sobres</td>
	    		<td>Antena</td>
	    		<td>Jueces</td>
	    	</tr>
	    	<tr>
	    	
	    	<td>${edificio.getRecurso('Sobres')}</td>
	    	<td>${edificio.getRecurso('Antena')}</td>
	    	<td>${edificio.getRecurso('Jueces')}</td>
			
			</tr>
			</table>
			<a href="" class="btn btn-primary btn-lg">Subir nivel</a>
	   	</div>
	</div>
</div>
</c:forEach>
</div>
</div>
</div>
</div>
</div>
<!-- 

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

 -->