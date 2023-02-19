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

public class RepartosMappers {

	// dto -------> model

		public static RepartosModel createRepartosModel(RepartosCompletosDto repartosCompletosDto,
				ProveedorModel proveedorModel) throws Exception {
			return new RepartosModel(proveedorModel,
					RepartosMapperFunc.convertStringToLocalDate(repartosCompletosDto.getFecha()),
					RepartosMapperFunc.calcularCosteTotal(repartosCompletosDto.getDetalles()));
		}

		public static DetalleRepartosModel createDetalleRepartosModel(DetalleRepartosBasicoDto detalleRepartosBasicoDto,
				RepartosModel repartosModel, IngredienteModel ingredienteModel) throws Exception {
			return new DetalleRepartosModel(repartosModel, ingredienteModel, detalleRepartosBasicoDto.getCantidad(),
					detalleRepartosBasicoDto.getCoste());
		}

		// model --------> dto
		public static RepartosCompletosDto createRepartosDto(RepartosModel repartosModel) {
			RepartosCompletosDto repartosCompletosDto = new RepartosCompletosDto(repartosModel.getProveedor().getId(),
					repartosModel.getFecha().toString(), null);

			HashSet<DetalleRepartosBasicoDto> detalles = createDetalleRepartoDto(repartosModel.getDetalles());

			repartosCompletosDto.setDetalles(detalles);

			return repartosCompletosDto;
		}

		public static DetalleRepartosBasicoDto createDetalleRepartosBasicoDto(DetalleRepartosModel detalleRepartosModel) {
			return new DetalleRepartosBasicoDto(detalleRepartosModel.getIngrediente().getId(),
					detalleRepartosModel.getCantidad(), detalleRepartosModel.getCoste());
		}

		// model set --------> dto set
		public static HashSet<DetalleRepartosBasicoDto> createDetalleRepartoDto(Set<DetalleRepartosModel> detalles) {
			HashSet<DetalleRepartosBasicoDto> setDetalleRepartosBasicoDto = new HashSet<DetalleRepartosBasicoDto>();

			for (DetalleRepartosModel detalleRepartosModel : detalles) {
				try {
					setDetalleRepartosBasicoDto.add(createDetalleRepartosBasicoDto(detalleRepartosModel));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			return setDetalleRepartosBasicoDto;
		}

		// model list -----------> dto list
		public static List<RepartosCompletosDto> toDtoList(List<RepartosModel> listRepartosModel) {
			List<RepartosCompletosDto> listRepartosCompletosDto = new ArrayList<>();

			for (RepartosModel repartosModel : listRepartosModel) {
				listRepartosCompletosDto.add(createRepartosDto(repartosModel));
			}

			return listRepartosCompletosDto;
		}
	
}
