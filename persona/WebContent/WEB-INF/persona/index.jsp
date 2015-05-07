<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comun.jsp" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
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
	<h1>Personas</h1>
	<div class="errores tabla-centrada">
		<c:forEach var="e" items="${errores}">
			${e}<br>
		</c:forEach>
	</div>
	<form action="${contextPath}/persona/guardar.do" method="post">
		<input type="hidden" name="personaId" value="${persona.id}">
		<table id="form-persona" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" value="${persona.nombre}"></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type="text" name="apellido" value="${persona.apellido}"></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td><input type="text" name="fechaNacimiento" value="${persona.fechaNacimiento}"></td>
			</tr>
			<tr>
				<td colspan="2">		
					<input type="submit" value="Guardar">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<table id="tabla-persona" class="tabla-centrada">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Mostrar</th>
			<th>Eliminar</th>
		</tr>
		<c:forEach var="p" items="${personas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.apellido}</td>
				<td>${p.fechaNacimiento}</td>
				<td><a href="${contextPath}/persona/mostrar.do?id=${p.id}">mostrar</a></td>
				<td><a href="${contextPath}/persona/eliminar.do?id=${p.id}">eliminar</a></td>
			</tr>	
		</c:forEach>
	</table>
	
	
</body>
</html>