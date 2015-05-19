<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="base.jsp" />
<c:forEach items ="${tecnologias}" var="tecnologia">
<div class="row">
	<div class="itm first-1">
		<div class="ccdd">
			<h1>${tecnologia.getNombre()}</h1>
			<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
	    </div> 
	    <div class="ccdd2">
	    	<c:forEach items="${tecnologia.getRecursos()}" var="recurso">	
				<p>${recurso.value}</p>
			</c:forEach>
			<a href="" class="btn btn-primary btn-lg">Investigar</a>
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

 -->