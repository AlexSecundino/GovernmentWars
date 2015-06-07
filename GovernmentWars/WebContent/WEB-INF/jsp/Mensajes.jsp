<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="base.jsp" />
	<div class="row">
		<div class="itm first-1">
			<div class="nat-accordion">
				<c:forEach items ="${listaMensajes}" var="mensaje">
				<fmt:formatDate value="${mensaje.getFecha()}" var="dateString" pattern="dd/MM HH:mm"/>
					<c:if test="${mensaje.isLeido() == false}">
	    				<div class="nat-accordion-button clearfix noleido" id="${mensaje.getId()}">${mensaje.getAsunto()}<div class="remitent">${mensaje.getRemitente()}</div><div>${dateString}</div></div>
	    			</c:if>
	    			<c:if test="${mensaje.isLeido() == true}">
	    				<div class="nat-accordion-button clearfix">${mensaje.getAsunto()}<div class="remitent">${mensaje.getRemitente()}</div><div>${dateString}</div></div>
	    			</c:if>
	    			<div class="nat-accordion-content">
	      				<p>${mensaje.getMensaje()}</p>
	      				<a class="elim" id="${mensaje.getId()}">Eliminar</a> 
	    			</div>
    			</c:forEach>
    		</div>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>


<script>
$(document).ready(function() {
	$(document).on("click", ".noleido", function (e) { 
		$(this).removeClass("noleido");
		e.stopPropagation();
		
		if ($('.noleido').length==0) {
			sessionStorage.removeItem('msg');
		}
		mensajeVisto($(this).attr("id"));
});
	
	
	
	  var oneAtTime = true;
	  $(".nat-accordion-button").click(function() {
	    $(".nat-accordion-button").removeClass("active");
	    if ( $(this).next(".nat-accordion-content").is(":visible") ) {
	      $(this).next(".nat-accordion-content").slideUp();
	    }
	    else {
	      if (oneAtTime == true) {
	        $(".nat-accordion-content").slideUp().delay(50);
	      }
	      $(this).next(".nat-accordion-content").slideDown();
	      $(this).addClass("active");
	    }
	  });	
	  
	  
	  $(document).on("click", ".elim", function (e) {
			ajax($(this).attr("id"))		
		})
	});
	
	function mensajeVisto(id) {
		var parametros = {"id" : id};
  		console.log(parametros);
      	$.ajax({
        	data:  parametros,
            url:   '/GovernmentWars/Ajax/MensajeLeido',
            type:  'post',
            success:  function (response) {
            	console.log("leido grabado en el server");
            }
      	});
	}
	
	function ajax(id) {
  		var parametros = {"id" : id};
  		console.log(parametros);
      	$.ajax({
        	data:  parametros,
            url:   '/GovernmentWars/Ajax/EliminarMensaje',
            type:  'post',
            success:  function (response) {
            	if (response=='true') {
            		location.reload();
            	}
            }
      	});
	}
</script>
<!-- 
<c:if test="${mensaje.isLeido() == true}">
	<td>ya lo has leido</td>
</c:if>
<c:if test="${mensaje.isLeido() == false}">
	<td>Mensaje nuevo!!!</td>
</c:if>

			<table>
				<thead>
					<th>Remitente</th>
					<th>Asunto</th>
					<th>Fecha</th>
				</thead>
				<c:forEach items ="${listaMensajes}" var="mensaje">
          			<tr id="${mensaje.getId()}">
             			<td>${mensaje.getRemitente()}</td>
             			<td>${mensaje.getAsunto()}</td>
             			<fmt:formatDate value="${mensaje.getFecha()}" var="dateString" pattern="dd/MM-hh:mm" />
				 		<td>${dateString}</td>
	             		<td>
	             			<a href="">ver</a>
	             		</td>
		             	<td>
		             		<a href="">eliminar</a>
		             	</td>
          			</tr>
    			</c:forEach>
			</table>
 -->
