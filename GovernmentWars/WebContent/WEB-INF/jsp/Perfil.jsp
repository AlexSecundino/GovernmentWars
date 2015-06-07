<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="base.jsp" />
	<div class="row">
		<div class="itm first-1">
			<h1>Datos del usuario ${usuario.getUsuario()}</h1>
				<form accept-charset="UTF-8" action="/GovernmentWars/Usuario/CambiarPerfil" method="post">
					<label for="usuario">Usuario</label><input class="form-control" type="text" value="${datosUsuario.getUsuario()}" disabled="disabled"></input>
					<br>
					<label for="genero">Genero</label><br>
					<select id="gnr" name="genero">
  						<option value="Hombre">Masculino</option>
  						<option value="Mujer">Femenino</option>
					</select>
					<br>
					<label for="pais">Pais</label><input class="form-control" type="text" name="pais" value="${datosUsuario.getPais()}"></input>
					<br>
					<label for="desc">Descripcion</label><input class="form-control" type="text" name="desc" value="${datosUsuario.getDescripcion()}"></input>
					<br>
					<label for="faccion">Faccion</label><input class="form-control" type="text" name="faccion" value="${datosUsuario.getFaccion()}" disabled="disabled"></input>
					<br>
					<input class="btn btn-primary btn-lg prf" type="submit" value="Guardar">
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

<script>
$('#gnr').val("${datosUsuario.getGenero()}").attr("selected","selected");
</script>
</body>
</html>
