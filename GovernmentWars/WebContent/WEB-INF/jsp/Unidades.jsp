<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="base.jsp" />
<c:forEach items ="${unidades}" var="unidad">
<div class="row">
	<div class="itm first-1">
		<div class="ccdd">
			<h1>${unidad.getNombre()}</h1>
			<h2>${unidad.getAtaque()}/${unidad.getSpeed()}/${unidad.getDefensa()}/${unidad.getCapacidad()}</h2>
			<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
	    </div> 
	    <div class="ccdd2">
	    	<c:forEach items="${unidad.getRecursos()}" var="recurso">	
				<p>${recurso.value}</p>
			</c:forEach>
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