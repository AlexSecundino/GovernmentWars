<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>GovWars || Registro</title>
  <link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.ico'/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" >
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

      $(".obj img[src*=2]").mouseover(function(event) {
        var src = $(this).attr("src").replace("2","");
        $(this).attr("src", src);
      });

      $(".obj img[src*=2]").mouseout(function(event) {
        var src = $(this).attr("src").match(/[^\.]+/) + "2.png";
        $(this).attr("src", src);
      });

      $(".obj img").click(function(event) { 
      });


    // CLICK FUERA Y DESAPARECE DIV

    // ################
    });
  </script>
</head>
 
<body>
  <div class="wrap">
    <header class="page-header"><h1>LOGO COOL >:)</h1></header>
    
    <!-- <img class=".img-responsive" src="gov.png" alt="GovWars"> -->
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
            <li class=""><a href="/GovernmentWars/"><span class=""></span>About us</a></li>
            <li class=""><a href="/GovernmentWars/"><span class=""></span>Ayuda</a></li>
            <li class=""><a href="/GovernmentWars/"><span class=""></span>Foro</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="reg"><a href="#">Login</a></li>
            <div class="hid">
              <em></em>
              <form action="" id='ff'>
                <fieldset>
                  <label for="usr">User</label><input type="text" name="usr"/><br/>
                  <label for="pwd">Password</label><input type="text" name="pwd"/><br/>
                  <input type="button" value="Send"><span><a href="Usuario/Registro">Aun no te has registrado?</a></span>
                </fieldset>
              </form>
            </div>
          </ul>
        </div>
      </ul>
    </div>

    <div class="bod">

      <section class="sec sec-white acenter">
        <div class="container">
          <div class="row">
            <div class="col-md-12 pl-20 font-high">
              <h1>Elige uno de los 3 bandos</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/anarchy2.png'/>" data-toggle="modal" data-target="#basicModal">
              <h1>Anarquía</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/edificio2.png'/>" data-toggle="modal" data-target="#basicModal">
              <h1>Centro</h1>
            </div>
            <div class="col-md-4 obj">
              <img src="<c:url value='/resources/img/corona2.png'/>" data-toggle="modal" data-target="#basicModal">
              <h1>Derecha</h1>
            </div>
          </div>
        </div>
      </section>
        
      <div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">Formulario de registro</h4>
            </div>
            <div class="modal-body">
            <form action="/GovernmentWars/Usuario/Registrar" method="get">
              <div class="input-group marginsm">
                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                <input class="form-control" type="text" placeholder="Usuario" name="usuario" id="usuario">
              </div>
              <div class="input-group marginsm">
                <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                <input class="form-control" type="password" placeholder="Contraseña" name="password" id="password">
              </div>
              <div class="input-group marginsm">
                <button type="submit" class="btn btn-default" id="registrar">Crear cuenta</button>
                <input type="hidden" id="rz" name="raza" value=""/>
              </div>
              </form>
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
</script>

  
<script>
  var raza;
  
  $(".obj img[src*=2]").click(function(event) {
	  raza = $(this).attr("src").replace("2","");
	  if (raza.indexOf('anarchy')!=-1)
		  raza = 'Anarquista';
	  else if (raza.indexOf('edificio')!=-1)
		  raza = 'Socialdemocrata';
	  else if (raza.indexOf('corona')!=-1)
		  raza = 'Liberal';
	  
	  $("#rz").val(raza);
  });
</script>


</body>

</html>