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