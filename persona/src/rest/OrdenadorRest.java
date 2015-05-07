package rest;

import java.util.ArrayList;
import java.util.List;

import model.Ordenador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.response.JsonResponse;
import rest.response.OrdenadorResponse;
import service.OrdenadorService;

@RestController
@RequestMapping("/api/ordenadores")
public class OrdenadorRest {
	@Autowired
	private OrdenadorService ordenadorService;
	
	/**
	 * GET http://localhost:8080/persona/api/ordenadores.do
	 * Header: Accept: application/json
	 */
	@RequestMapping(value="", produces="application/json", method=RequestMethod.GET)
	public @ResponseBody JsonResponse obtenerTodos() {
		List<OrdenadorResponse> resultado = new ArrayList<OrdenadorResponse>();
		List<Ordenador> ordenadores = ordenadorService.obtenerOrdenadores();
		
		if (ordenadores != null) for (Ordenador o : ordenadores)
			resultado.add(OrdenadorResponse.build(o));
		
		// TODO Incluir validaciones
		return JsonResponse.success(resultado);
	}
	
	/**
	 * GET http://localhost:8080/persona/api/ordenadores/1.do
	 * Header: Accept: application/json
	 */
	@RequestMapping(value="/{id}", produces="application/json", method=RequestMethod.GET)
	public @ResponseBody JsonResponse obtener(@PathVariable Integer id) {
		// TODO Incluidar validaciones
		return JsonResponse.success(OrdenadorResponse
				.build(ordenadorService.obtenerOrdenador(id)));
	}

	/**
	 * POST http://localhost:8080/persona/api/ordenadores.do
	 * Header: Accept: application/json
	 * Header: Content-type: application/json
	 * {
	 * 	"nombre": "tres",
	 * 	"serial": "123",
	 * 	"persona": {
	 * 		"id": 1
	 * 	}
	 * }
	 */
	@RequestMapping(value="",
			consumes="application/json",
			produces="application/json", 
			method=RequestMethod.POST)
	public @ResponseBody JsonResponse agregar(@RequestBody Ordenador ordenador) {
		try {
			ordenadorService.agregarOrdenador(ordenador);
			// TODO Incluir validaciones
			return JsonResponse.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Incluir validaciones
			return JsonResponse.error(e.getMessage());
		}
		
	}

	/**
	 * PUT http://localhost:8080/persona/api/ordenadores/1.do
	 * Header: Accept: application/json
	 * Header: Content-type: application/json
	 * {
	 * 	"nombre": "tres",
	 * 	"serial": "123",
	 * 	"persona": {
	 * 		"id": 1
	 * 	}
	 * }
	 */
	@RequestMapping(value="/{id}",
			consumes="application/json",
			produces="application/json", 
			method=RequestMethod.PUT)
	public @ResponseBody JsonResponse modificar(
			@PathVariable Integer id,
			@RequestBody Ordenador ordenador) {
		try {
			ordenador.setId(id);
			ordenadorService.modificarOrdenador(ordenador);
			// TODO Incluir validaciones
			return JsonResponse.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Incluir validaciones
			return JsonResponse.error(e.getMessage());
		}
		
	}

	/**
	 * DELETE http://localhost:8080/persona/api/ordenadores/1.do
	 * Header: Accept: application/json
	 */
	@RequestMapping(value="/{id}",
			produces="application/json", 
			method=RequestMethod.DELETE)
	public @ResponseBody JsonResponse eliminar(
			@PathVariable Integer id) {
		try {
			ordenadorService.eliminarOrdenador(id);
			// TODO Incluir validaciones
			return JsonResponse.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Incluir validaciones
			return JsonResponse.error(e.getMessage());
		}
		
	}

}




