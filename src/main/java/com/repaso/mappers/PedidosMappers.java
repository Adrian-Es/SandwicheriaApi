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

	public static DetalleSangucheModel createDetalleSangucheModel(Integer cantidad,
			SanguchesPedidoModel sanguchesPedidoModel, IngredienteModel ingredienteModel) throws Exception {
		return new DetalleSangucheModel(sanguchesPedidoModel, ingredienteModel, cantidad);
	}

	public static SanguchesPedidoModel createSanguchesPedidoModel(PedidoModel pedidoModel) {
		return new SanguchesPedidoModel(pedidoModel);
	}

	public static PedidoModel createPedidoModel(PedidosCompletosDto pedidosCompletosDto) {
		PedidoModel pModel = new PedidoModel(pedidosCompletosDto.getDireccionEntrega(),
				RepartosMapperFunc.convertStringToLocalDate(pedidosCompletosDto.getFecha()));

		return pModel;
	}

	// model ----> dto

	public static DetalleSangucheDto createDetalleSangucheDto(DetalleSangucheModel detalleSangucheModel) {
		return new DetalleSangucheDto(detalleSangucheModel.getIngrediente().getId(),
				detalleSangucheModel.getCantidad());
	}

	public static SanguchesPedidoDto createSanguchesPedidoDto(SanguchesPedidoModel sanguchesPedidoModel) {
		return new SanguchesPedidoDto(createSetDetalleSangucheDto(sanguchesPedidoModel.getDetallesSanguche()));
	}

	public static PedidosCompletosDto createPedidosCompletosDto(PedidoModel pedidoModel) {
		return new PedidosCompletosDto(pedidoModel.getDireccionEntrega(), pedidoModel.getFecha().toString(),
				createSetSanguchesPedidoDtos(pedidoModel.getSanguches()));
	}

	// model set --------> dto set

	public static Set<DetalleSangucheDto> createSetDetalleSangucheDto(
			Set<DetalleSangucheModel> setDetalleSangucheModel) {
		Set<DetalleSangucheDto> setDetalleSangucheDtos = new HashSet<DetalleSangucheDto>();

		for (DetalleSangucheModel detalleSangucheModel : setDetalleSangucheModel) {
			setDetalleSangucheDtos.add(createDetalleSangucheDto(detalleSangucheModel));
		}

		return setDetalleSangucheDtos;
	}

	// dto set------------> model set
	public static Set<SanguchesPedidoDto> createSetSanguchesPedidoDtos(
			Set<SanguchesPedidoModel> setSanguchesPedidoModel) {
		Set<SanguchesPedidoDto> setSanguchesPedidoDto = new HashSet<SanguchesPedidoDto>();

		for (SanguchesPedidoModel sanguchesPedidoModel : setSanguchesPedidoModel) {
			setSanguchesPedidoDto.add(createSanguchesPedidoDto(sanguchesPedidoModel));
		}

		return setSanguchesPedidoDto;
	}

	// model list -------> dto list
	public static List<PedidosCompletosDto> createListPedidosCompletosDtos(List<PedidoModel> listPedidoModel) {
		List<PedidosCompletosDto> listPedidosCompletosDto = new ArrayList<PedidosCompletosDto>();

		for (PedidoModel pedidoModel : listPedidoModel) {
			listPedidosCompletosDto.add(createPedidosCompletosDto(pedidoModel));
		}

		return listPedidosCompletosDto;
	}
}
