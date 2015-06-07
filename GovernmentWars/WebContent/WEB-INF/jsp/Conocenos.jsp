<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>GovWars ||</title>
  <link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.ico'/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" >
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <script>
    $(document).ready(function() {
      $(".hid").hide();
      $(".reg").click(function() {
        if ($(".hid").is(':hidden'))
            $(".hid").show(1);
          else
            $(".hid").hide(1);
      })

      // CLICK FUERA Y DESAPARECE DIV

      // ################
    });
  </script>
</head>
 
<body>
  <div class="wrap">
    <header class="page-header"><h1>LOGO COOL >:)</h1></header>
    
    <div class="menu">
      <ul class="navbar navbar-default cpp" role="navigation">
          <div class="navbar-header hidden-sm hidden-md hidden-lg">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

          </div>

        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
            <li class=""><a href="/GovernmentWars/"><span class=""></span>Inicio</a></li>
            <li class=""><a href="/GovernmentWars/Conocenos"><span class=""></span>Conocenos</a></li>
            <li class=""><a href="/GovernmentWars/Ayuda"><span class=""></span>Ayuda</a></li>
            <li class=""><a href="/GovernmentWars/"><span class=""></span>Foro</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="reg"><a href="javascript:void(0)">Identificarse</a></li>
            <div class="hid">
              <em></em>
              <form id='ff'>
                <fieldset>
                  <label for="usuario">Usuario</label><input type="text" name="usuario" id="usuario"/><br/>
                  <label for="password">Contraseña</label><input type="password" name="password" id="password"/><br/>
                  <input type="button" value="Send" id="ffc"><span><a href="/GovernmentWars/Usuario/Registro">Aun no te has registrado?</a></span>
                </fieldset>
              </form>
            </div>
          </ul>
        </div>
      </ul>
    </div>
    
    <div class="bod">
    
    <section class="sec">
        <div class="container">
          <div class="row">
          	<div class="col-md-12 texto-normal">
          		<h1>Conoce al equipo de GovernmentWars</h1>
          		<p>Government Wars se trata de un proyecto desarrollado por un grupo de tres estudiantes de 
				“Desarrollo de Aplicaciones Web” del I.E.S. Clara del Rey como proyecto de fin de grado. 
				Siendo jugadores de este tipo de juegos, un día, decidiendo sobre el futuro de nuestro 
				proyecto y bien acompañados de unos buenos tercios de Mahou decidimos que se había 
				hecho juegos de casi todo, pero que nunca, jamás de los jamases se había llevado a cabo uno 
				con temática de política. Y como el desarrollo nos parecía un reto y de la temática se podía 
				extraer bastante jugo pues nos dijimos: “Oye, vamos a hacerlo” y tras varias rondas después la 
				idea quedó bastante consolidada.
				La idea del juego era transmitir una sensación de crítica pero siempre de la mano con una 
				sátira desenfadada, al fin y al cabo no se busca ofender, solamente diversión y alguna que otra 
				sonrisa.
				Y como a todos nos gusta reírnos y pasárnoslo bien, y como teníamos la necesidad por ley de 
				sacar un proyecto adelante si queríamos el diploma…
				¡Aquí os presentamos a nuestra criatura!</p>
          	</div>
          </div>
        </div>
      </section>

      <section class="sec sec-white">
        <div class="container">
          <div class="row">
          
          </div>
        </div>  
      </section>
    
    

      <div class="callout">
        <div class="container">
          <div class="row">
            <div class="col-md-9 pl-20">
              <h1>¿Estás preparado? La verdadera batalla comienza ahora.</h1>
              <p>Gestiona tu propio partido político, tomando las decisiones que lo llevarán a la cumbre o a las más inmuda de las ignominias.</p>
            </div>
            <div class="col-md-3 pl-20">
              <a href="/GovernmentWars/Usuario/Registro" class="btn btn-primary btn-lg">Registrate ya</a>
            </div>
          </div>
        </div>
      </div>

      
    </div>
    <footer><div class="foot"></div></footer>
  </div>

<script>
  $(document).ready(function() {
    var pathArray = window.location.pathname.split( '/' );
    var actual = pathArray[pathArray.length-1];
    console.log($('a[href="' + actual + '"]'));
    $('a[href="' + actual + '"]').parent().addClass('active');
  });
  
  $('#ff input').keydown(function(e) {
	    if (e.keyCode == 13) {
	        $('#ffc').click();
	  	}
  });
</script>

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
    login = document.getElementById("ff");
    login.addEventListener('click', ajax, false);
   }
  }
  
  function ajax(evento) {


   if (usuario.value != "" && pass.value != "") {
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
    if(evento.target.responseText == "1"){
     location.href = "/GovernmentWars/Usuario/Index";
    }
    else if(evento.target.responseText == "2"){
    	alert("estas bloqueado pinche la wea!! report!!!");
    }
    else{
     alert("usuario o pass incorrectas"); 
    }
   }
  }
</script>

</body>
</html>
