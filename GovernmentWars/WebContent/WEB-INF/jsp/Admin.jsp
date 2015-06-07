<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GovernmentWars || Administrador</title>
	<link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.ico'/>" >
	<script src="<c:url value='/resources/js/countdown.min.js'/>"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" >
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
		        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		            <ul class="nav navbar-nav navbar-right">
		                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
		                    class="fa fa-user"></span> ${usuario.getUsuario()} <b class="caret"></b></a>
		                    <ul class="dropdown-menu">
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
	   				<div class="col-md-12 nopad">
	   					<div class="container">
		   					<div class="row">
								<div class="itm first-1">
									<div class="row">
		   							<div class="col-md-12">
										<h1>Estadisticas del servidor</h1>	
										<ul>
												<c:forEach items="${estadisticas}" var="stat">	
													<td>${stat.key}: ${stat.value}%</td>
												</c:forEach>
										</ul>
									
										<h1>Listado de usuarios</h1>	
										<table>
											<tr>
												<th>Usuario</th>
												<th>Faccion</th>
												<th>Bloquear</th>
											</tr>	
											<c:forEach items ="${listaUsuarios}" var="usuario">
												<tr>
													<td>${usuario.getUsuario()}</td>
													<td>${usuario.getFaccion()}</td>
													<c:if test="${usuario.getBloqueado() == false}">
														<td><a href="/GovernmentWars/Admin/Bloquear?usuario=${usuario.getUsuario()}">Bloquear</a></td>
													</c:if>
													<c:if test="${usuario.getBloqueado() == true}">
														<td><a href="/GovernmentWars/Admin/Desbloquear?usuario=${usuario.getUsuario()}">Desbloquear</a></td>
													</c:if>
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
</div>

<script>
<c:if test="${bloqueado == true}">
alert('Se ha bloqueado correctamente');
</c:if>
<c:if test="${desbloqueado == true}">
alert('Se ha desbloqueado correctamente');
</c:if>
</script>
</body>
</html>
<!-- 
</head>
<body>

	<c:if test="${bloqueado == true}">
		<p>Se ha bloqueado correctamente</p>
	</c:if>
	<c:if test="${desbloqueado == true}">
		<p>Se ha desbloqueado correctamente</p>
	</c:if>
	

	<p>Estadisticas del servidor</p>

	<ul>
			<c:forEach items="${estadisticas}" var="stat">	
				<td>${stat.key}: ${stat.value}%</td>
			</c:forEach>
	</ul>

	<p>Listado de usuarios</p>
	
	<table>
	
		<tr>
			<th>Usuario</th>
			<th>Faccion</th>
			<th>Bloquear</th>
		</tr>
		
		<c:forEach items ="${listaUsuarios}" var="usuario">

			<tr>
				<td>${usuario.getUsuario()}</td>
				<td>${usuario.getFaccion()}</td>
				<c:if test="${usuario.getBloqueado() == false}">
					<td><a href="/GovernmentWars/Admin/Bloquear?usuario=${usuario.getUsuario()}">Bloquear</a></td>
				</c:if>
				<c:if test="${usuario.getBloqueado() == true}">
					<td><a href="/GovernmentWars/Admin/Desbloquear?usuario=${usuario.getUsuario()}">Desbloquear</a></td>
				</c:if>
				
			</tr>
	    	
		</c:forEach>
	</table>

</body>
</html>
 -->