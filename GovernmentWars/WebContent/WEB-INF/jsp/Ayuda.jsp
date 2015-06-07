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
    });
  </script>
  
  <style>
	.boton-top{
		display: none;
		position:fixed;
		bottom:0;
		right:0;
		width:50px;
		height: 50px;
		text-align:center;
		line-height:50px;
		color:#fff;
		background: red;
		cursor:pointer;
	}
	
	#guias {font-size: 16px; color: blue; padding-bottom: 20px}
	#guias a {  display: block; padding: 5px 0; border-bottom: 1px solid #ECECEC; background-color: #F4F4F4; font-family: 'troika'; color: #777;}
	
	
	</style>
</head>
 
<body>
  <div class="wrap">
     <header class="page-header"><img src="<c:url value='/resources/img/logo_gw.jpg'/>"></header>
    
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
            <li class=""><a href="/GovernmentWars/Foro"><span class=""></span>Foro</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="reg"><a href="javascript:void(0)">Identificarse</a></li>
            <div class="hid" style="display:none">
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
          			<h1>Ayuda general sobre el juego</h1>
          			<div id="guias">
          				<a href="#intro"> Introducción</a>
          				<a href="#ideologiaynombre"> Ideología y nombre</a>
          				<a href="#arrancamos"> Arrancamos</a>
          				<a href="#edificios"> Edificios</a>
          				<a href="#unidades"> Unidades</a>
          				<a href="#tecnologias"> Tecnologías</a>
          				<a href="#mapa"> Mapa</a>
          				<a href="#historial"> Historial</a>
          				<a href="#perfil"> Perfil</a>
          			</div>
          			<a name="intro"></a>
          			<h1>Introducción</h1>
          			<p>Government Wars se trata de un juego de estrategia y gestión multijugador que usa de 
					plataforma el propio navegador. En él encarnaremos a una nueva fuerza política que trata de 
					hacerse con el gobierno. Tendrás que gestionar tu partido, tomar decisiones arriesgadas que 
					podrán encumbrarte o sumirte en las más oscura de las infamias. Pero ganar es muy sencillo 
					cuando juegas solo, así que existirán multitud de otras formaciones políticas que estarán tan 
					ávidas de poder como la tuya y que tratarán de pisarte la garganta en esta loca escalada de 
					poder.
					¿Podrás sobrevivir a esta jungla despiadada a la vez que enriqueces tu bolsillo con el dinero de 
					los contribuyentes?</p>
					<a name="ideologiaynombre"></a>
          			<h1>Ideología y nombre</h1>
          			<p>Cuando crees una nueva cuenta en este fantástico e innovador juego, tendrás que elegir una 
					ideología para tu partido. Puedes ser anarquista, socialdemócrata o liberal. La elección de tu 
					ideología es importante, porque te dará  acceso a tecnologías, edificios y unidades únicas. Los 
					liberales cuentan con un carácter más ofensivo, los socialdemócratas con uno equilibrado en el 
					que prima el saqueo de recursos y los anarquistas con un enfoque más defensivo.
					Además de esta ideología deberás dotar a tu partido de un nombre. Elige uno pegadizo que 
					haga mearse encima a tus enemigos y ganarse la confianza del pueblo. Este nombre será el 
					que te identifiqué, así que ya sabes… ¡Elige con cabeza!</p>
          			<a name="arrancamos"></a>
          			<h1>Arrancamos</h1>
          			<p>Una vez superado el registro (sé que ha sido duro, pero el esfuerzo habrá merecido la pena) 
					podrás por fin ser parte de las luchas intestinas por el control de la ciudad. Se te asignará una 
					localización aleatoria como lugar para tu sede y podrás empezar a tramar planes de 
					dominación y a despilfarrar dinero en costosas campañas electorales. Lo primero que verás 
					será tu pantalla principal. En ella tendremos un resumen de lo más destacable de tu ciudad, 
					todo lo que necesitas para de un vistazo saber cómo les están yendo las cosas a tu partido. Si 
					lo que necesitas es, un enfoque más individual de cada uno de los apartados, podremos 
					acceder a una pantalla más detallada.</p>
          			<a name="edificios"></a>
          			<h1>Edificios</h1>
          			<p>En esta página podremos ver el nivel al que tenemos los edificios, además de los recursos que 
					producen por hora.
					Sede: Es el edificio principal. Con él se determinan tanto el número de militantes que tienes 
					como el nivel máximo al que pueden llegar el resto de tus edificios sin generar corrupción.
					Banco: Genera sobres. Uno de los recursos más importantes del partido.
					Cadena de televisión: Genera antena. El segundo de los recursos más importantes del partido.
					Juzgados: Genera jueces leales a tu partido. Es un recurso usado en algunas tecnologías y 
					necesario para la creación de ministros.</p>
          			<a name="unidades"></a>
          			<h1>Unidades</h1>
          			<p>Aquí podremos ver las diferentes tropas que podremos crear. Cada unidad tiene su propio coste. Cuanto más caro 
					es el precio mejores son sus estadísticas.</p>
					<p>Cada facción a su vez tendrá una tropa única. En el caso de los <b>anarquistas</b> es el temido perroflauta. 
					Para los <b>social-democratas</b> tenemos al empresario, o empresaurio como suele decir. 
					Por último para los <b>liberales</b> está el perrito faldero, el temido guerrero y guardían de la cripta. El antidisturbios.</p>
					<p>Todas estas unidades se desbloquean mediante tecnologías que a su vez necesitan de algunos edificios de alto nivel. Podrás mirar siempre que quieras los requisitos
					de algo que no puedas construir posándote sobre el botón rojo, pero por el amor de dios ¡No lo pulses!)</p>
					<p>Leyenda de estadísticas:</p> 
					<p><b>A=Ataque</b>(Fuerza con la que golpea la unidad), 
					<b>V=Velocidad</b>(Velocidad a la que se mueve la unidad, cuanto mayor sea este número a mayor velocidad se movera la tropa de ataque en conjunto)
					, <b>D=Defensa</b>(Defensa contra el ataque de las unidades), <b>C=Capacidad</b>(Cantidad que puede almacenar la unidad en sus bolsillos al robar)</p>
          			<a name="tecnologias"></a>
          			<h1>Tecnologías</h1>
          			<p>En esta página podremos ver el árbol de tecnologías al que tendremos acceso según la 
					ideología que hayamos tomado para nuestro partido. Las tecnologías son necesarias para 
					acceder a nuevas y más poderosas unidades, además de a agradecidos bonos para las 
					estadísticas de nuestras huestes políticas.</p>
          			<a name="mapa"></a>
          			<h1>Mapa</h1>
          			<p>Desde aquí podremos ver la localización de nuestra sede respecto al resto de sedes existentes. 
					También podremos lanzar ataques contra nuestros enemigos para tratar de quedarnos con 
					parte de sus valiosos recursos. ¿Quién ha dicho que en la política no hubiese víctimas aparte 
					de los votantes?</p>
          			<a name="historial"></a>
          			<h1>Historial</h1>
          			<p>Aquí podremos ver un registro de los combates librados por nosotros, tanto si somos 
					atacantes o los atacados. Muy útil para ver el vencedor de la contienda. Y como en el mundo 
					de la política no se suele ver correr la sangre, ni se baten los combatientes con acero pues 
					estos se llaman debates, que al fin y al cabo son los coliseos modernos.</p>
          			<a name="perfil"></a>
          			<h1>Perfil</h1>
          			<p>Aquí podrás modificar y consultar diferentes apartados personales. Al fin y al cabo tu partido
					no sería nadie sin el pequeño gran hombre que lo dirige con diligencia. ¿No?</p>
          		</div>
          		<span class="boton-top">▲</span>
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
    <footer>
    	<div class="foot">
    		<div class="ccommons">
    			<img src="<c:url value='/resources/img/cc.png'/>">
    		</div>
    		<div class="social-media">
    			<a href="http://facebook.com"><img src="<c:url value='/resources/img/facebook.png'/>"></a>
    			<a href="http://twitter.com"><img src="<c:url value='/resources/img/twitter.png'/>"></a>
    			<a href="http://youtube.com"><img src="<c:url value='/resources/img/youtube.png'/>"></a>
    			<a href="http://linkedin.com"><img src="<c:url value='/resources/img/linkedin.png'/>"></a>
    			<a href="https://github.com/AlexSecundino/GovernmentWars"><img src="<c:url value='/resources/img/github.png'/>"></a>
    		</div>
    	</div>
    </footer>
  </div>

