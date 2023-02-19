package com.repaso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.repaso.dto.RepartosCompletosDto;
import com.repaso.funciones.RepartosMapperFunc;
import com.repaso.mappers.RepartosMappers;
import com.repaso.model.RepartosModel;
import com.repaso.service.DetalleRepartoService;
import com.repaso.service.IngredienteService;
import com.repaso.service.ProveedorService;
import com.repaso.service.RepartoService;

@Controller
@RequestMapping("/repartos")
public class RepartosCompletosController {

	@Autowired
	private RepartoService repartoService;
	@Autowired
	private DetalleRepartoService detalleRepartoService;

	@Autowired
	private IngredienteService ingredienteService;
	@Autowired
	private ProveedorService proveedorService;

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody RepartosCompletosDto repartosCompletosDto) throws Exception {
		if (repartosCompletosDto.getDetalles() == null || repartosCompletosDto.getDetalles().isEmpty())
			throw new Exception("Error: El reparto esta vacio");

		try {
			RepartosModel repartosModel = repartoService.create(RepartosMappers.createRepartosModel(
					repartosCompletosDto, proveedorService.findByID(repartosCompletosDto.getId_proveedor())));

			RepartosMapperFunc.createDetallesReparto(detalleRepartoService, repartosCompletosDto.getDetalles(),
					repartosModel, ingredienteService);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<Object>(HttpStatus.CREATED);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<RepartosCompletosDto> findById(@PathVariable(name = "id") Integer id) throws Exception {
		RepartosModel repartosModel = repartoService.findById(id);

		if (repartosModel == null)
			throw new Exception("Error: El reparto no existe");

		RepartosCompletosDto repartosCompletosDto = RepartosMappers.createRepartosDto(repartosModel);

		return new ResponseEntity<RepartosCompletosDto>(repartosCompletosDto, HttpStatus.OK);
	}

	@GetMapping(path = "/proveedor/{id}")
	public ResponseEntity<List<RepartosCompletosDto>> findByProveedor(@PathVariable(name = "id") Integer id) {
		List<RepartosCompletosDto> listRepartosCompletosDtos = RepartosMappers
				.toDtoList(repartoService.repartosPorProveedor(id));

		return new ResponseEntity<List<RepartosCompletosDto>>(listRepartosCompletosDtos, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<RepartosCompletosDto>> findAll() {
		List<RepartosCompletosDto> listRepartosCompletosDtos = RepartosMappers.toDtoList(repartoService.FindAll());

		return new ResponseEntity<List<RepartosCompletosDto>>(listRepartosCompletosDtos, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) throws Exception {
		if (repartoService.findById(id) == null)
			throw new Exception("Error: el reparto no existe");
		repartoService.deleteById(id);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}
}