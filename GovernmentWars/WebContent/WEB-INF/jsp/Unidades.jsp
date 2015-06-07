<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<script>	
	
		function crearUnidad(u){
			unidad = u;
			cantidad = document.getElementById(unidad).value;
			
			if(u != "" && (cantidad != "" || cantidad > 0)){
				ajax();
				
			}
			else{
				alert("inserte una cantidad valida (n>0)");
			}
			
		}
	</script>
	
<jsp:include page="base.jsp" />
<c:forEach items ="${unidades}" var="unidad">
<div class="row">
	<div class="itm first-1">
		<div class="row">
	    		<div class="col-md-6">
					<div class="ccdd">
						<h1>${unidad.getNombre()}</h1>
						<c:choose>
    						<c:when test="${unidad.getNombre() == 'Repartepanfletos'}">
    							<img src="<c:url value='/resources/img/repartepanfletos.png'/>" alt="">
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Diputado'}">
    							<img src="<c:url value='/resources/img/diputado.png'/>" alt="">
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Ministro'}">
    							<img src="<c:url value='/resources/img/ministro.png'/>" alt="">
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Antidisturbios'}">
    							<img src="<c:url value='/resources/img/antidisturbios.png'/>" alt="">
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Empresario'}">
    							<img src="<c:url value='/resources/img/empresario.png'/>" alt="">
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Perroflauta'}">
    							<img src="<c:url value='/resources/img/perroflauta.png'/>" alt="">
    						</c:when>
						</c:choose>    
				    </div>
				</div> 
	    		<div class="col-md-6">
	    			<div class="ccdd2np">
	    				<h2>A${unidad.getAtaque()}/V${unidad.getSpeed()}/D${unidad.getDefensa()}/C${unidad.getCapacidad()}</h2>
	    				<c:choose>
    						<c:when test="${unidad.getNombre() == 'Repartepanfletos'}">
    							<p>Por algún lado se empieza, y en la política este lado se trata de patearte las
								calles colgando carteles de tu partido, entregando panfletos a los viandantes, pegando 
								pegatinas con el logo al que te ha decidido a representar y asistiendo a mítines, a muchos 
								mítines en los que debes aplaudir muchas veces. Vamos, que es como ir de público a un 
								programa sensacionalista de televisión pero sin que te paguen por ello. Mira el lado positivo, el 
								comienzo es bajo, pero a medida que subas solo puedes caer aún más.</p>
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Diputado'}">
    							<p>¡Enhorabuena! Has conseguido, un puesto en el congreso. Por fin puedes relajarte
								un poco y calentar esa silla tan cómoda con tu nombre, votar medidas absurdas que os 
								permitan a ti y a los tuyos más inmunidad judicial, echar placenteras siestas en tu horario 
								laboral y en definitiva, vivir la vida padre. Si tienes suerte, quizás tu partido consiga colocarse 
								en el poder, por lo que te interesa cultivar buenas relaciones con tus compañeros y la cúpula 
								con el fin de que, llegado el caso, puedas ocupar un puesto de ministro y poder echar mano a 
								ese suculento sueldo vitalicio. Mmmmmm, rico, rico.</p>
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Ministro'}">
    							<p>Estás en la cúspide, la costosa campaña que obligó a tu partido a endeudarse de por
								vida con diferentes entidades bancarias ha dado sus frutos y gracias a ello ya no tendrás que 
								trabajar más en tu vida. Tendrás un equipo que haga las cosas tediosas por ti, firmarás 
								lucrativas concesiones a diferentes empresas, decidirás sobre el futuro de la plebe… ¿Es que 
								acaso se puede pedir más? Tan solo el dios al que reces y el presidente de gobierno te pueden 
								chistar, al menos hasta que tu partido deje el poder, en cuyo caso te habrán quedado varios 
								puestos como consejero en diferentes empresas energéticas, que sumados a tu pensión 
								vitalicia hará las delicias de tu jubilación.</p>
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Antidisturbios'}">
    							<p>Golpea, golpea, no preguntes, golpea, obedece, golpea, no cuestiones la
								moralidad de tus actos, golpea y si en algún momento dudas de tu cometido, golpea y golpea. 
								Eres la fuerza del estado, estás entrenado en protocolos de control de masas y detención que 
								el resto de fuerzas de seguridad del estado no lo están. Tu labor es minimizar el riesgo civil en 
								tus actuaciones mientras ejecutas el protocolo… ¿A quien leches le importa? Tú lo que quieres 
								es fracturar cráneos, partir brazos y demostrar tu autoridad y no vas a dejar que unos 
								protocolillos te lo impidan. ¿Y qué si te cargas a algún ciudadano? No tienen manera de saber 
								que has sido tú, así que ya sabes. ¡Expláyate!</p>
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Empresario'}">
    							<p>El dinero lo es todo. Sabes que el mundo está repleto de gente como tú y que
								pelea por el primer puesto en el mismo sector en el que tu empresa se mueve. Pisa cabezas, 
								denuncia, consigue concesiones de ministros y otros puestos del gobierno, trata de que no te 
								relacionen con los negocios más turbios que tu empresa lleva (fabricación de armas con 
								explotación infantil, desarrollo de cosméticos con experimentación en animales…) y sí con los 
								que tu madre se sentiría orgullosa de mencionar a las vecinas (ONG, embasado de productos 
								alimenticios, cultivo de espárragos…) y sobre cuida tu contabilidad oculta, que no acabe en 
								manos de quien no debe.</p>
    						</c:when>
    						<c:when test="${unidad.getNombre() == 'Perroflauta'}">
    							<p>¿Ilusionado por estar luchando por los derechos sociales, animales y
								homosexuales? ¿Estás deseando que el mundo de un giro de 180 grados y comencemos a 
								respetar el medioambiente y que las guerras queden totalmente abolidas?  ¿La chica guapa o 
								el chico buenorro de tu clase son un combativo o una reaccionaria y quieres llamar su 
								atención? ¡Claro que sí! Sabes que estás luchando por un futuro mejor y eso te da fuerzas 
								para, junto con un grupo de miles de personas que piensan como tú, tomar las calles y 
								megáfono en mano gritar las consignas más garbosas que hayan podido ocurrírsele al tipo más 
								colocado y que peor huele de la manifestación.</p>
    						</c:when>
						</c:choose>
	    			</div>
	    		</div>
	    </div>
	    <div class="row">
	    		<div class="col-md-6">
	    			<div class="recurses">
						<span class="rcr"><i class="fa fa-envelope" title="Sobres"></i><span> ${unidad.getRecurso('Sobres')}</span></span>
						<span class="rcr"><i class="fa fa-bullseye" title="Antena"></i><span> ${unidad.getRecurso('Antena')}</span></span>
						<span class="rcr"><i class="fa fa-gavel" title="Jueces"></i><span> ${unidad.getRecurso('Jueces')}</span></span>
						<span class="rcr"><i class="fa fa-user" title="Militantes"></i><span> ${unidad.getRecurso('Militantes')}</span></span>
					</div>
				</div>
				<div class="col-md-6">
					<c:if test="${unidad.getCumpleRequisitos() == false}">
             			<a href="javascript:void(0)" class="btn btn-primary btn-lg dsb" id="${unidad.getNombre()}" title="${unidad.getRequisitos()}">No cumples los requisitos</a>
             		</c:if>
             		<c:if test="${unidad.getCumpleRequisitos() == true}">
             			<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm" id="${unidad.getNombre()}&${unidad.formatearTiempo(unidad.getTiempoConstruccion())}&${edificio.getRecurso('Sobres')}&${edificio.getRecurso('Antena')}&${edificio.getRecurso('Jueces')}">Crear unidad</a><input style="width: 300px; margin-top: 1px; border: none; 
             			border-bottom: 1px solid #bbb; text-align: center; font-size: 20px; font-family: 'troika';;" type="number" name="howm" min="1" max="9999" size="4" 
             			placeholder="...Cantidad..."/>
             		</c:if>
             		<a href="javascript:void(0)" class="btn btn-primary btn-lg tiempoq" disabled="disabled">${unidad.formatearTiempo(unidad.getTiempoConstruccion())}</a>
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
</div>
</div>

