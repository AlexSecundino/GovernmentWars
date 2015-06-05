<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="base.jsp" />
<div class="row">
	<div class="itm first-1 datagrid">
		<table>
			<tr>
				<th>Ciudad</th>
				<th>Usuario</th>
				<th>Raza</th>
				<th>Coordenadas</th>
			</tr>
			<c:forEach items ="${listaUsuarios}" var="usuario">
	
				<tr>
					<td>${usuario.getnCiudad()}</td>
					<td>${usuario.getUsuario()}</td>
					<td>${usuario.getFaccion()}</td>
					<td>${usuario.getCoordenadas()}</td>
					<td><a href="/GovernmentWars/Usuario/NuevoMensaje"><i class="fa fa-envelope"></i></a></td>
					<td><a class="" href="/GovernmentWars/Juego/Atacar?usuario=${usuario.getUsuario()}&ciudad=${usuario.getnCiudad()}">Atacar</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${atacar == true}">
			<p>Se ha enviado el ataque</p>
		</c:if>
		<c:if test="${atacar == false}">
			<p>Fallo al atacar</p>
		</c:if>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
>>>>>>> refs/heads/master
</body>
</html>
