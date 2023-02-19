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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.repaso.dto.ProveedorDto;
import com.repaso.mappers.ProveedorMapper;
import com.repaso.model.ProveedorModel;
import com.repaso.service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	@Autowired
	private ProveedorService proveedorService;

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody ProveedorDto proveedor) {
		ProveedorModel proveedorModel = ProveedorMapper.createModel(proveedor);
		proveedorService.create(proveedorModel);

		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestParam ProveedorDto proveedor, @PathVariable(name = "id") Integer id)
			throws Exception {

		ProveedorModel proveedorGetId = proveedorService.findByID(id);

		if (proveedorGetId == null)
			throw new Exception("El proveedor que trata de actualizar no existe");

		ProveedorModel proveedorModel = ProveedorMapper.createModel(proveedor);

		proveedorModel.setId(proveedorGetId.getId());

		proveedorService.create(proveedorModel);

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProveedorDto>> findAll() {
		return new ResponseEntity<List<ProveedorDto>>(ProveedorMapper.toDtoList(proveedorService.findAll()),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProveedorDto> findById(@PathVariable(name = "id") Integer id) throws Exception {
		ProveedorModel proveedorModel = proveedorService.findByID(id);

		if (proveedorModel == null)
			throw new Exception("Error: este proveedor no existe");

		return new ResponseEntity<ProveedorDto>(ProveedorMapper.createDto(proveedorModel), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) throws Exception {
		if (proveedorService.findByID(id) == null)
			throw new Exception("Error: este proveedor no existe");
		proveedorService.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
