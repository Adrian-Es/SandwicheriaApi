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

import com.repaso.dto.IngredienteDto;
import com.repaso.mappers.IngredienteMapper;
import com.repaso.model.IngredienteModel;
import com.repaso.service.IngredienteService;

@Controller
@RequestMapping(path = "/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteService is;

	@PostMapping()
	public ResponseEntity<IngredienteModel> create(@RequestBody IngredienteDto ingrediente) {
		IngredienteModel im = IngredienteMapper.createIngredienteModel(ingrediente);

		return new ResponseEntity<IngredienteModel>(is.create(im), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> update(@RequestBody IngredienteDto ingrediente,
			@PathVariable(name = "id") Integer id) throws Exception {
		IngredienteModel getId = is.findById(id);

		if (getId == null)
			throw new Exception("El ingrediente que trata de acutalizar no existe.");

		IngredienteModel im = IngredienteMapper.createIngredienteModel(ingrediente);
		im.setId(getId.getId());
		
		is.update(im);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<IngredienteDto>> findAll() {
		return new ResponseEntity<List<IngredienteDto>>(IngredienteMapper.createIngredienteDtoList(is.findAll()),
				HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<IngredienteDto> findById(@PathVariable(name = "id") Integer id) throws Exception {
		IngredienteModel ingrediente = is.findById(id);

		if (ingrediente == null)
			throw new Exception("El ingrediente que estas tratando de encontrar no existe");

		return new ResponseEntity<IngredienteDto>(IngredienteMapper.createIngredienteDto(ingrediente), HttpStatus.OK);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) throws Exception {
		if (is.findById(id) == null)
			throw new Exception("Error: el ingrediente que queres eliminar no existe");
		is.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
