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
	private RepartoService rs;
	@Autowired
	private DetalleRepartoService drs;
	
	@Autowired
	private IngredienteService is;
	@Autowired
	private ProveedorService ps;

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody RepartosCompletosDto rcd) throws Exception {
		if (rcd.getDetalles() == null || rcd.getDetalles().isEmpty())
			throw new Exception("Error: El reparto esta vacio");

		try {
			RepartosModel rm = rs.create(RepartosMappers.createRepartosModel(rcd,ps));

			RepartosMapperFunc.createDetallesReparto(drs, rcd.getDetalles(), rm,is);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<Object>(HttpStatus.CREATED);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<RepartosCompletosDto> findById(@PathVariable(name = "id") Integer id) throws Exception {
		RepartosModel rModel = rs.findById(id);
		
		if(rModel==null)throw new Exception("Error: El reparto no existe");
		
		RepartosCompletosDto rcd = RepartosMappers.createRepartosDto(rModel);
		
		return new ResponseEntity<RepartosCompletosDto>(rcd,HttpStatus.OK);
	}
	
	@GetMapping(path = "/proveedor/{id}")
	public ResponseEntity<List<RepartosCompletosDto>> findByProveedor(@PathVariable(name ="id") Integer id){
		List<RepartosCompletosDto> lrcd = RepartosMappers.toDtoList(rs.repartosPorProveedor(id));
		
		return new ResponseEntity<List<RepartosCompletosDto>>(lrcd,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RepartosCompletosDto>> findAll(){
		List<RepartosCompletosDto> lrcd = RepartosMappers.toDtoList(rs.FindAll());
		
		return new ResponseEntity<List<RepartosCompletosDto>>(lrcd,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) throws Exception{
		if(rs.findById(id)==null) throw new Exception("Error: el reparto no existe");
		rs.deleteById(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
}
