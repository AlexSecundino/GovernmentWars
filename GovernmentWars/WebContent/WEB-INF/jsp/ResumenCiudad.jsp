
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="base.jsp" />
<div class="row">
<div class="itm first-1">
	<h1 id='cmb'>${ciudad.getNombre()}</h1>
	<input id='hdn'></input>
	<div>
		<div style="float:left; padding-right: 120px">
			<h2>Produccion</h2>
				<p>Antena: ${produccion.getRecurso("Antena")}/h</p>
				<p>Sobres: ${produccion.getRecurso("Sobres")}/h</p>
				<p>Jueces: ${produccion.getRecurso("Jueces")}/h</p>
		</div>
		
		<div style="float:left">
			<h2>Lista de unidades</h2>
			<c:forEach items ="${unidadesCiudad}" var="unidad">
		          <p id="${unidad.getNombre()}">${unidad.getCantidad()} - ${unidad.getNombre()}</p>
		    </c:forEach>
		</div>
		<div style="clear:both"></div>
	</div>
	<div></div>
</div>

</div>
</div>
</div>
</div>
</div>
</div>

<script>
<c:if test="${nuevoMensaje == true}">
	$('.msg').css("color","green");
	sessionStorage.msg = 1;
</c:if>
<c:if test="${nuevoLogAtaque == true}">
	alert('nuevo log ataque!!!');
</c:if>

$('#cmb').dblclick(function(){
    $('#hdn').show(); 
    $('#hdn').focus();
    this.style.display = "none";
    $('#hdn').val(this.innerHTML);
    
    $('#hdn').keydown(function(e) {
	    if (e.keyCode == 13) {
	    	var antiguoNombre = $('#cmb').html(); 
	        $('#cmb').html(this.value);
	        $('#hdn').css("display","none");
	        $('#cmb').css("display","block");
	        cambiarNombre(antiguoNombre,$('#cmb').html());
	    }
	});
});

function cambiarNombre(antiguoNombre,nuevoNombre){
var parametros = {"antiguoNombre" : antiguoNombre,"nombre" : nuevoNombre};
console.log(parametros);  
    $.ajax({
            data:  parametros,
            url:   '/GovernmentWars/Ajax/CambiarNombreCiudad',
            type:  'get',
            success:  function (response) {
            	alert(response);
        }
    });
}
</script>
