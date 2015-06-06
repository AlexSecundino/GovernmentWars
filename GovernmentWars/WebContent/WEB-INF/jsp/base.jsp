<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
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
  			
  			if (localStorage.getItem("tmp_edificio") !== null) {
				var tm = JSON.parse(localStorage.getItem("tmp_edificio"));
				checkTime(tm.tm,'tmp_edificio');
			}
			
  			if (localStorage.getItem("tmp_tecnologia") !== null) {
				var tm = JSON.parse(localStorage.getItem("tmp_tecnologia"));
				checkTime(tm.tm,'tmp_tecnologia');
			}
  			
  			if (sessionStorage.msg == 1)
  				$('.msg').css("color","green");
  			else
  				$('.msg').css("color","#777");
  			
  			if (typeof sm == 'undefined') {
  				var sm = 0;
  			}
  			
			var timer = window.setInterval(function(){
			number = 1200/3600;
			number += sm;
			intPart= getPartNumber(number,'int',16);
			fracPart= getPartNumber(number,'frac',16);
			fracPart= '0.'+fracPart;
			number = 0;
			if (intPart>=1) {
				number=intPart;
				sm=fracPart;
				sm=sm*1;
			}
			else {
				sm=fracPart*1;
				sm=sm*1;
			}
    		document.getElementById('number1').innerHTML = document.getElementById('number1').innerHTML*1+number;
    		document.getElementById('number2').innerHTML = document.getElementById('number2').innerHTML*1+number;
    		document.getElementById('number3').innerHTML = document.getElementById('number3').innerHTML*1+number;	
		}, 1000);
		
					
		window.addEventListener("beforeunload", saveResources);
		
		window.addEventListener("load", function (event) {
			if (sessionStorage.getItem('recursos')!== null) {
				document.getElementById('number1').innerHTML = JSON.parse(sessionStorage.getItem('recursos')).Sobres;
	    		document.getElementById('number2').innerHTML = JSON.parse(sessionStorage.getItem('recursos')).Antena;
	    		document.getElementById('number3').innerHTML = JSON.parse(sessionStorage.getItem('recursos')).Jueces;
	    		document.getElementById('number4').innerHTML = JSON.parse(sessionStorage.getItem('recursos')).Militantes;
	    		document.getElementById('number5').innerHTML = JSON.parse(sessionStorage.getItem('recursos')).Corrupcion;
			}
			event.preventDefault();
		});
			
		function saveResources() {
			sessionStorage.setItem('recursos', JSON.stringify( {'Sobres': document.getElementById('number1').innerHTML*1+1, 
				'Antena': document.getElementById('number2').innerHTML*1+1, 'Jueces': document.getElementById('number3').innerHTML*1+1, 'Militantes': document.getElementById('number4').innerHTML, 
				'Corrupcion': document.getElementById('number5').innerHTML} ));
		}
		
		
		function checkTime(tm,tmp_c) {
    		window.setInterval(function(){
        		if (new Date() >= new Date(tm)) {
        			window.location.replace("/GovernmentWars/Usuario/Index");
        			if (typeof timerId !== 'undefined') {
        				window.clearInterval(timerId);
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

			//2000recursos/hora. * 1hora/3600 segundos.  2000/3600

  		});
  	</script>
</head>

<body>
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
	                    class="fa fa-diamond"></span>${usuario.getUsuario()} <b class="caret"></b></a>
	                    <ul class="dropdown-menu">
	                        <li><a href="/GovernmentWars/Usuario/Perfil"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
	                        <li class="divider"></li>
	                        <li><a href="/GovernmentWars/Usuario/Logout" id="lgout"><span class="glyphicon glyphicon-off"></span>Logout</a></li>
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
