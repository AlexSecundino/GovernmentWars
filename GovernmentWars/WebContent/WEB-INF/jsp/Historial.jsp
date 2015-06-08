<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<jsp:include page="base.jsp" />
	<div class="row">
		<div class="itm first-1 datagrid">
			<table class="tbl">
				<tr>
					<th>A</th>
					<th>D</th>
					<th>T.Enviadas</th>
					<th>T.PerdidasA</th>
					<th>T.Defendiendo</th>
					<th>T.PerdidasD</th>
					<th>B</th>
					<th>Fecha Ataque</th>
				</tr>
				
				<c:forEach items ="${listaLogAtaques}" var="log">
					<tr>
						<td>${log.getAtacante()} from ${log.getnCiudadAtacante()}</td>
						<td>${log.getDefensor()} from ${log.getnCiudadDefensor()}</td>	
						<td>${log.getnTropasEnviadas()}</td>
						<td>${log.getnTropasPerdidasAtacante()}</td>
						<td>${log.getnTropasDefensor()}</td>
						<td>${log.getnTropasPerdidasDefensor()}</td>		
						<td>${log.getRecurso('Sobres')}:${log.getRecurso('Antena')}:${log.getRecurso('Jueces')}</td>			
						<td>${log.getFechaAtaque()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>

<!-- 
						<c:if test="${log.isLeido() == true}">
					            <td>Ya lo has leido :D</td> 	
					    </c:if>
						<c:if test="${log.isLeido() == false}">
					            <td>Puto afk leelo</td> 	
					    </c:if>
 -->
