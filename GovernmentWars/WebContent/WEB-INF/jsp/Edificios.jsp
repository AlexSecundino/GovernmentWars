<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="base.jsp" />
<c:forEach items ="${edificios}" var="edificio">
<div class="row">
	<div class="itm first-1">
		<div class="row">
	    		<div class="col-md-6">
					<div class="ccdd">
						<h1>${edificio.getNombre()} nivel ${edificio.getNivel()}</h1>
						<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
				    </div>
				</div> 
	    		<div class="col-md-6">
	    			<div class="ccdd2">
	    				<p>Como la madriguera para los conejos, el nido para los pájaros y la caja de cartón para los
							gusanos de seda, la sede lo es para los políticos. Es el centro neurológico de tu partido. Allí se 
							toman todas las órdenes que le llevarán al Gobierno o le sumirán en el más profundo de los 
							olvidos. Es el edificio más importante ya que desde allí conseguirás los militantes necesarios 
							para conseguir un ejecito de políticos que haga templar a tus enemigos.</p>
	    			</div>
	    		</div>
	    </div>
	    <div class="row">
	    		<div class="col-md-6">
	    			<div class="recurses">
		    			<c:forEach items="${edificio.getRecursos()}" var="recurso">
							<span class="rcr"><i class="fa fa-diamond"></i><span>${recurso.value}</span></span>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-6">
					<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm" id="${edificio.getNombre()}&${edificio.getNivel()}">Subir nivel</a>
				</div>
	   	</div>
	   	<div style="clear:both"></div>
	</div>
</div>
</c:forEach>

</div>
</div>
</div>
</div>
</div>


<script>
var edificio;
var nivel;
var sobres;
var antena;
var jueces;
var militantes;
var corrupcion;
var sbm = $('.sbm');
var e;

for (var i=0; i<sbm.length; i++)
	sbm[i].addEventListener('click',inicializar,false);

  
  function inicializar(evento) {
   if (document.readyState == 'complete') {
	sobres = $('#number2').html();
    antena = $('#number1').html();
	jueces = $('#number3').html();
	militantes = $('#number4').html().substring(0, $('#number4').html().length-4);
	corrupcion = $('#number5').html().substring(0, $('#number4').html().length-6);
	e = evento.target.id.split('&');
	edificio = e[0];
	nivel = e[1];
	ajax();
   }
  }
  
  function ajax() {
	console.log(edificio);
	console.log(nivel);
	console.log(sobres);
	console.log(antena);
	console.log(jueces);
	console.log(militantes);
	console.log(corrupcion);
	//env.disabled = true;
    //xhr = new XMLHttpRequest();
    //xhr.addEventListener('readystatechange', gestionarRespuesta, false);
    //xhr.open('get', "/GovernmentWars/Ajax/ColaEdificio?usuario=" + usuario.value + "&password=" + password.value, true);
    //xhr.send(null);
  }
  
/*
  function gestionarRespuesta(evento){
   if (evento.target.readyState == 4 && evento.target.status == 200) {
    login.disabled = false;
    
    if(evento.target.responseText == "true"){
     
    }
    else{
     alert('Ocurrió un error');
    }
   }
  }
  */
</script>
<!-- 

<td>${edificio.formatearTiempo(edificio.getTiempoConstruccion())}</td>
	             
	             <td>
		             <c:if test="${edificio.getNivel() >= 10}">
		             	Nivel al maximo
		             </c:if>
		             <c:if test="${edificio.getNivel() < 10}">
		             	<a href="">Aumentar nivel</a>
		             </c:if>
	             </td>
	          </tr>

 -->
<jsp:include page="base.jsp" />
<c:forEach items ="${edificios}" var="edificio">
<div class="row">
	<div class="itm first-1">
		<div class="row">
	    		<div class="col-md-6">
					<div class="ccdd">
						<h1>${edificio.getNombre()} nivel ${edificio.getNivel()}</h1>
						<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
				    </div>
				</div> 
	    		<div class="col-md-6">
	    			<div class="ccdd2">
	    				<p>Como la madriguera para los conejos, el nido para los p�jaros y la caja de cart�n para los
							gusanos de seda, la sede lo es para los pol�ticos. Es el centro neurol�gico de tu partido. All� se 
							toman todas las �rdenes que le llevar�n al Gobierno o le sumir�n en el m�s profundo de los 
							olvidos. Es el edificio m�s importante ya que desde all� conseguir�s los militantes necesarios 
							para conseguir un ejecito de pol�ticos que haga templar a tus enemigos.</p>
	    			</div>
	    		</div>
	    </div>
	    <div class="row">
	    		<div class="col-md-6">
	    			<div class="recurses">
		    			<c:forEach items="${edificio.getRecursos()}" var="recurso">
							<span class="rcr"><i class="fa fa-diamond"></i><span>${recurso.value}</span></span>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-6">
					<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm" id="${edificio.getNombre()}&${edificio.getNivel()}">Subir nivel</a>
				</div>
	   	</div>
	   	<div style="clear:both"></div>
	</div>
</div>
</c:forEach>

</div>
</div>
</div>
</div>
</div>


<script>
var edificio;
var nivel;
var sobres;
var antena;
var jueces;
var militantes;
var corrupcion;
var sbm = $('.sbm');
var e;

for (var i=0; i<sbm.length; i++)
	sbm[i].addEventListener('click',inicializar,false);

  
  function inicializar(evento) {
   if (document.readyState == 'complete') {
	sobres = $('#number2').html();
    antena = $('#number1').html();
	jueces = $('#number3').html();
	militantes = $('#number4').html().substring(0, $('#number4').html().length-4);
	corrupcion = $('#number5').html().substring(0, $('#number4').html().length-6);
	e = evento.target.id.split('&');
	edificio = e[0];
	nivel = e[1];
	ajax();
   }
  }
  
  function ajax() {
	console.log(edificio);
	console.log(nivel);
	console.log(sobres);
	console.log(antena);
	console.log(jueces);
	console.log(militantes);
	console.log(corrupcion);
	//env.disabled = true;
    //xhr = new XMLHttpRequest();
    //xhr.addEventListener('readystatechange', gestionarRespuesta, false);
    //xhr.open('get', "/GovernmentWars/Ajax/ColaEdificio?usuario=" + usuario.value + "&password=" + password.value, true);
    //xhr.send(null);
  }
  
/*
  function gestionarRespuesta(evento){
   if (evento.target.readyState == 4 && evento.target.status == 200) {
    login.disabled = false;
    
    if(evento.target.responseText == "true"){
     
    }
    else{
     alert('Ocurri� un error');
    }
   }
  }
  */
</script>
<!-- 

<td>${edificio.formatearTiempo(edificio.getTiempoConstruccion())}</td>
	             
	             <td>
		             <c:if test="${edificio.getNivel() >= 10}">
		             	Nivel al maximo
		             </c:if>
		             <c:if test="${edificio.getNivel() < 10}">
		             	<a href="">Aumentar nivel</a>
		             </c:if>
	             </td>
	          </tr>

>>>>>>> refs/heads/master
 -->
