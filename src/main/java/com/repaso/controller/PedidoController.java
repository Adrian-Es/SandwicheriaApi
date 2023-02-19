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

import com.repaso.dto.PedidosCompletosDto;
import com.repaso.funciones.PedidosMapperFunc;
import com.repaso.mappers.PedidosMappers;
import com.repaso.model.PedidoModel;
import com.repaso.service.DetalleSangucheService;
import com.repaso.service.IngredienteService;
import com.repaso.service.PedidoService;
import com.repaso.service.SanguchesPedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private SanguchesPedidoService sanguchesPedidoService;
	@Autowired
	private DetalleSangucheService detalleSangucheService;

	@Autowired
	private IngredienteService ingredienteService;

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody PedidosCompletosDto pedidosCompletosDto) throws Exception {
		if (pedidosCompletosDto.getSanguches() == null || pedidosCompletosDto.getSanguches().isEmpty())
			throw new Exception("Error: el pedido esta vacio");

		try {
			PedidoModel pedidoModel = PedidosMappers.createPedidoModel(pedidosCompletosDto);
			pedidoService.create(pedidoModel);

			PedidosMapperFunc.createRegisterSanguchesPedidos(pedidosCompletosDto.getSanguches(), sanguchesPedidoService,
					pedidoModel, detalleSangucheService, ingredienteService);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidosCompletosDto> findById(@PathVariable(name = "id") Integer id) throws Exception {
		PedidoModel pedidoModel = pedidoService.findById(id);

		if (pedidoModel == null)
			throw new Exception("Error: el pedido que busca no existe");

		PedidosCompletosDto pcd = PedidosMappers.createPedidosCompletosDto(pedidoModel);

		return new ResponseEntity<PedidosCompletosDto>(pcd, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PedidosCompletosDto>> findAll() {
		List<PedidosCompletosDto> pedidosCompletosDtoList = PedidosMappers
				.createListPedidosCompletosDtos(pedidoService.findAll());

		return new ResponseEntity<List<PedidosCompletosDto>>(pedidosCompletosDtoList, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Integer id) throws Exception {
		if (pedidoService.findById(id) == null)
			throw new Exception("Error: el pedido que quiere eliminar no existe");
		pedidoService.deleteById(id);

		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