<script>
var unidad;
var tiempo;
var cantidad;
var sobres;
var pr_sobres;
var antena;
var pr_antena;
var jueces;
var pr_jueces;
var militantes;
var corrupcion;
var sbm = $('.sbm');
var e;

for (var i=0; i<sbm.length; i++)
	sbm[i].addEventListener('click',inicializar,false);


if (localStorage.getItem('${usuario.getUsuario()}_tmp_unidad')!==null) {
	for (var i=0; i<sbm.length; i++) {
		sbm[i].removeEventListener('click',inicializar);			
	$('.sbm').html("Ya hay unidades en la cola.");
	$('.sbm').siblings('input').attr("disabled", "disabled");
	$('.sbm').addClass("dsb");
	$('.sbm').removeClass("sbm");
	}
}
  
  function inicializar(evento) {
   if (document.readyState == 'complete') {
	sobres = $('#number1').html();
    antena = $('#number2').html();
	jueces = $('#number3').html();
	militantes = $('#number4').html().substring(0, $('#number4').html().length-4);
	corrupcion = $('#number5').html().substring(0, $('#number4').html().length-6);
	e = evento.target.id.split('&');
	unidad = e[0];
	cantidad = $(this).siblings('input').val();
	tiempo = e[1];
	pr_sobres = e[2]
	pr_antena = e[3]
	pr_jueces = e[4]
	ajax();
   }
  }
 
  function ajax() {
		var parametros = {"unidad" : unidad,"cantidad" : cantidad, "sobres" : sobres, "antena" : antena, "jueces" : jueces, "militantes" : militantes};
		console.log(parametros);
    	$.ajax({
      	data:  parametros,
          url:   '/GovernmentWars/Ajax/ColaUnidad',
          type:  'post',
          success:  function (response) {
          	console.log(response);
          	if (response == 'true') {
          		
          		tiempo = tiempo.split(':');
          		
          		console.log('TIEMPO QUE TARDA:');
          		console.log(tiempo);
          		if (tiempo.length == 3) {
          			console.log('Sin la d');
          			var h = tiempo[0].substring(tiempo[0],tiempo[0].length-1);
          			var m = tiempo[1].substring(tiempo[1],tiempo[1].length-1);
          			var s = tiempo[2].substring(tiempo[2],tiempo[2].length-1);
          		} else if (tiempo.length == 4) {
          			console.log('Con la d');
          			var d = tiempo[0].substring(tiempo[0],tiempo[0].length-1);
          			var h = tiempo[1].substring(tiempo[1],tiempo[1].length-1);
          			var m = tiempo[2].substring(tiempo[2],tiempo[2].length-1);
          			var s = tiempo[3].substring(tiempo[3],tiempo[3].length-1);
          		}
          		
          		var e = new Date();
          		console.log('ANTES DE LA MOVIDA: '+e);
          		var emas;
          		
          		console.log('PARSEADO: '+h+' '+m+' '+s);
          		
          		for(var i=0; i<cantidad*1; i++) {
          			if (typeof d !== 'undefined')
              			emas = e.setDate(e.getDate() + d*1);
              			
              		if (h!=='0') {
              				emas = e.setHours(e.getHours() + h*1);
              				console.log('suma horas '+emas);
              				e = new Date(emas);
              				console.log('suma horas '+e);
             			}
             			if (m!=='0') {
             				emas = e.setMinutes(e.getMinutes() + m*1);
             				console.log('suma minutos '+emas);
             				e = new Date(emas);
             				console.log('suma minutos '+e);
             			}
             			emas = e.setSeconds(e.getSeconds() + s*1);
             			console.log('suma segundos '+emas);
             			e = new Date(emas);
             			console.log('suma segundos '+e);

              		console.log('DESPUES DE LA MOVIDA: '+e);          			
          		}
          		
          		var cola_unidad = {'nombre': unidad,'cantidad': cantidad, 'tm': e};
          		
          		localStorage.setItem('${usuario.getUsuario()}_tmp_unidad', JSON.stringify(cola_unidad));

          		var object = JSON.parse(localStorage.getItem('${usuario.getUsuario()}_tmp_unidad'));
          		
				document.getElementById('number1').innerHTML = document.getElementById('number1').innerHTML*1 - pr_sobres*1;
	    		document.getElementById('number2').innerHTML = document.getElementById('number2').innerHTML*1 - pr_antena*1;
	    		document.getElementById('number3').innerHTML = document.getElementById('number3').innerHTML*1 - pr_jueces*1;
	    		
	    		location.reload();
          	}
          		
          	else if (response == 'false')
          		alert('no tienes recursos suficientes');
        	}
    	});
	}
  
</script>
</body>
</html>
