<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

	<script>
		var unidad;
		var cantidad;
		var crearUnidad;
		var xhr;
		
		function ajax(evento) {
			xhr = new XMLHttpRequest();
			xhr.addEventListener('readystatechange', gestionarRespuesta, false);
			xhr.open('get', "/GovernmentWars/Ajax/CrearUnidad?unidad=" + unidad + "&cantidad=" + cantidad, true);
			xhr.send(null);
		}
		
		function gestionarRespuesta(evento){
			if (evento.target.readyState == 4 && evento.target.status == 200) {	
				if(evento.target.responseText == "true"){
					alert("creando unidades...");
				}
				else{
					alert(evento.target.responseText);	
				}
			}
		}
	
	
		function crearUnidad(u){
			unidad = u;
			cantidad = document.getElementById(unidad).value;
			
			if(u != "" && (cantidad != "" || cantidad > 0)){
				ajax();
				
			}
			else{
				alert("inserte una cantidad valida (n>0)");
			}
			
		}
	</script>
	
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
		    		<td>Requisitos/Crear unidad</td>
		    	</tr>
		    	<tr>
		    		<c:forEach items="${unidad.getRecursos()}" var="recurso">	
						<td>${recurso.value}</td>
					</c:forEach>
					<c:if test="${unidad.getCumpleRequisitos() == false}">
						<td>${unidad.getRequisitos()}</td>
					</c:if>
					<c:if test="${unidad.getCumpleRequisitos() == true}">
						<td><a href="" class="btn btn-primary btn-lg">Crear unidad</a></td>
					</c:if>
				</tr>
			</table>
			
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
				
				<c:if test="${unidad.getCumpleRequisitos() == false}">
					<td>${unidad.getRequisitos()}</td>
				</c:if>
				<c:if test="${unidad.getCumpleRequisitos() == true}">
						<td><label for="${unidad.getNombre()}"><input type="text" id="${unidad.getNombre()}"></label></td>
						<td><input type="button" onclick="crearUnidad('${unidad.getNombre()}')" value="Crear Unidad"/><td>
				</c:if>
				<td><label for="${unidad.getNombre()}"><input type="text" id="${unidad.getNombre()}"></label></td>
						<td><input type="button" onclick="crearUnidad('${unidad.getNombre()}')" value="Crear Unidad"/><td>
             	
             </tr>
        </c:forEach>  


 -->
