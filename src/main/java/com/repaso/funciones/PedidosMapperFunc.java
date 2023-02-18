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
	
	//resta los ingredientes en la base de datos cada vez que se usen en un pedido
	public static void updateCantidadTotalIngrediente(IngredienteService is, IngredienteModel im,
			Integer cantidadAdicional) throws Exception {
		Integer cant = im.getCantidadTotal() - cantidadAdicional;
		if(cant<0) throw new Exception("Error: este ingrediente no se puede brindar en la cantidad pedida");
		im.setCantitadTotal(cant);
		is.update(im);
	}

	// crear registros de sanguchespedidos y detalle sanguche en la bd

	public static void createRegisterSanguchesPedidos(Set<SanguchesPedidoDto> hspd, SanguchesPedidoService sps,
			PedidoModel pModel, DetalleSangucheService dsd, IngredienteService is) {
		for (SanguchesPedidoDto spd : hspd) {
			SanguchesPedidoModel spm = PedidosMappers.createSanguchesPedidoModel(pModel);

			sps.create(spm);

			createRegisterDetalleSanguche(spd.getDetalles(), dsd, spm, is);
		}
	}

	public static void createRegisterDetalleSanguche(Set<DetalleSangucheDto> hdsd, DetalleSangucheService dss,
			SanguchesPedidoModel spm, IngredienteService is) {
		for (DetalleSangucheDto d : hdsd) {
			try {
				IngredienteModel iModel = is.findById(d.getIdIngrediente());
				
				if(iModel==null) throw new Exception("Error: el ingrediente que trata de ingresar no existe");
				
				updateCantidadTotalIngrediente(is, iModel, d.getCantidad());
				
				DetalleSangucheModel dsm = PedidosMappers.createDetalleSangucheModel(d.getCantidad(), spm, iModel);
				
				dss.create(dsm);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		}
	}
}
