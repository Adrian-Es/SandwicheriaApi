package com.repaso.mappers;

import java.util.ArrayList;
import java.util.List;

import com.repaso.dto.IngredienteDto;
import com.repaso.model.IngredienteModel;

public class IngredienteMapper {
	
	// dto -----> object
	public static IngredienteModel createIngredienteModel(IngredienteDto id) {
		return new IngredienteModel(id.getNombre());
	}
	
	// object ------------>dto
	public static IngredienteDto createIngredienteDto(IngredienteModel im) {
		return new IngredienteDto(im.getNombre(), im.getCantidadTotal());
	}
	
	//object list --------> dto list
	public static List<IngredienteDto> createIngredienteDtoList(List<IngredienteModel> lim){
		List<IngredienteDto> lid = new ArrayList<IngredienteDto>();
		
		for(IngredienteModel im : lim) {
			lid.add(createIngredienteDto(im));
		}
		
		return lid;
	}
}
