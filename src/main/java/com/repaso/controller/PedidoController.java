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
	private PedidoService pService;
	@Autowired
	private SanguchesPedidoService sPedidoService;
	@Autowired
	private DetalleSangucheService dsService;
	
	@Autowired
	private IngredienteService iService;
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody PedidosCompletosDto pcd) throws Exception{
		if(pcd.getSanguches()==null || pcd.getSanguches().isEmpty()) throw new Exception("Error: el pedido esta vacio");
		
		try {
			PedidoModel pModel = PedidosMappers.createPedidoModel(pcd); 
			pService.create(pModel);
			
			PedidosMapperFunc.createRegisterSanguchesPedidos(pcd.getSanguches(), sPedidoService, pModel, dsService, iService);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidosCompletosDto> findById(@PathVariable(name = "id") Integer id) throws Exception{
		PedidoModel pModel = pService.findById(id);
		
		if(pModel==null) throw new Exception("Error: el pedido que busca no existe");
		
		PedidosCompletosDto pcd = PedidosMappers.createPedidosCompletosDto(pModel);
		
		return new ResponseEntity<PedidosCompletosDto>(pcd,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PedidosCompletosDto>> findAll(){
		List<PedidosCompletosDto> lpcd = PedidosMappers.createListPedidosCompletosDtos(pService.findAll());
		
		return new ResponseEntity<List<PedidosCompletosDto>>(lpcd, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Integer id) throws Exception{
		if(pService.findById(id)==null) throw new Exception("Error: el pedido que quiere eliminar no existe");
		pService.deleteById(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
