<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GovernmentWars</title>
	<link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.ico'/>" >
	<script src="<c:url value='/resources/js/countdown.min.js'/>"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" >
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  	<script>
  		$(document).ready(function() {
			$('#lgout').click(function() {
				window.removeEventListener("beforeunload", saveResources);
				sessionStorage.removeItem('recursos');
			});	

  			if (localStorage.getItem("${usuario.getUsuario()}_tmp_edificio") !== null) {
				var tm = JSON.parse(localStorage.getItem("${usuario.getUsuario()}_tmp_edificio"));
				checkTime(tm.tm,'${usuario.getUsuario()}_tmp_edificio');
			}
			
  			if (localStorage.getItem("${usuario.getUsuario()}_tmp_tecnologia") !== null) {
				var tm2 = JSON.parse(localStorage.getItem("${usuario.getUsuario()}_tmp_tecnologia"));
				checkTime(tm2.tm,'${usuario.getUsuario()}_tmp_tecnologia');
			}
  			
  			if (localStorage.getItem("${usuario.getUsuario()}_tmp_unidad") !== null) {
				var tm3 = JSON.parse(localStorage.getItem("${usuario.getUsuario()}_tmp_unidad"));
				checkTime(tm3.tm,'${usuario.getUsuario()}_tmp_unidad');
			}
  			
  			if (sessionStorage.msg == 1)
  				$('.msg').css("color","green");
  			else
  				$('.msg').css("color","#777");
  			
  			
  			if (sessionStorage.getItem('${usuario.getUsuario()}_recursos')!==null) {

				var sm_sobres = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).dsobres;
				var sm_antena = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).dantena;
				var sm_jueces = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).djueces;
  			}
  			else if (sessionStorage.getItem('${usuario.getUsuario()}_recursos')==null){
  				var sm_sobres = 0;
				var sm_antena = 0;
				var sm_jueces = 0;
  			}
  			
  						
			window.setInterval(function(){
				var produccion_sobres = $('.data-get1').attr("id");
				number_sobres = produccion_sobres*1/3600;
				number_sobres += sm_sobres;
				intPart_sobres= getPartNumber(number_sobres,'int',16);
				fracPart_sobres= getPartNumber(number_sobres,'frac',16);
				fracPart_sobres= '0.'+fracPart_sobres;
				number_sobres = 0;
			
				if (intPart_sobres>=1) {
					number_sobres=intPart_sobres;
					sm_sobres=fracPart_sobres;
					sm_sobres=sm_sobres*1;
				}
				
				else {
					sm_sobres=fracPart_sobres*1;
					sm_sobres=sm_sobres*1;
				}
    			document.getElementById('number1').innerHTML = document.getElementById('number1').innerHTML*1+number_sobres;
			}, 1000);
			
			window.setInterval(function(){
				var produccion_antena = $('.data-get2').attr("id");
				number_antena = produccion_antena*1/3600;
				number_antena += sm_antena;
				intPart_antena= getPartNumber(number_antena,'int',16);
				fracPart_antena= getPartNumber(number_antena,'frac',16);
				fracPart_antena= '0.'+fracPart_antena;
				number_antena = 0;
			
				if (intPart_antena>=1) {
					number_antena=intPart_antena;
					sm_antena=fracPart_antena;
					sm_antena=sm_antena*1;
				}
				
				else {
					sm_antena=fracPart_antena*1;
					sm_antena=sm_antena*1;
				}
    			document.getElementById('number2').innerHTML = document.getElementById('number2').innerHTML*1+number_antena;
			}, 1000);
			
			window.setInterval(function(){
				var produccion_jueces = $('.data-get3').attr("id");
				number_jueces = produccion_jueces*1/3600;
				number_jueces += sm_jueces;
				intPart_jueces= getPartNumber(number_jueces,'int',16);
				fracPart_jueces= getPartNumber(number_jueces,'frac',16);
				fracPart_jueces= '0.'+fracPart_jueces;
				number_jueces = 0;
			
				if (intPart_jueces>=1) {
					number_jueces=intPart_jueces;
					sm_jueces=fracPart_jueces;
					sm_jueces=sm_jueces*1;
				}
				
				else {
					sm_jueces=fracPart_jueces*1;
					sm_jueces=sm_jueces*1;
				}
    			document.getElementById('number3').innerHTML = document.getElementById('number3').innerHTML*1+number_jueces;
			}, 1000);
		
					
		
		window.addEventListener("beforeunload", saveResources);

		window.addEventListener("load", function (event) {
			if (sessionStorage.getItem('${usuario.getUsuario()}recursos')!== null) {
				document.getElementById('number1').innerHTML = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).Sobres;
	    		document.getElementById('number2').innerHTML = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).Antena;
	    		document.getElementById('number3').innerHTML = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).Jueces;
	    		document.getElementById('number4').innerHTML = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).Militantes;
	    		document.getElementById('number5').innerHTML = JSON.parse(sessionStorage.getItem('${usuario.getUsuario()}_recursos')).Corrupcion;
			}
			else {
	  			var sm_sobres = 0;
	  			var sm_antena = 0;
	  			var sm_jueces = 0;
			}
				
			event.preventDefault();
		});

		function saveResources() {
			sessionStorage.setItem('${usuario.getUsuario()}_recursos', JSON.stringify({
				'Sobres': document.getElementById('number1').innerHTML*1,
				'dsobres': sm_sobres,
				'Antena': document.getElementById('number2').innerHTML*1,
				'dantena': sm_antena,
				'Jueces': document.getElementById('number3').innerHTML*1,
				'djueces': sm_jueces,
				'Militantes': document.getElementById('number4').innerHTML, 
				'Corrupcion': document.getElementById('number5').innerHTML
			}));
		}
		
		function checkTime(tm,tmp_c) {
    		window.setInterval(function(){
        		if (new Date() >= new Date(tm)) {
        			window.location.replace("/GovernmentWars/Usuario/Index");
        			if (typeof timerId !== 'undefined') {
        				window.clearInterval(timerId);
        				localStorage.removeItem(tmp_c);
        			}
        			if (typeof timerId2 !== 'undefined') {
        				window.clearInterval(timerId2);
        				localStorage.removeItem(tmp_c);
        			}
        			if (typeof timerId3 !== 'undefined') {
        				window.clearInterval(timerId3);
        				localStorage.removeItem(tmp_c);
        			}
        		}
        			
        	}, 1000);
		}

		function getPartNumber(number,part,decimals) {
  			if ((decimals <= 0) || (decimals == null)) decimals =1;
  				decimals = Math.pow(10,decimals);
  				var intPart = Math.floor(number);
  				var fracPart = (number % 1)*decimals;
  				fracPart = fracPart.toFixed(0);
  			if (part == 'int')
    			return intPart;
  			else
    			return fracPart;
		}

  		});
  	</script>
