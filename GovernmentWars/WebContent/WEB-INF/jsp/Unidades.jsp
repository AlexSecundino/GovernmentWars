<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

	<script>
		var unidad;
		var cantidad;
		var crearUnidad;
		var xhr;
		
		function ajax(evento) {
			xhr = new XMLHttpRequest();
			xhr.addEventListener('readystatechange', gestionarRespuesta, false);
			xhr.open('get', "/GovernmentWars/Ajax/CrearUnidad?unidad=" + unidad + "&cantidad=" + cantidad, true);
			xhr.send(null);
		}
		
		function gestionarRespuesta(evento){
			if (evento.target.readyState == 4 && evento.target.status == 200) {	
				if(evento.target.responseText == "true"){
					alert("creando unidades...");
				}
				else{
					alert(evento.target.responseText);	
				}
			}
		}
	
	
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
						<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
				    </div>
				</div> 
	    		<div class="col-md-6">
	    			<div class="ccdd2np">
	    				<h2>${unidad.getAtaque()}/${unidad.getSpeed()}/${unidad.getDefensa()}/${unidad.getCapacidad()}</h2>
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
             			<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm" id="${unidad.getNombre()}">Crear unidad</a>
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

</script>

</body>
</html>
