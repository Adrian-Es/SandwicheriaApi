package com.repaso.mappers;

import java.util.ArrayList;
import java.util.List;

import com.repaso.dto.ProveedorDto;
import com.repaso.model.ProveedorModel;

public class ProveedorMapper {

	// dto ---------> model
	public static ProveedorModel createModel(ProveedorDto proveedorDto) {
		return new ProveedorModel(proveedorDto.getNombre(), proveedorDto.getDireccion(), proveedorDto.getTelefono());
	}

	// model------------> dto
	public static ProveedorDto createDto(ProveedorModel proveedorModel) {
		return new ProveedorDto(proveedorModel.getNombre(), proveedorModel.getDireccion(),
				proveedorModel.getTelefono());
	}

	// model list ----------> dto list
	public static List<ProveedorDto> toDtoList(List<ProveedorModel> listProveedorModel) {
		List<ProveedorDto> listProveedorDto = new ArrayList<ProveedorDto>();

		for (ProveedorModel proveedorModel : listProveedorModel) {
			listProveedorDto.add(createDto(proveedorModel));
		}

		return listProveedorDto;
	}

}
