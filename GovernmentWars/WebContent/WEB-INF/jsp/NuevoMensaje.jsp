<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="base.jsp" />
	<div class="row">
		<div class="itm first-1">
			<div class="">
					<div class="container">
						<div class="row">
							<h1>Mensaje para ${destinatario.getUsuario()}</h1>
							<div class="span4 well" style="padding-bottom:0">
	            				<form accept-charset="UTF-8" action="/GovernmentWars/Usuario/EnviarMensaje" method="post">
	            					<input type="hidden" name="destinatario" value="${destinatario.getUsuario()}">
	                				<div class="form-group">
										<input id="asunto" name="asunto" type="text" class="form-control" placeholder="Escribe el asunto del mensaje..." required>
									</div>
									<div class="form-group">
	                					<textarea class="container-fluid" id="new_message" name="mensaje" placeholder="Escribe tu mensaje..." rows="5" style="width:100%" required></textarea>
	                				</div>
	                				<button class="btn btn-info" type="submit" style="margin-bottom:15px">Enviar mensaje</button>
	            				</form>
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
</div>
</div>
</div>

<script>
<c:if test="${envioMensaje == true}">
	alert('Tu mensaje se ha enviado correctamente');
	window.location.replace("/GovernmentWars/Juego/Mapa");
</c:if>
<c:if test="${envioMensaje == false}">
	alert('Mensaje no enviado, lo sentimos');
	window.location.replace("/GovernmentWars/Juego/Mapa");
</c:if>
</script>
</body>
</html>
