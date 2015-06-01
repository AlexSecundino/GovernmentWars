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
	    				<c:choose>
    						<c:when test="${edificio.getNombre() == 'Sede'}">
    							<p>Como la madriguera para los conejos, el nido para los pájaros y la caja de cartón para los
								gusanos de seda, la sede lo es para los políticos. Es el centro neurológico de tu partido. Allí se 
								toman todas las órdenes que le llevarán al Gobierno o le sumirán en el más profundo de los 
								olvidos. Es el edificio más importante ya que desde allí conseguirás los militantes necesarios 
								para conseguir un ejecito de políticos que haga templar a tus enemigos.</p>
    						</c:when>
    						<c:when test="${edificio.getNombre() == 'Juzgado'}">
    							<p>Y aquí se eligen a los futuros jueces de tu país. Mejor pescarlos jovencitos y
								ambiciosos y así tendrás fieles aliados de por vida y que desestimarán los casos contra tu 
								partido y cerraran investigaciones destinadas a encontrar irregularidades. ¿No es una maravilla 
								lo que ocurre cuando el poder Legislativo y el Judicial son así de amigos? Cuida de tus jueces y 
								ellos cuidarán de ti manteniendo a tu gente tan limpia y fresca como una colada recien hecha.</p>
    						</c:when>
    						<c:when test="${edificio.getNombre() == 'TV'}">
    							<p>Si quieres que los oscuros secretos de tu partido no salgan a la luz, o si
								necesitas contradecir los descubrimientos sobre tu partido que están emitiendo en televisión 
								necesitas tener una cadena en el bolsillo. La imagen de tu partido lo es todo, por lo que dejar 
								que te la enturbien se traduce en una pérdida de botos. Paga bien y tendrás a un ferreo 
								defensor cada vez que una conversación que creías privada ya no lo sea y se encuentre apunto 
								de echar por tierra todas esas promesas absurdas que tanto os costó pensar para engañar a los 
								electores.</p>
    						</c:when>
    						<c:when test="${edificio.getNombre() == 'Banco'}">
    							<p>Empapelar la ciudad con el rostro de tu candidato no es precisamente barato, ni
								anunciar a tu partido en las cadenas que no son de tu propiedad tampoco. Para ello debes 
								recurrir a un amigo altruista llamado “Entidad” y apellidado “Bancaria”, que 
								desinteresadamente te prestará ese dinero sin pedirte nada a cambio, bueno, sin pedirte nada 
								a cambio salvo que consigas gobernar, llegado el caso tendrás que hacer unas pequeñas 
								concesiones para favorecerla. Pero en este tipo de cosas nadie pierde, ya sabes.</p>
    						</c:when>
						</c:choose>
	    			</div>
	    		</div>
	    </div>
	    <div class="row">
	    		<div class="col-md-6">
	    			<div class="recurses">
	    				<span class="rcr"><i class="fa fa-diamond"></i><span>${edificio.getRecurso('Sobres')}</span></span>
						<span class="rcr"><i class="fa fa-diamond"></i><span>${edificio.getRecurso('Antena')}</span></span>
						<span class="rcr"><i class="fa fa-diamond"></i><span>${edificio.getRecurso('Jueces')}</span></span>
					</div>
				</div>
				<div class="col-md-6">
					<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm" id="${edificio.getNombre()}&${edificio.getNivel()}&${edificio.formatearTiempo(edificio.getTiempoConstruccion())}">Subir nivel</a>
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
var tiempo;
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
	tiempo = e[2];
	ajax();
   }
  }
 
	function ajax() {
  		var parametros = {"edificio" : edificio,"nivel" : nivel, "sobres" : sobres, "antena" : antena, "jueces" : jueces};
  		console.log(parametros);
      	$.ajax({
        	data:  parametros,
            url:   '/GovernmentWars/Ajax/ColaEdificio',
            type:  'get',
            success:  function (response) {
            	console.log(response);
            	if (response == 'true')
            		console.log('Esto al contador: '+tiempo);
            	else if (response == 'false')
            		alert('no tienes recursos suficientes');
          	}
      	});
	}
  
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
