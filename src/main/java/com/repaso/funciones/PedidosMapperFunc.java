package com.repaso.funciones;

import java.util.Set;

import com.repaso.dto.DetalleSangucheDto;
import com.repaso.dto.SanguchesPedidoDto;
import com.repaso.mappers.PedidosMappers;
import com.repaso.model.DetalleSangucheModel;
import com.repaso.model.IngredienteModel;
import com.repaso.model.PedidoModel;
import com.repaso.model.SanguchesPedidoModel;
import com.repaso.service.DetalleSangucheService;
import com.repaso.service.IngredienteService;
import com.repaso.service.SanguchesPedidoService;

public class PedidosMapperFunc {

	// resta los ingredientes en la base de datos cada vez que se usen en un pedido
	public static void updateCantidadTotalIngrediente(IngredienteService ingredienteService,
			IngredienteModel ingredienteModel, Integer cantidadAdicional) throws Exception {
		Integer cant = ingredienteModel.getCantidadTotal() - cantidadAdicional;
		if (cant < 0)
			throw new Exception("Error: este ingrediente no se puede brindar en la cantidad pedida");
		ingredienteModel.setCantitadTotal(cant);
		ingredienteService.update(ingredienteModel);
	}

	// crear registros de sanguchespedidos y detalle sanguche en la bd

	public static void createRegisterSanguchesPedidos(Set<SanguchesPedidoDto> setSanguchesPedidoDtos,
			SanguchesPedidoService sanguchesPedidoService, PedidoModel pedidoModel,
			DetalleSangucheService detalleSangucheService, IngredienteService ingredienteService) {

		for (SanguchesPedidoDto sanguchesPedidoDto : setSanguchesPedidoDtos) {
			SanguchesPedidoModel sanguchesPedidoModel = PedidosMappers.createSanguchesPedidoModel(pedidoModel);

			sanguchesPedidoService.create(sanguchesPedidoModel);

			createRegisterDetalleSanguche(sanguchesPedidoDto.getDetalles(), detalleSangucheService,
					sanguchesPedidoModel, ingredienteService);
		}
	}

	public static void createRegisterDetalleSanguche(Set<DetalleSangucheDto> setDetalleSangucheDto,
			DetalleSangucheService detalleSangucheService, SanguchesPedidoModel sanguchesPedidoModel,
			IngredienteService ingredienteService) {

		for (DetalleSangucheDto detalleSangucheDto : setDetalleSangucheDto) {
			try {
				IngredienteModel ingredienteModel = ingredienteService.findById(detalleSangucheDto.getIdIngrediente());

				if (ingredienteModel == null)
					throw new Exception("Error: el ingrediente que trata de ingresar no existe");

				updateCantidadTotalIngrediente(ingredienteService, ingredienteModel, detalleSangucheDto.getCantidad());

				DetalleSangucheModel dsm = PedidosMappers.createDetalleSangucheModel(detalleSangucheDto.getCantidad(),
						sanguchesPedidoModel, ingredienteModel);

				detalleSangucheService.create(dsm);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
