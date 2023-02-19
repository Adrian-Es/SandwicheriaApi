package com.repaso.mappers;

import java.util.ArrayList;
import java.util.List;

import com.repaso.dto.IngredienteDto;
import com.repaso.model.IngredienteModel;

public class IngredienteMapper {

	// dto -----> object
	public static IngredienteModel createIngredienteModel(IngredienteDto ingredienteDto) {
		return new IngredienteModel(ingredienteDto.getNombre());
	}

	// object ------------>dto
	public static IngredienteDto createIngredienteDto(IngredienteModel ingredienteModel) {
		return new IngredienteDto(ingredienteModel.getNombre(), ingredienteModel.getCantidadTotal());
	}

	// object list --------> dto list
	public static List<IngredienteDto> createIngredienteDtoList(List<IngredienteModel> listIngredienteModel) {
		List<IngredienteDto> listIngredienteDto = new ArrayList<IngredienteDto>();

		for (IngredienteModel ingredienteModel : listIngredienteModel) {
			listIngredienteDto.add(createIngredienteDto(ingredienteModel));
		}

		return listIngredienteDto;
	}
}
