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
            <li class=""><a href="/GovernmentWars/SobreNosotros"><span class=""></span>Sobre nosotros</a></li>
            <li class=""><a href="/GovernmentWars/"><span class=""></span>Ayuda</a></li>
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
                  <input type="button" value="Send"><span><a href="Usuario/Registro">Aun no te has registrado?</a></span>
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
              <a href="Usuario/Registro" class="btn btn-primary btn-lg">Registrate ya</a>
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
                  <img src="<c:url value='/resources/img/edif.jpg'/>">
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
                  <img src="<c:url value='/resources/img/edif.jpg'/>">
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
                  <img src="<c:url value='/resources/img/edif.jpg'/>">
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
              <h1>Izquierda</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/edificio2.png'/>">
              <h1>Centro</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/corona2.png'/>">
              <h1>Derecha</h1>
            </div>
            </div>
          </div>
        </div>  
      </section>
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
    
    if(evento.target.responseText == "true"){
     location.href = "/GovernmentWars/Usuario/Index";
    }
    else{
     alert("usuario o pass incorrectas"); 
    }
   }
  }
</script>

</body>
</html>