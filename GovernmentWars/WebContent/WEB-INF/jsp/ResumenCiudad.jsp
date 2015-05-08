<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var antiguoNombre;
		var cambiarNombre;
		var nuevoNombre;
		var xhr;
		
		var registro;
		
		document.addEventListener('readystatechange', inicializar, false);

		function inicializar() {
			if (document.readyState == 'complete') {
				antiguoNombre = document.getElementById("nombre");
				nuevoNombre = document.getElementById("nuevoNombre");
				cambiarNombre = document.getElementById("cambiarNombre");
				cambiarNombre.addEventListener('click', ajax, false);
			}
		}
		
		function ajax(evento) {
			if (nuevoNombre.value != "" && nuevoNombre.value != ""){

				cambiarNombre.disabled = true;
				xhr = new XMLHttpRequest();
				xhr.addEventListener('readystatechange', gestionarRespuesta, false);
				xhr.open('get', "/GovernmentWars/Ajax/CambiarNombreCiudad?antiguoNombre=" + antiguoNombre.innerHTML + "&nombre=" + nuevoNombre.value, true);
				xhr.send(null);
			}
		}
		
		function gestionarRespuesta(evento){
			if (evento.target.readyState == 4 && evento.target.status == 200) {
				cambiarNombre.disabled = false;
				
				if(evento.target.responseText == "true"){
					antiguoNombre.innerHTML = nuevoNombre.value;
				}
				else{
					alert("no se ha cambiado el nombre de la ciudad");	
				}
			}
		}
	</script>
	
	
	<p>Bienvenido</p>
	
	<p>Nombre ciudad: <span id="nombre">${ciudad.getNombre()}</span></p><input type="text" id="nuevoNombre"/><input type="button" id="cambiarNombre" value="Cambiar Nombre"/>
	
	<p>Antena: ${ciudad.getRecurso("Antena")}</p>
	<p>Sobres: ${ciudad.getRecurso("Sobres")}</p>
	<p>Militantes: ${ciudad.getRecurso("Militantes")} </p>
	<p>Jueces: ${ciudad.getRecurso("Jueces")}</p>
	
	<p>Corrupcion: ${ciudad.getNivelCorrupcion()}</p>
	
	
	<p>Produccion</p>
	
	<ul>
		<li>antena: ${produccion.getRecurso("Antena")}</li>
		<li>sobres: ${produccion.getRecurso("Sobres")}</li>
		<li>jueces: ${produccion.getRecurso("Jueces")}</li>
	</ul>
	
	<a href="Perfil">Ir a perfil</a>
	
	<a href="Mensajes">Ver mensajes</a>
	
	<a href="/GovernmentWars/Juego/Edificios">Ver edificios</a>
	
	<a href="/GovernmentWars/Juego/Tecnologias">Ver tecnologias</a>
	
	<a href="/GovernmentWars/Juego/Tropas">Ver unidades</a>
	
</body>
</html>