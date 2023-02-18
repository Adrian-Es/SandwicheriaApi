package com.repaso.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.repaso.dto.DetalleRepartosBasicoDto;
import com.repaso.dto.RepartosCompletosDto;
import com.repaso.funciones.RepartosMapperFunc;
import com.repaso.model.DetalleRepartosModel;
import com.repaso.model.IngredienteModel;
import com.repaso.model.ProveedorModel;
import com.repaso.model.RepartosModel;
import com.repaso.service.ProveedorService;

public class RepartosMappers {

	//dto -------> model
	
	public static RepartosModel createRepartosModel(RepartosCompletosDto rcd, ProveedorService ps) throws Exception {
		ProveedorModel pModel = ps.findByID(rcd.getId_proveedor());
		return new RepartosModel(pModel,RepartosMapperFunc.convertStringToLocalDate(rcd.getFecha()),
				RepartosMapperFunc.calcularCosteTotal(rcd.getDetalles()));
	}
	
	public static DetalleRepartosModel createDetalleRepartosModel(DetalleRepartosBasicoDto drbd, RepartosModel rModel, IngredienteModel iModel) throws Exception{
		return new DetalleRepartosModel(rModel, iModel, drbd.getCantidad(), drbd.getCoste());
	}
	
	//model --------> dto
	public static RepartosCompletosDto createRepartosDto(RepartosModel rModel) {
		RepartosCompletosDto rcd = new RepartosCompletosDto(rModel.getProveedor().getId(), rModel.getFecha().toString(), null);

		HashSet<DetalleRepartosBasicoDto> detalles = createDetalleRepartoDto(rModel.getDetalles());
		
		rcd.setDetalles(detalles);
		
		return rcd;
	}
	
	public static DetalleRepartosBasicoDto createDetalleRepartosBasicoDto(DetalleRepartosModel drm) {
		return new DetalleRepartosBasicoDto(drm.getIngrediente().getId(), drm.getCantidad(), drm.getCoste());
	}

	
	//model set --------> dto set
	public static HashSet<DetalleRepartosBasicoDto> createDetalleRepartoDto(Set<DetalleRepartosModel> detalles) {
		HashSet<DetalleRepartosBasicoDto> drbd = new HashSet<DetalleRepartosBasicoDto>();

		for (DetalleRepartosModel d : detalles) {
			try {
				drbd.add(createDetalleRepartosBasicoDto(d));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

		return drbd;
	}
	
	//model list -----------> dto list
	public static List<RepartosCompletosDto> toDtoList(List<RepartosModel> lrm){
		List<RepartosCompletosDto> lrcd = new ArrayList<>();
		
		for(RepartosModel rModel : lrm) {
			lrcd.add(createRepartosDto(rModel));
		}
		
		return lrcd;
	}
	
}
