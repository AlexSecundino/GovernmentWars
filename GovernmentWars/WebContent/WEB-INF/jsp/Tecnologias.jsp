<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="base.jsp" />
<c:forEach items ="${tecnologias}" var="tecnologia">
<div class="row">
	<div class="itm first-1">
		<div class="row">
	    		<div class="col-md-6">
					<div class="ccdd">
						<h1>${tecnologia.getNombre()}</h1>
						<img src="<c:url value='/resources/img/edif.jpg'/>" alt="">     
				    </div>
				</div> 
	    		<div class="col-md-6">
	    			<div class="ccdd2">
	    				<c:choose>
    						<c:when test="${tecnologia.getNombre() == 'Maletines con doble fondo'}">
    							<p>¿Nunca ha soñado tener ese espacio tan necesario para guardar lo cobrado en B de manera 
								discreta y elegante? ¡Le presentamos los Maletines de Doble Fondo de Mestafas.SA! Podrá 
								disponer de él en modelo piel de cocodrilo, ante y cuero. ¡No deje pasar la oportunidad, se 
								arrepentirá!</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Diputacion'}">
    							<p>Necesitas de diputados para sembrar el terror entre las filas de tus enemigos dentro de las
								cámaras. Fórmales bien y gástate un poco de dinero en bebidas vigorizantes si no quieres que 
								se te quedan dormidos y salgan de portada en alguna clase de periódico o programa de 
								televisión.</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Ministerio'}">
    							<p>Forma a ministros que sepan ocuparse de los ministerios una vez consigas el poder. Este tipo 
								de formación hace que tus chicos sean lo suficientemente agresivos para propiciarte una 
								subida espectacular en el gran camino que es plantar el culo en la silla de la presidencia del 
								gobierno. Tan solo recuerda especializarlos, no vayas a poner a un ginecólogo en el ministerio 
								de interior o algo similar. Eso podría dar imagen de que ocupas los puestos con gente poco 
								preparada.</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Manifa'}">
    							<p>¡Invéntate un motivo por el que echar a la gente a la calle y se te llenará de hippies porretas 
								dispuestos a agarrar un megáfono para gritar al personal! Una manifestación es caldo de 
								cultivo para partidos como el tuto, tan solo has de saber dirigir su rabia contra el objetivo 
								deseado. Y si lo consigues al menos te habrás echado una cervecitas.</p>
    						</c:when>
    						    <c:when test="${tecnologia.getNombre() == 'Manifa'}">
    							<p>¡Invéntate un motivo por el que echar a la gente a la calle y se te llenará de hippies porretas 
								dispuestos a agarrar un megáfono para gritar al personal! Una manifestación es caldo de 
								cultivo para partidos como el tuto, tan solo has de saber dirigir su rabia contra el objetivo 
								deseado. Y si lo consigues al menos te habrás echado una cervecitas.</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Multinacional'}">
    							<p>Tráete del extranjero alguna de esas grandes empresas que convierten en oro todo lo que
								tocan y tendrás tu futuro asegurado. Pero ya sabes, practica bien tus inclinaciones serviciales, 
								pluma estilográfica preferida y un buen puñado de papeles porque tendrás que otórgales 
								cientos de concesiones. ¿O creáis que el puesto en su empresa cuando salieses de tu puesto 
								político era gratis?</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Multinacional'}">
    							<p>Tráete del extranjero alguna de esas grandes empresas que convierten en oro todo lo que
								tocan y tendrás tu futuro asegurado. Pero ya sabes, practica bien tus inclinaciones serviciales, 
								pluma estilográfica preferida y un buen puñado de papeles porque tendrás que otórgales 
								cientos de concesiones. ¿O creáis que el puesto en su empresa cuando salieses de tu puesto 
								político era gratis?</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Estado Policial'}">
    							<p>¡No permitas que las ovejas se salgan del redil! Si lo haces perderás el control, y toda la 
								sociedad se vendrá abajo en una vorágine de caos, crímenes y terrorismo. Para ello tienes que 
								golpear al que piense de manera independiente. Así que ya sabes, entrena a un cuerpo de 
								antidisturbios que cumplan tus órdenes al pie de la letra y ahí tendrás a tus perros ovejeros.</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Pancartas'}">
    							<p>Hazte con una enorme lona blanca, unos cuantos sprays de pintura que resalte y una 
								desmedida creatividad a la hora de pensar en eslóganes pegadizos. También puedes optar por 
								un poco de contrachapado unido a un palo o por… ¡Da lo mismo, las posibilidades son casi 
								ilimitadas! ¡Hasta puedes usar tu propio cuerpo para difundir el mensaje subversivo que 
								desees!</p>
    						</c:when>
    						<c:when test="${tecnologia.getNombre() == 'Lanzapelotas'}">
    							<p>¿Tienes ganas de practicar el tiro al blanco pero las dianas se te hacen demasiado aburridas?
								¿Llevas toda la vida empuñando un arma de fuego deseando que alguien te diese un motivo 
								para dispararla y jamás has tenido la suerte de que ocurriese? ¿Odias a todos esos perroflautas 
								que están delante de ti que te dan tanto asco como para no querer acercarte a pegarles con la 
								porra? ¡Ahora tienes la solución! ¡Dispárales con pelotas de goma y verás cómo se retuercen 
								de dolor! Garantizado.</p>
    						</c:when>
    						
						</c:choose>
	    			</div>
	    		</div>
	    </div>
	    <div class="row">
	    		<div class="col-md-6">
	    			<div class="recurses">
						<span class="rcr"><i class="fa fa-diamond"></i><span>${tecnologia.getRecurso('Sobres')}</span></span>
						<span class="rcr"><i class="fa fa-diamond"></i><span>${tecnologia.getRecurso('Antena')}</span></span>
						<span class="rcr"><i class="fa fa-diamond"></i><span>${tecnologia.getRecurso('Jueces')}</span></span>
					</div>
				</div>
				<div class="col-md-6">
					<c:if test="${tecnologia.getCumpleRequisitos() == false}">
             			<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm dsb" id="${tecnologia.getNombre()}" title="${tecnologia.getRequisitos()}">No cumples los requisitos</a>
             		</c:if>
             		<c:if test="${tecnologia.getCumpleRequisitos() == true}">
             			<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm" id="${tecnologia.getNombre()}}">Investigar</a>
             		</c:if>
					<c:if test="${tecnologia.isInvestigada() == true}">
             			<a href="javascript:void(0)" class="btn btn-primary btn-lg sbm dsb" id="${tecnologia.getNombre()}}">Ya se ha investigado</a>
             		</c:if>
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
	
</script>
<!-- 


			<c:if test="${tecnologia.isInvestigada() == true}">
             	<p>Ya se ha investigado</p>
             </c:if>
 -->