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
      <div id="carousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="item active">
                <img alt="Bootstrap template" src="<c:url value='/resources/img/img1.jpg'/>">
                <div class="carousel-caption"></div>
            </div>
            <div class="item">
                <img alt="Bootstrap template" src="<c:url value='/resources/img/img2.jpg'/>">
                <div class="carousel-caption"></div>
            </div>
            <div class="item">
                <img alt="Bootstrap template" src="<c:url value='/resources/img/img3.jpg'/>">
                <div class="carousel-caption"></div>
            </div>
        </div>

      <ol class="carousel-indicators">
        <li data-target="#carousel" data-slide-to="0" class="active"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
        <li data-target="#carousel" data-slide-to="2"></li>
      </ol>
      
      </div>

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

      <section class="sec">
        <div class="container">
          <div class="row">
            <div class="col-md-4">
              <div class="nall">
                <div class="nt pb-20">
                  <img src="<c:url value='/resources/img/construye.png'/>">
                </div>
                <div class="nc ">
                  <h1>Construye</h1>
                  <p>Crea edificios para dotar a tu partido de los recursos necesarios para conseguir el poder. 
                     ¡Recuerda! ¡Sin financiación ni cobertura mediática no eres nadie! ¡Consigue que tu partido 
                     sea el más grande!</p>
                </div>
              </div>
            </div>
            
            <div class="col-md-4">
              <div class="nall">
                <div class="nt pb-20">
                  <img src="<c:url value='/resources/img/lucha.png'/>">
                </div>
              <div class="nc">
                  <h1>Combate</h1>
                  <p>¿Quién dijo que ver a varios partidos políticos reunidos en las cámaras no fuese tan sangriento
                     como ver a los gladiadores en el coliseo? ¡Envía a tus chicos a tirar por tierra todos los planes 
                     de tus rivales, y de paso déjales los maletines vacíos!</p>
                </div>
              </div>
            </div>

            <div class="col-md-4">
              <div class="nall">
                <div class="nt pb-20">
                  <img src="<c:url value='/resources/img/investiga.png'/>">
                </div>
                <div class="nc">
                  <h1>Investiga</h1>
                  <p>Hazte con los conocimientos necesarios para sobresalir en el mundillo. Evadir impuestos, 
                     guardar ahorrillos en Suiza, coches oficiales, sobresueldos en dietas… Nada es suficiente en 
                     comparación con lo que podrías ganas aposentando tu trasero en la silla de presidente.</p>
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>

      <section class="sec sec-white">
        <div class="container">
          <div class="row">
            <div class="col-md-12 pl-20 font-high">
              <h1>¿De qué bando estás?</h1>
              <hr>
              <p>Elige una de las tres facciones (izquierda, centro, derecha) y aventúrate en una vertiginosa
                 carrera por alcanzar el gobierno. Cada una de ellas con sus peculiaridades, unidades especiales 
                 y tecnologías únicas.</p>
            </div>
            <div class="col-md-12 pl-20">
              <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/anarchy2.png'/>">
              <div class="texto-facc" style="display:none">
              	<p>Ya sabes de qué va todo esto. Denuncia social, derechos de los animales, perroflautismo, 
				vegetarianismo…. ¡Sé todo lo rebelde que siempre has querido ser! ¡Coge tus rotuladores y 
				hazte una pancarta para la primera manifestación que encuentres! ¡O únete a una banda de 
				rock y abofetea a los corruptos con tu música infernal!
				Claro, que también puedes montar un partido y tratar de sacar de juego a los malos. Incluso 
				puedes enriquecerte un poco mientras llevas a cabo esta lucha. ¿Qué son unos cuantos miles 
				de euros en tu bolsillo cuando estás luchando por el pueblo? Pero mejor que nadie se dé 
				cuenta, no querrás perder el amor de tus electores. ¿O sí?</p>
              </div>
              <h1>Anarquia</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/edificio2.png'/>">
              <div class="texto-facc" style="display:none">
              	<p>Ni frío ni calor, lo moderado es cómodo, amigable, calmado. ¿Que la mayoría del pueblo dice
				que desea el derecho a matrimonio de sus mascotas? Pues se le concede. ¿Que la mayoría 
				ahora decide establecer como fiesta nacional el día de “Corremos Todos en Pelota Picada”? 
				Pues nada, a quitarse todos la ropa y a correr. ¿Que la mayoría dictamina que se ha de bajar el 
				sueldo a los políticos? Bueno… Tampoco nos pasemos. ¿Eh?
				Asóciate con los presidentes de las mayores empresas, procura cosechar este tipo de 
				relaciones y cuando te jubiles podrás trabajar en 4 puestos diferentes, en 3 empresas distintas, 
				simultáneamente. ¿Quién dijo que la omnipresencia era solo para divinidades? Y si las cosas 
				empiezan a ir mal desborda a los periodistas con una lluvia de billetes, o con una de falacias 
				mientras te escabulles por la puerta trasera.</p>
              </div>
              <h1>Social-democracia</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/corona2.png'/>">
              <div class="texto-facc" style="display:none">
              	<p>Todos son unos mariquitas, rojos, ateos, populistas, cobardes, desertores… ¡Todos menos tú y
				los que piensan como tú! Sabes lo que es lo mejor para tu país, sabes que lo que siempre ha 
				funcionado jamás dejará de hacerlo. ¿Por qué todos se empeñan en cambiar las cosas cuando 
				todo está perfecto tal y como están? Al servicio militar os enviaba yo a todos a que 
				aprendieseis un poco de disciplina.
				Defiende los valores fundamentales de una sociedad pura, decente y tradicional. Ponte la 
				bandera patria por capa y lucha contra todos los engendros abominables que desean manchar 
				el honor de tu país. Construye un muro lo más alto posible para que nadie ni nada pueda 
				traspasar tus fronteras y mancillar tu cultura. Y si la gente se queja ya sabes, somanta de palos 
				y  que se paguen las facturas del médico. ¿Qué el servicio médico es gratuito? Bueno, bueno, 
				eso ya lo veremos.</p>
              </div>
              <h1>Liberalismo</h1>
            </div>
            </div>
          </div>
        </div>  
      </section>
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
	$(".obj img[src*=2]").click(function(event) {
		if ($(this).next().is(":visible"))
			$(this).next().hide("slow");
		else
			$(this).next().show("slow");
			
	});
</script>


<script>  
$(document).ready(function() {
	//BIND DEL BORDER-BOTTOM A PAGINA ACTUAL
	var pathArray = window.location.pathname.split( '/' );
	if (pathArray[2]=='') {
		$('a[href="' + /GovernmentWars/ + '"]').parent().addClass('active');
	} else {
		var actual = pathArray[1];
		$('a[href="' + actual + '"]').parent().addClass('active');
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
