<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</style>
</head>
<body>
	<h1>Personas</h1>
	<table id="form-persona" class="tabla-centrada">
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre"></td>
		</tr>
		<tr>
			<td>Apellido</td>
			<td><input type="text" name="apellido"></td>
		</tr>
		<tr>
			<td>Fecha de Nacimiento</td>
			<td><input type="text" name="fechaNacimiento"></td>
		</tr>
		<tr>
			<td colspan="2">		
				<input type="button" value="Modificar">
				<input type="button" value="Agregar">
			</td>
		</tr>
	</table>
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
		<tr>
			<td>1</td>
			<td>XXX</td>
			<td>YYY</td>
			<td>ZZZ</td>
			<td><a href="#">mostrar</a></td>
			<td><a href="#">eliminar</a></td>
		</tr>	
		<tr>
			<td>1</td>
			<td>XXX</td>
			<td>YYY</td>
			<td>ZZZ</td>
			<td><a href="#">mostrar</a></td>
			<td><a href="#">eliminar</a></td>
		</tr>	
		<tr>
			<td>1</td>
			<td>XXX</td>
			<td>YYY</td>
			<td>ZZZ</td>
			<td><a href="#">mostrar</a></td>
			<td><a href="#">eliminar</a></td>
		</tr>	
	</table>
	
	
</body>
</html>