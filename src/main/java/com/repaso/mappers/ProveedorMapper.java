package com.repaso.mappers;

import java.util.ArrayList;
import java.util.List;

import com.repaso.dto.ProveedorDto;
import com.repaso.model.ProveedorModel;

public class ProveedorMapper {

	//dto ---------> model
	public static ProveedorModel createModel(ProveedorDto pd) {
		return new ProveedorModel(pd.getNombre(), pd.getDireccion(), pd.getTelefono());
	}
	
	//model------------> dto
	public static ProveedorDto createDto(ProveedorModel pm) {
		return new ProveedorDto(pm.getNombre(), pm.getDireccion(), pm.getTelefono());
	}
	
	//model list ----------> dto list
	public static List<ProveedorDto> toDtoList(List<ProveedorModel> lpm){
		List<ProveedorDto> lpd = new ArrayList<ProveedorDto>();
		
		for(ProveedorModel pm : lpm) {
			lpd.add(createDto(pm));
		}
		
		return lpd;
	}
	
}
