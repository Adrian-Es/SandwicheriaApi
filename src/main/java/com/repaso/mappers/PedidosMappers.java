package com.repaso.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.repaso.dto.DetalleSangucheDto;
import com.repaso.dto.PedidosCompletosDto;
import com.repaso.dto.SanguchesPedidoDto;
import com.repaso.funciones.RepartosMapperFunc;
import com.repaso.model.DetalleSangucheModel;
import com.repaso.model.IngredienteModel;
import com.repaso.model.PedidoModel;
import com.repaso.model.SanguchesPedidoModel;

public class PedidosMappers {
	// dto ----> model

	public static DetalleSangucheModel createDetalleSangucheModel(Integer cantidad , SanguchesPedidoModel spm, IngredienteModel im)
			throws Exception {
		return new DetalleSangucheModel(spm, im,cantidad);
	}

	public static SanguchesPedidoModel createSanguchesPedidoModel(PedidoModel pModel) {
		return new SanguchesPedidoModel(pModel);
	}

	public static PedidoModel createPedidoModel(PedidosCompletosDto pcd) {
		PedidoModel pModel = new PedidoModel(pcd.getDireccionEntrega(), RepartosMapperFunc.convertStringToLocalDate(pcd.getFecha()));

		return pModel;
	}

	// model ----> dto

	public static DetalleSangucheDto createDetalleSangucheDto(DetalleSangucheModel dsm) {
		return new DetalleSangucheDto(dsm.getIngrediente().getId(), dsm.getCantidad());
	}

	public static SanguchesPedidoDto createSanguchesPedidoDto(SanguchesPedidoModel spm) {
		return new SanguchesPedidoDto(createSetDetalleSangucheDto(spm.getDetallesSanguche()));
	}

	public static PedidosCompletosDto createPedidosCompletosDto(PedidoModel pModel) {
		return new PedidosCompletosDto(pModel.getDireccionEntrega(), pModel.getFecha().toString(),
				createSetSanguchesPedidoDtos(pModel.getSanguches()));
	}

	// model set --------> dto set

	public static Set<DetalleSangucheDto> createSetDetalleSangucheDto(Set<DetalleSangucheModel> set) {
		Set<DetalleSangucheDto> hdsd = new HashSet<DetalleSangucheDto>();

		for (DetalleSangucheModel d : set) {
			hdsd.add(createDetalleSangucheDto(d));
		}

		return hdsd;
	}

	
	//dto set------------> model set
	public static Set<SanguchesPedidoDto> createSetSanguchesPedidoDtos(Set<SanguchesPedidoModel> set) {
		Set<SanguchesPedidoDto> hspd = new HashSet<SanguchesPedidoDto>();

		for (SanguchesPedidoModel s : set) {
			hspd.add(createSanguchesPedidoDto(s));
		}

		return hspd;
	}
	
	//model list -------> dto list
	public static List<PedidosCompletosDto> createListPedidosCompletosDtos(List<PedidoModel> lpm){
		List<PedidosCompletosDto> lpcd = new ArrayList<PedidosCompletosDto>();
		
		for(PedidoModel pModel : lpm) {
			lpcd.add(createPedidosCompletosDto(pModel));
		}
		
		return lpcd;
	}
}