<script>
	$(window).scroll(function(){
	    if ($(this).scrollTop() > 0) {
	        $('.boton-top').fadeIn();
	    } else {
	        $('.boton-top').fadeOut();
	    }
	});
	
	$('.boton-top').click(function(){
	    $(document.body).animate({scrollTop : 0}, 500);
	    return false;
	});
</script>

<script>  
$(document).ready(function() {
	//BIND DEL BORDER-BOTTOM A PAGINA ACTUAL
	var pathArray = window.location.pathname.split( '/' );
	if (pathArray[2]=='') {
		$('a[href="' + /GovernmentWars/ + '"]').parent().addClass('active');
	} else {
		var actual = pathArray[2];
		$('a[href="/GovernmentWars/' + actual + '"]').parent().addClass('active');
	}
	
	//BIND DE LOGIN CON ENTER
	$('#ff input').keydown(function(e) {
		if (e.keyCode == 13) {
			$('#ffc').click();
	 	}
	});
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
    login = document.getElementById("ffc");
    login.addEventListener('click', ajax, false);
   }
  }
  
  function ajax(evento) {


   if (usuario.value != "" && pass.value != "") {
    login.disabled = true;
    xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', gestionarRespuesta, false);
    xhr.open('post', "/GovernmentWars/Ajax/Login?usuario=" + usuario.value + "&password=" + password.value, true);
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
    	alert("Lo sentimos, tu usuario se encuentra bloqueado por alguna razón.");
    }
    else{
     alert("Usuario o password incorrectos."); 
    }
   }
  }
</script>

</body>
</html>
