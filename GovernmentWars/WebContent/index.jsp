<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Government Wars</title>
</head>
<body>

	<script>
		var login;
		var usuario;
		var pass;
		var xhr;
		
		var registro;
		
		document.addEventListener('readystatechange', inicializar, false);

		function inicializar() {
			if (document.readyState == 'complete') {
				usuario = document.getElementById("usuario");
				pass = document.getElementById("password");
				login = document.getElementById("aceptar");
				login.addEventListener('click', ajax, false);
			}
		}
		
		function ajax(evento) {
			if (usuario.value != "" && pass.value != ""){
				login.disabled = true;
				xhr = new XMLHttpRequest();
				xhr.addEventListener('readystatechange', gestionarRespuesta, false);
				xhr.open('get', "/GovernmentWars/Ajax/Login?usuario=" + usuario.value + "&password=" + password.value, true);
				xhr.send(null);
			}
		}
		
		function gestionarRespuesta(evento){
			if (evento.target.readyState == 4 && evento.target.status == 200) {
				login.disabled = false;
				
				if(evento.target.responseText == "true"){
					location.href = "/GovernmentWars/Usuario/Index";
				}
				else{
					alert("usuario o pass incorrectas");	
				}
			}
		}
		
	</script>
	
	<c:choose>
   		<c:when test="${registroCorrecto.equals(true)}">
			<p>Registro realizado correctamente<p>
		</c:when>
   		<c:when test="${registroCorrecto.equals(false)}">
   			<p>Fallo al realizar el registro<p>
   		</c:when>
	</c:choose>
	
	<form>
		<input type="text" name="usuario" id="usuario"/>
		<input type="text" name="password" id="password"/>
		<input type="button" id="aceptar" value="Login"/>
		<label><a href="Usuario/Registro">Registrate ahora!</a></label>
	</form>
	
</body>
</html>