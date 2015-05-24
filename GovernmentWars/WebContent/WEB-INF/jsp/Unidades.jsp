<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="base.jsp" />
<c:forEach items ="${unidades}" var="unidad">
<div class="row">
	<div class="itm first-1">
		<div class="ccdd">
			<h1>${unidad.getNombre()}   <span>${unidad.getAtaque()}/${unidad.getSpeed()}/${unidad.getDefensa()}/${unidad.getCapacidad()}</span></h1>
			<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
	    </div> 
	    <div class="ccdd2">
 		    <table>
		    	<tr>
		    		<td>Sobres</td>
		    		<td>Militantes</td>
		    		<td>Jueces</td>
		    		<td>Antena</td>
		    	</tr>
		    	<tr>
	    	<c:forEach items="${unidad.getRecursos()}" var="recurso">	
				<td>${recurso.value}</td>
			</c:forEach>
			</tr>
			</table>
			<a href="" class="btn btn-primary btn-lg">Crear unidad</a>
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


 -->