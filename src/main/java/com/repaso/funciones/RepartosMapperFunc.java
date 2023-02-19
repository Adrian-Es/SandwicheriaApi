package com.repaso.funciones;

import java.time.LocalDate;
import java.util.Set;

import com.repaso.dto.DetalleRepartosBasicoDto;
import com.repaso.mappers.RepartosMappers;
import com.repaso.model.IngredienteModel;
import com.repaso.model.RepartosModel;
import com.repaso.service.DetalleRepartoService;
import com.repaso.service.IngredienteService;

public class RepartosMapperFunc {

	// se calcula el coste total del reparto ingresado
	public static Float calcularCosteTotal(Set<DetalleRepartosBasicoDto> detalles) {
		float cont = 0f;

		for (DetalleRepartosBasicoDto d : detalles) {
			cont += d.getCantidad().floatValue() * d.getCoste().floatValue();
		}
		return Float.valueOf(cont);
	}

	// se agrega en la bd la cantidad de ingredientes recibidos
	public static void updateCantidadTotalIngrediente(IngredienteService ingredienteService,
			IngredienteModel ingredienteModel, Integer cantidadAdicional) {
		ingredienteModel.setCantitadTotal(ingredienteModel.getCantidadTotal() + cantidadAdicional);
		ingredienteService.update(ingredienteModel);
	}

	// crea los registros de la tabla detalle_reparto
	public static void createDetallesReparto(DetalleRepartoService detalleRepartoService,
			Set<DetalleRepartosBasicoDto> detalles, RepartosModel repartosModel,
			IngredienteService ingredienteService) {

		for (DetalleRepartosBasicoDto d : detalles) {

			try {
				IngredienteModel ingredienteModel = ingredienteService.findById(d.getId_ingrediente());
				updateCantidadTotalIngrediente(ingredienteService, ingredienteModel, d.getCantidad());
				detalleRepartoService
						.create(RepartosMappers.createDetalleRepartosModel(d, repartosModel, ingredienteModel));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// convertir string a Date
	public static LocalDate convertStringToLocalDate(String fecha) {
		// año, mes, dia
		String[] valores = fecha.split("/");
		return LocalDate.of(Integer.valueOf(valores[0]).intValue(), Integer.valueOf(valores[1]).intValue(),
				Integer.valueOf(valores[2]).intValue());
	}
}
