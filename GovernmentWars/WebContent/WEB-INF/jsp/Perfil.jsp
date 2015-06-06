<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="base.jsp" />
	<div class="row">
		<div class="itm first-1">
			<h1>Datos del usuario ${usuario.getUsuario()}</h1>
				<label for="usuario">Usuario</label><input type="text" value="${datosUsuario.getUsuario()}" disabled="disabled"></input>
				<br>
				<label for="genero">Genero</label><input type="text" name="genero" value="${datosUsuario.getGenero()}"></input>
				<br>
				<label for="pais">Pais</label><input type="text" name="pais" value="${datosUsuario.getPais()}"></input>
				<br>
				<label for="desc">Descripcion</label><input type="text" name="desc" value="${datosUsuario.getDescripcion()}"></input>
				<br>
				<label for="faccion">Usuario</label><input type="text" name="faccion" value="${datosUsuario.getFaccion()}" disabled="disabled"></input>
				<br>
				<!-- input type="button" id="chg-prf" value="Guardar">-->
				<a href="/GovernmentWars/Usuario/CambiarPerfil">Guardar</a>
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