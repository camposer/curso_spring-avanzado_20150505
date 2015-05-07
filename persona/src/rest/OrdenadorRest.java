package rest;

import java.util.ArrayList;
import java.util.List;

import model.Ordenador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.response.JsonResponse;
import rest.response.OrdenadorResponse;
import service.OrdenadorService;

@RestController
@RequestMapping("/api/ordenador/*")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class OrdenadorRest {
	@Autowired
	private OrdenadorService ordenadorService;
	
	/**
	 * GET http://localhost:8080/persona/api/ordenador/.do
	 */
	@RequestMapping(value="", produces="application/json", method=RequestMethod.GET)
	public @ResponseBody JsonResponse obtenerTodos() {
		List<OrdenadorResponse> resultado = new ArrayList<OrdenadorResponse>();
		List<Ordenador> ordenadores = ordenadorService.obtenerOrdenadores();
		
		if (ordenadores != null) for (Ordenador o : ordenadores)
			resultado.add(OrdenadorResponse.build(o));
		
		// TODO Incluir validaciones
		return new JsonResponse(JsonResponse.SUCCESS, resultado);
	}
	
	/**
	 * GET http://localhost:8080/persona/api/ordenador/1.do
	 */
//	@RequestMapping(value="{id}", produces="application/json", params="id", method=RequestMethod.GET)
//	public @ResponseBody JsonResponse obtener(@PathVariable Integer id) {
//		// TODO Incluidar validaciones
//		return new JsonResponse(JsonResponse.SUCCESS, 
//				OrdenadorResponse.build(ordenadorService.obtenerOrdenador(id)));
//	}

	/**
	 * POST http://localhost:8080/persona/api/ordenador/.do
	 * Header: Content-type: application/json
	 * {
	 * 	"nombre": "tres",
	 * 	"serial": "123",
	 * 	"persona": {
	 * 		"id": 1
	 * 	}
	 * }
	 * @param ordenador
	 * @return
	 */
	@RequestMapping(value="",
			consumes="application/json",
			produces="application/json", 
			method=RequestMethod.POST)
	public @ResponseBody JsonResponse agregar(@RequestBody Ordenador ordenador) {
		try {
			ordenadorService.agregarOrdenador(ordenador);
			// TODO Incluir validaciones
			return new JsonResponse(JsonResponse.SUCCESS, null);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Incluir validaciones
			return new JsonResponse(JsonResponse.ERROR, "Error!!!");
		}
		
	}

}