</head>

<body>
<input type="hidden" class="data-get1" id="${produccion.getRecurso('Sobres')}"></input>
<input type="hidden" class="data-get2" id="${produccion.getRecurso('Antena')}"></input>
<input type="hidden" class="data-get3" id="${produccion.getRecurso('Jueces')}"></input>

<div class="wrap-vg">
	<div class="resources">
	    <nav class="navbar navbar-default" role="navigation">
	        <!-- Brand and toggle get grouped for better mobile display -->
	        <div class="navbar-header">
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span
	                    class="icon-bar"></span><span class="icon-bar"></span>
	            </button>
	        </div>
	        <!-- Collect the nav links, forms, and other content for toggling -->
	        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	            <ul class="nav navbar-nav">
	                <li><a><i class="fa fa-envelope"></i> Sobres <span id="number1">${ciudad.getRecurso("Sobres")}</span></a></li>
	                <li><a><i class="fa fa-bullseye"></i> Antena <span id="number2">${ciudad.getRecurso("Antena")}</span></a></li>
	                <li><a><i class="fa fa-gavel"></i> Jueces<span id="number3">${ciudad.getRecurso("Jueces")}</span></a></li>
	                <li><a><i class="fa fa-users"></i> Militantes<span id="number4">${ciudad.getRecurso("Militantes")}/100</span></a></li>
	                <li><a><i class="fa fa-diamond"></i> Corrupcion <span id="number5">${ciudad.getNivelCorrupcion()} %</span></a></li>
	            </ul>
	            <ul class="nav navbar-nav navbar-right">
					<li><a href="/GovernmentWars/Usuario/Mensajes" class="msg"><i class="fa fa-diamond"></i>Mensajes</a></li>
	                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
	                    class="fa fa-user"></span> ${usuario.getUsuario()} <b class="caret"></b></a>
	                    <ul class="dropdown-menu">
	                        <li><a href="/GovernmentWars/Usuario/Perfil"><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
	                        <li class="divider"></li>
	                        <li><a href="/GovernmentWars/Usuario/Logout" id="lgout"><span class="glyphicon glyphicon-off"></span> Desconectarse</a></li>
	                    </ul>
	                </li>
	            </ul>
	        </div>
	    </nav>
	</div>
	<div class="bod">	
		<div class="container">
			<div class="row">
    			<div class="col-md-3">
	    			<div class="nav-left">
				    	<ul class="aside-menu">
				    		<li><a href="/GovernmentWars/Usuario/Index">Vision general</a></li>
				    		<li><a href="/GovernmentWars/Juego/Edificios">Edificios</a></li>
				    		<li><a href="/GovernmentWars/Juego/Unidades">Unidades</a></li>
				    		<li><a href="/GovernmentWars/Juego/Tecnologias">Tecnologias</a></li>
				    		<li><a href="/GovernmentWars/Juego/Mapa">Mapa</a></li>
				    		<li><a href="/GovernmentWars/Juego/Historial">Historial de ataques</a></li>
				    	</ul>
	    			</div>
   				</div>
   				<div class="col-md-9 nopad">
   					<div class="container">
