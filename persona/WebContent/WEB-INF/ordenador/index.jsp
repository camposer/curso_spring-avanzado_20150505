<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comun.jsp" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ordenadores</title>
	<style>
		h1 {
			text-align: center;
		}
		.tabla-centrada {
			margin-left: auto;
			margin-right: auto;
		}
		#form-persona tr:last-child td {
			text-align: center;
		}
		#tabla-persona td:nth-child(4),
		#tabla-persona td:nth-child(5),
		#tabla-persona td:nth-child(6) {
			text-align: center;
		}
		#tabla-persona a {
			color: black;
		}
		#tabla-persona th {
			background-color: gray;
		}
		#tabla-persona tr:nth-child(odd) td {
			background-color: lightgray;
		}
		#tabla-persona tr:nth-child(even) td {
			background-color: darkgray;
		}
		.errores {
			background-color: red;
			color: white;
		}
	</style>
</head>
<body>
	<h1>Ordenadores</h1>
	
	<form:form commandName="ordenadorForm" method="post" action="${contextPath}/ordenador/guardar.do">
		<form:errors path="*" cssClass="errores tabla-centrada"/>
		
		<form:hidden path="id"/>
		<table id="form-persona" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td>Serial</td>
				<td><form:input path="serial"/></td>
			</tr>
			<tr>
				<td>Dueño</td>
				<td>
					<select name="personaId">
						<c:forEach var="p" items="${personas}">
							<option value="${p.id}" ${(ordenadorForm.personaId == p.id) ? 'selected' : ''}>${p.nombreCompleto}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">		
					<form:button>Guardar</form:button>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<table id="tabla-ordenador" class="tabla-centrada">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Serial</th>
			<th>Dueño</th>
			<th>Mostrar</th>
			<th>Eliminar</th>
		</tr>
		<c:forEach var="o" items="${ordenadores}">
			<tr>
				<td>${o.id}</td>
				<td>${o.nombre}</td>
				<td>${o.serial}</td>
				<td>${o.persona.nombreCompleto}</td>
				<td><a href="${contextPath}/ordenador/mostrar.do?id=${o.id}">mostrar</a></td>
				<td><a href="${contextPath}/ordenador/eliminar.do?id=${o.id}">eliminar</a></td>
			</tr>	
		</c:forEach>
	</table>
	
	
</body>
</html>